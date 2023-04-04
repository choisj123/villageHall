package com.kh.villagehall.user.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.kh.villagehall.common.MyRenamePolicy;
import com.kh.villagehall.user.model.service.UserService;
import com.kh.villagehall.user.model.vo.User;
import com.oreilly.servlet.MultipartRequest;

@WebServlet("/mypage/changePw")
public class ChangePwServlet extends HttpServlet{
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String path = "/WEB-INF/views/mypage/changePw.jsp";
		req.getRequestDispatcher(path).forward(req, resp);
	}
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		
		String newPw = req.getParameter("newPw");
		String newPwConfirm = req.getParameter("newPwConfirm");
		
		
		HttpSession session = req.getSession();
		
		User loginUser = (User)(session.getAttribute("loginUser"));
		
		int userNo = loginUser.getUserNo();
		
	
		System.out.println(newPw);
		System.out.println(newPwConfirm);
		
		
		
		
		if(newPw == null) {
//			newPw = UserService.loginUserPw(userNo);
			
		}else {
			
			if(newPw.equals(newPwConfirm)) {
				
				
			}
		}
		
		req.setAttribute("userPw", newPw);
		
		
		
		String path = "/WEB-INF/views/mypage/changeInfo.jsp";
		req.getRequestDispatcher(path).forward(req, resp);
	
	}

}
