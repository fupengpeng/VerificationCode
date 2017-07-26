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
 * Title: CreateServlet
 * Description: ������һ������
 * Company: �����ŵ�������Ϣ�������޹�˾
 * ProjectName: VerificationCode
 * @author fupengpeng
 * @date 2017��7��26�� ����11:00:16
 *
 */
//@WebServlet("/CreateServlet")
public class CreateServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public CreateServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//7.��ֹ������������ͼƬ
		response.setDateHeader("Expires", -1);
		response.setHeader("Cache-Control", "no-cache");
		response.setHeader("Pragma", "no-cache");
		
		//6.֪ͨ�ͻ�������ͼƬ��ʽ�򿪷��͹�ȥ������
		response.setHeader("Content-Type", "image/jpeg");
		
		//1.���ڴ��д���һ��ͼƬ
		BufferedImage image = new BufferedImage(55, 20, BufferedImage.TYPE_INT_RGB);
		//2.��ͼƬ����д����
		Graphics g = image.getGraphics();
		
		//���ñ���
		g.setColor(Color.RED);
		g.fillRect(0, 0, 55, 20);
		
		//3.����д�����ݵ���ɫ������
		g.setColor(Color.BLACK);
		g.setFont(new Font(null,Font.BOLD,20));
		
		//4.��ͼƬ��д����
		String num = makeNum();
		//����������ɵ���ֵ���ݣ����浽session
		request.getSession().setAttribute("checkcode", num);
		g.drawString(num, 0, 20);
		
		//5.��д�����ݵ�ͼƬ����������
		ImageIO.write(image, "jpg", response.getOutputStream());
		
//		response.setContentType("text/html;charset=utf-8");
//		PrintWriter out = response.getWriter();

		
		
	}
	//�������7λ��
	public String makeNum(){
		Random r = new Random();
		String num = r.nextInt(9999) + "";
		StringBuffer sb = new StringBuffer();
		for (int i = 0; i < 4 - num.length(); i++) {
			sb.append("0");
		}
		num = sb.toString() + num;
		return num;
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
		
	}

}
