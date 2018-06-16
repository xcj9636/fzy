package com.net.controller;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

//import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.net.controller.person;

@Controller
public class hello {
	@RequestMapping(value = "/")
	@ResponseBody
	public  person hello(HttpServletRequest request) {
		String flag=request.getParameter("flag");
		person p=new person();
		conn_sql c=new conn_sql();
		if(flag.equals("add"))
		{
			 
			String keyword=request.getParameter("keyword");
			String wxinfo=request.getParameter("wxinfo");
			c.add(keyword, wxinfo);
			return p;
			
		}
		else if(flag.equals("search"))
		{
			String keyword=request.getParameter("keyword");
			String res=c.select(keyword);
			p.setWxinfo(res);
			p.setKeyword("1");
			System.out.println(res);
			return p;
		}
		return p;
	}

}
