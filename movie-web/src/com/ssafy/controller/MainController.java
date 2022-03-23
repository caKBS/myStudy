package com.ssafy.controller;

import java.io.IOException;

import javax.security.auth.message.callback.PrivateKeyCallback.Request;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.ssafy.config.MyAppSqlConfig;
import com.ssafy.dao.MovieDao;

@WebServlet("/movie")
public class MainController extends HttpServlet{
	
	private MovieDao mapper;
	
	public MainController() {
		mapper = MyAppSqlConfig.getSqlMapper().getMapper(MovieDao.class);
	}

	@Override
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		if(request.getMethod().equals("POST"))
			request.setCharacterEncoding("UTF-8");
		
		
		String act = request.getParameter("act");
		switch (act) {
		case "list":
			doList(request, response);
			break;
		}
	}

	private void doList(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setAttribute("list", mapper.selectAll());
		request.getRequestDispatcher("/movie/list.jsp").forward(request, response);
	}
	
	
	
}
