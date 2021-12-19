package com.tour.edu.ctrl;

import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.json.simple.JSONArray;
import org.json.simple.parser.ParseException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
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
	
	
	@RequestMapping(value = "/myBookTourDetail.do", method =  RequestMethod.GET)
	public String myBookTourdetail(Model model, String bookNo) {
		logger.info("MyTourBookController myBookTourdetail 실행");
		int no = Integer.parseInt(bookNo);
		List<MyTourDataVo> myTourDatalists=dataService.MyTourDataBookNo(no);
		model.addAttribute("myTourDatalists", myTourDatalists);
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
		return "redirect:/service/myBookTourList.do";
	}
	
	@RequestMapping(value="/myTourDataInsertForm.do" , method= RequestMethod.GET)
	public String myTourDataInsertForm() {
		
		return "service/myTourDataInsertForm";
	}
	@RequestMapping(value="/myTourDataInsert.do", method=RequestMethod.POST)
	public String myTourDataInsert(Model model, int[] check,int codeId,int detailCodeId,HttpServletRequest request) {
		int no=Integer.parseInt(request.getParameter("bookNo"));
		if(check!=null) {
			for (int i = 0; i < check.length; i++) {
				MyTourDataVo vo= new MyTourDataVo();
				vo.setAttrLoc1(codeId);
				vo.setAttrLoc2(codeId);
				vo.setBookNo(no);
				vo.setContentId(check[i]);
				dataService.MyTourDataInsert(vo);
			}
		}
		model.addAttribute("bookNo", no);	
		return "redirect:/myTourBookDetail.do";
	}
	
	@RequestMapping(value="/myTourDataDelete.do", method=RequestMethod.POST)
	public String myTourDataDelete(Model model,int[] check,String bookNo) {//,String[] tourOrder
		
		for (int i = 0; i < check.length; i++) {
			//System.out.println(check[i]);
			dataService.MyTourDataDeleteDataNo(check[i]);
		}
		model.addAttribute("bookNo", bookNo);
		
		return "redirect:/myTourBookDetail.do";
	}
	
	
}
