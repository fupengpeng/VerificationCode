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
 * Description: ������һ������
 * Company: �����ŵ�������Ϣ�������޹�˾
 * ProjectName: VerificationCode
 * @author fupengpeng
 * @date 2017��7��26�� ����10:37:30
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
		//��ȡ�û����û��������롢��֤��
		//1.��֤����֤
		String account = request.getParameter("account");
		String password = request.getParameter("password");
		String checkCode = request.getParameter("checkcode");
		
		//��ȡsession�е���֤��
		String checkcodesession = (String) request.getSession().getAttribute("checkcode");
		
		if (checkCode.equals(checkcodesession)) {
			//��֤��ok
			request.getRequestDispatcher("/Ok").forward(request, response);
			//�����ݿ���ȥ��֤�˺�����
		}else{
			request.setAttribute("error", "��֤�����");
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
