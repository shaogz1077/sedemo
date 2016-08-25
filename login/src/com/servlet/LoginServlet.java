package com.servlet;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.json.ResponseJsonUtils;
/**
 * 登陆servlet
 * @author shaogz
 *
 */
public class LoginServlet extends HttpServlet {

	
	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String name  = request.getParameter("name");
		String pass = request.getParameter("pass");
		Map<String,String> map = new HashMap<String,String>();
		map.put("name",name);
		map.put("pass", pass);
		map.put("userId", "dfsdfs");
		ResponseJsonUtils.json(response, map);
	}

	
	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doGet(request,response);
	}



}
