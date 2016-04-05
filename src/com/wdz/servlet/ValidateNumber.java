package com.wdz.servlet;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics2D;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.util.Random;
import javax.imageio.ImageIO;
import javax.servlet.ServletException;
import javax.servlet.ServletOutputStream;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

public class ValidateNumber extends HttpServlet {
	private int width = 60;

	private int height = 25;

	private int codeCount = 4;

	private int x = 0;
	private int fontHeight;
	private int codeY;
	char[] codeSequence = { 'A', 'B', 'C', 'D', 'E', 'F', 'G', 'H', 'I', 'J',
			'K', 'L', 'M', 'N', 'O', 'P', 'Q', 'R', 'S', 'T', 'U', 'V', 'W',
			'X', 'Y', 'Z', '0', '1', '2', '3', '4', '5', '6', '7', '8', '9' };

	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doPost(request, response);
	}

	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		this.x = (this.width / (this.codeCount + 1));
		this.fontHeight = (this.height - 2);
		this.codeY = (this.height - 4);

		BufferedImage bi = new BufferedImage(this.width, this.height, 1);

		Graphics2D g = bi.createGraphics();

		g.setColor(Color.WHITE);
		g.fillRect(0, 0, this.width, this.height);

		Font font = new Font("Fixedsys", 1, this.fontHeight);

		g.setFont(font);

		g.setColor(Color.BLACK);
		g.drawRect(0, 0, this.width - 1, this.height - 1);

		Random random = new Random();
		g.setColor(Color.green);
		for (int i = 0; i < 10; i++) {
			int x = random.nextInt(this.width);
			int y = random.nextInt(this.height);
			int xl = random.nextInt(12);
			int yl = random.nextInt(12);
			g.drawLine(x, y, x + xl, y + yl);
		}
		StringBuffer sbNumber = new StringBuffer();

		for (int i = 0; i < this.codeCount; i++) {
			String strRand = String.valueOf(this.codeSequence[random
					.nextInt(36)]);

			int red = random.nextInt(255);
			int green = random.nextInt(255);
			int blue = random.nextInt(255);

			g.setColor(new Color(red, green, blue));
			g.drawString(strRand, (i + 1) * this.x - 6, this.codeY);

			sbNumber.append(strRand);
		}

		request.getSession().setAttribute("validateCode", sbNumber.toString());

		response.setContentType("image/jpeg");
		ServletOutputStream sos = response.getOutputStream();

		ImageIO.write(bi, "jpeg", sos);

		sos.close();
	}
}