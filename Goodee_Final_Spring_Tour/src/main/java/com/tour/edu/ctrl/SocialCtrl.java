package com.tour.edu.ctrl;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.tour.edu.model.service.IPostService;

@Controller
public class SocialCtrl {
		
	private Logger logger = LoggerFactory.getLogger(this.getClass());
	
	@Autowired
	private IPostService service;
	
	
	@RequestMapping(value = "/postSelect.do", method = RequestMethod.GET)
	public String postSelect(Model model, String topic) {
		System.out.println(topic);
		if(topic == "user") {			
			model.addAttribute("postList", service.postSelect(topic));
			return "social/postList";
		}if(topic == null) {
			model.addAttribute("postList", service.postSelect(""));
		}
		return "social/postList";
	}
}
