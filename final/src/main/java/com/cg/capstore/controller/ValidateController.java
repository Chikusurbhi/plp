package com.cg.capstore.controller;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.cg.capstore.dao.IUserDAO;


@Controller
@RequestMapping("controller")
public class ValidateController {
	

@Autowired
IUserDAO daoRef;
	@RequestMapping(value="/login",method = RequestMethod.POST,produces="application/json", consumes="application/json")
	public String login(ModelMap modelMap ,/* HttpSession session,*/HttpServletRequest request) {
		return "validate/login";
	}
	@RequestMapping(method = RequestMethod.POST,value="validateUser")
	public String validate(@RequestParam(value="mobileNo") String mobileNo,@RequestParam(value="password") String password) {
		
		System.out.println(mobileNo);
		System.out.println(password);
		String destination=daoRef.validateUser(mobileNo, password);
		return destination;
	}
	
}
