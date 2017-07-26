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
 * Description: ������һ������
 * Company: �����ŵ�������Ϣ�������޹�˾
 * ProjectName: VerificationCode
 * @author fupengpeng
 * @date 2017��7��26�� ����9:41:27
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
		//����һ�����棨html��
		out.println("<h1>�û���¼</h1>");
		//action˵����/webӦ����/Servlet��url
		out.println("<form action='/VerificationCode/LoginClServlet' method='post'>");
		
		out.println("�û���<input type='text' name='account'/><br/>");
		out.println("�ܡ���<input type='password' name='password'/><br/>");
		out.println("��֤��<input type='text' name='checkcode'/><img src='/VerificationCode/CreateServlet'/><br/>");
		out.println("<input type='submit' value='��¼'/><br/>");
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
