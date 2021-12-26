package com.tour.edu.ctrl;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.ParseException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.tour.edu.model.service.IMyTourBookService;
import com.tour.edu.model.service.IMyTourDataService;
import com.tour.edu.vo.MyTourBookVo;
import com.tour.edu.vo.MyTourDataVo;

@Controller
public class MyTourBookController {
	
	private Logger logger = LoggerFactory.getLogger(this.getClass());
	
	@Autowired
	private IMyTourBookService bookservice;
	@Autowired 
	private IMyTourDataService dataService;
	
	@RequestMapping(value = "/myBookTourList.do", method = RequestMethod.GET)
	public String MyTourBookList(Model model) {
		logger.info("MyTourBookController MyTourBookList 실행");
		List<MyTourBookVo> myTourBookList=bookservice.MyTourSelectAll();
		model.addAttribute("myTourBookList", myTourBookList);
		return "service/myTourBookList";
	}
	
	
	@RequestMapping(value = "/myTourBookDetail.do", method =  RequestMethod.GET)
	public String myBookTourdetail(Model model, String bookNo) {
		logger.info("MyTourBookController myBookTourdetail 실행");
		int no = Integer.parseInt(bookNo);
		List<MyTourDataVo> myTourDatalists=dataService.MyTourDataBookNo(no);
		model.addAttribute("myTourDatalists", myTourDatalists);
		model.addAttribute("bookNo", bookNo);		
		return "service/myTourBookDetail";
	}
	
	@RequestMapping(value = "/myTourbookTitleSerach.do", method =  RequestMethod.POST)
	@ResponseBody
	public JSONArray MyTourBookTitleSerach2(Model model,String title) throws ParseException, JsonProcessingException {
		logger.info("MyTourBookController MyTourBookTitleSerach 실행");
		List<MyTourBookVo> myTourBookList= bookservice.MyTourBookSelectTitle(title);
		ObjectMapper objectMapper = new ObjectMapper();
		JSONArray json= new JSONArray();
		for (MyTourBookVo myTourBookVo : myTourBookList) {
			String studentJson = objectMapper.writeValueAsString(myTourBookVo);
			json.add(studentJson);
		}
		System.out.println(json.toString());
		return json;
	}
	
	@RequestMapping(value="/myTourBookInsertForm.do" , method= RequestMethod.GET)
	public String myTourBookInsertForm() {
		logger.info("MyTourBookController myTourBookInsertForm 실행");
		return "service/myTourBookForm";
	}
	
	@RequestMapping(value="/myTourBookInsert.do" , method= RequestMethod.GET)
	public String myTourBookInsert(Model model, MyTourBookVo myTourBookvo ,HttpSession session) {
		logger.info("MyTourBookController myTourBookInsert 실행");		
		logger.info("myTourBookvo값 {}", myTourBookvo.toString());
		//myTourBookvo.setAurthor(session.getAttribute(username));
		myTourBookvo.setAurthor("User1");
		bookservice.MyTourBookInsert(myTourBookvo);
		return "redirect:/myBookTourList.do";
	}
	
	@RequestMapping(value="/myTourDataInsertForm.do" , method= RequestMethod.GET)
	public String myTourDataInsertForm(Model model, String bookNo) {
		logger.info("MyTourBookController myTourDataInsertForm 실행");		
		model.addAttribute("bookNo", bookNo);	
		return "service/myTourDataInsertForm";
	}
	
	@RequestMapping(value="/myTourDataInsert.do", method=RequestMethod.POST)
	public String myTourDataInsert(Model model,String[] check,int codeId,int detailCodeId,HttpServletRequest request) {
		logger.info("MyTourBookController myTourDataInsert 실행");	
		int no=Integer.parseInt(request.getParameter("bookNo"));
		if(check!=null) {
			for (int i = 0; i < check.length; i++) {
				String str= check[i];
				String[] array = str.split(":");
				MyTourDataVo vo= new MyTourDataVo();
				vo.setName(array[1]);
				vo.setAttrLoc1(codeId);
				vo.setAttrLoc2(codeId);
				vo.setBookNo(no);
				vo.setContentId(Integer.parseInt(array[0]));
				System.out.println("@@@@@@@@@@@@@@@@@@@@@ vo"+vo.toString());
				dataService.MyTourDataInsert(vo);
			}
		}
		model.addAttribute("bookNo", no);	
		return "redirect:/myTourBookDetail.do";
	}
	
	
	@PostMapping(value="/myTourDataDelete.do")
	@ResponseBody
	public Map<String,Object> myTourDataDelete(Model model,
			@RequestParam(value="check[]")	List<String> check,int bookNo) {//,String[] tourOrder
		logger.info("MyTourBookController myTourDataDelete 실행");	
		logger.info("MyTourBookController bookNo {}", bookNo);
		if(check==null) {
			logger.info("check된 항목이 없습니다.");
		}else {
			for (int i = 0; i < check.size(); i++) {
				dataService.MyTourDataDeleteDataNo(Integer.parseInt(check.get(i)));
			}
		}
		
		model.addAttribute("bookNo", bookNo);
		List<MyTourDataVo> listVo=dataService.MyTourDataBookNo(bookNo);
		Map<String,Object> map = new HashMap<String, Object>();
		map.put("list", listVo);
		System.out.println(map.get("list"));
		return map;
	}
	
	@RequestMapping(value="/myTourDataTourOrder.do", method = RequestMethod.POST)
	public String myTourDataTourOrder(Model model, int[] tourOrder,int[] dataNo,int bookNo) {
		logger.info("MyTourBookController myTourDataTourOrder 실행 {}", tourOrder);
		for (int i = 0; i < tourOrder.length; i++) {
			MyTourDataVo vo= new MyTourDataVo();
			vo.setTourOrder(tourOrder[i]);
			vo.setDataNo(dataNo[i]);
			dataService.MyTourDataTourOrderUpdate(vo);
		}
		
		model.addAttribute("bookNo", bookNo);
		
		return  "redirect:/myTourBookDetail.do";
	}
}
