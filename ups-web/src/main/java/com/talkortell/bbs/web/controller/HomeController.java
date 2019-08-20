package com.talkortell.bbs.web.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.talkortell.bbs.base.common.SessionUser;

import lombok.extern.slf4j.Slf4j;

@RestController
@Slf4j
public class HomeController {
	@Autowired
	private HttpServletRequest request;
	
	@GetMapping("/boot")
	public String printBootState() {
		return "boot success";
	}
	
	@GetMapping("/loginShow")
	public String mocklogin() {
		HttpSession session = request.getSession();
		SessionUser su = (SessionUser)session.getAttribute("login_user");
		log.info("===login user==={}", su);
		return "boot success";
	}
	
}
