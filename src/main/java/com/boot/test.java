package com.boot;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class test {

	
	@RequestMapping("/test")
	@ResponseBody
	public String getdata()
	{
		int a=80;
		int b=40;
		return "this is for testing purpose"+(a+b);
		
	}
}
