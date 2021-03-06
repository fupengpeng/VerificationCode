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
 * Description: 给此类一个描述
 * Company: 济宁九点连线信息技术有限公司
 * ProjectName: VerificationCode
 * @author fupengpeng
 * @date 2017年7月26日 上午11:00:16
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
		//7.禁止浏览器缓存随机图片
		response.setDateHeader("Expires", -1);
		response.setHeader("Cache-Control", "no-cache");
		response.setHeader("Pragma", "no-cache");
		
		//6.通知客户机，以图片方式打开发送过去的数据
		response.setHeader("Content-Type", "image/jpeg");
		
		//1.在内存中创建一副图片
		BufferedImage image = new BufferedImage(55, 20, BufferedImage.TYPE_INT_RGB);
		//2.向图片上面写数据
		Graphics g = image.getGraphics();
		
		//设置背景
		g.setColor(Color.RED);
		g.fillRect(0, 0, 55, 20);
		
		//3.设置写入数据的颜色和字体
		g.setColor(Color.BLACK);
		g.setFont(new Font(null,Font.BOLD,20));
		
		//4.向图片上写数据
		String num = makeNum();
		//把随机数生成的数值数据，保存到session
		request.getSession().setAttribute("checkcode", num);
		g.drawString(num, 0, 20);
		
		//5.把写好数据的图片输出给浏览器
		ImageIO.write(image, "jpg", response.getOutputStream());
		
//		response.setContentType("text/html;charset=utf-8");
//		PrintWriter out = response.getWriter();

		
		
	}
	//随机生成7位数
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
