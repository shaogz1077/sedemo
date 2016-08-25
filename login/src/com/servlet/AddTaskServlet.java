package com.servlet;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.json.ResponseJsonUtils;

public class AddTaskServlet extends HttpServlet {


	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
	Map<String,String> map = new HashMap<String,String>();
	map.put("title",request.getParameter("title"));
	map.put("address", request.getParameter("address"));
	map.put("minprice", request.getParameter("minprice"));
	map.put("maxprice",request.getParameter("maxprice"));
	map.put("add", request.getParameter("add"));
	map.put("shopping", request.getParameter("shopping"));
	ResponseJsonUtils.json(response, map);

	
	}


	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doGet(request,response);
	}


}
