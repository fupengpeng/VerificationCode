package com.jiudianlianxian.controller;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * 
 * Title: LoginClServlet
 * Description: 给此类一个描述
 * Company: 济宁九点连线信息技术有限公司
 * ProjectName: VerificationCode
 * @author fupengpeng
 * @date 2017年7月26日 上午10:37:30
 *
 */
//@WebServlet("/LoginClServlet")
public class LoginClServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public LoginClServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html;charset=utf-8");
		PrintWriter out = response.getWriter();
		//获取用户的用户名、密码、验证码
		//1.验证码验证
		String account = request.getParameter("account");
		String password = request.getParameter("password");
		String checkCode = request.getParameter("checkcode");
		
		//获取session中的验证码
		String checkcodesession = (String) request.getSession().getAttribute("checkcode");
		
		if (checkCode.equals(checkcodesession)) {
			//验证码ok
			request.getRequestDispatcher("/Ok").forward(request, response);
			//导数据库中去验证账号密码
		}else{
			request.setAttribute("error", "验证码错误");
			request.getRequestDispatcher("/LoginServlet").forward(request, response);
		}

		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
		
	}

}
