package com.jiudianlianxian.servlet;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Random;

import javax.imageio.ImageIO;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * 
 * Title: LoginServlet
 * Description: 给此类一个描述
 * Company: 济宁九点连线信息技术有限公司
 * ProjectName: VerificationCode
 * @author fupengpeng
 * @date 2017年7月26日 上午9:41:27
 *
 */
//@WebServlet("/LoginServlet")
public class LoginServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public LoginServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	
		response.setContentType("text/html;charset=utf-8");
		PrintWriter out = response.getWriter();
		//返回一个界面（html）
		out.println("<h1>用户登录</h1>");
		//action说明：/web应用名/Servlet的url
		out.println("<form action='/VerificationCode/LoginClServlet' method='post'>");
		
		out.println("用户名<input type='text' name='account'/><br/>");
		out.println("密　码<input type='password' name='password'/><br/>");
		out.println("验证码<input type='text' name='checkcode'/><img src='/VerificationCode/CreateServlet'/><br/>");
		out.println("<input type='submit' value='登录'/><br/>");
		out.println("</form>");
		
		String  error = (String) request.getAttribute("error");
		if (error != null) {
			out.println(error);
		}
		
	}


	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
