package com.nxy;

import com.google.common.base.Strings;

import java.io.*;
import java.net.InetAddress;
import java.net.Socket;

/**
 * @author PTY
 */
public class OSocket {

	public static void main(String[] args) {
		// http://img3.laibafile.cn/p/m/249171331.jpg
		// m.photo.hk.ty/p/m/227720890.jpghttp://img3.laibafile.cn/p/m/227720885.jpg
		// http://img3.laibafile.cn/p/m/227720881.gif
		// http://img3.laibafile.cn/p/m/227720876.png
		String cmd = new StringBuilder("GET /p/m/249171331.jpg HTTP/1.1\r\n").append("Host: img3.laibafile.cn\r\n")
				.append("Referer: http://bbs.tianya.cn/post-tianyatopic-11658-1.shtml\r\n")
				.append("Connection: close\r\n")
				// .append("Pragma: no-cache\r\n")
				// .append("Cache-Control: no-cache\r\n")
				.append("\r\n").toString();

		// byte[] bytes = doSocket(
		// "124.225.213.20",
		// "GET /p/mh/248031931.jpg
		// HTTP/1.1\r\nConnection:close\r\nHost:img3.laibafile.cn\r\nReferer:http://www.tianya.cn/\r\n\r\n");

		byte[] bytes = doSocket("19.2.169.185", "GET / HTTP/1.1\r\nHost: img3.laibafile.cn\r\n\r\n");
		// try {
		// OutputStream fw = new FileOutputStream("d:/test.jpg");
		// fw.write(bytes);
		// fw.flush();
		// fw.close();
		// } catch (Exception e) {
		// e.printStackTrace();
		// }
	}

	private static byte[] doSocket(String ip, String cmd) {

		Socket socket = null;
		InputStream is = null;
		OutputStream os = null;
		try {
			// 图片服务器域名
			InetAddress server = InetAddress.getByName(ip);
			socket = new Socket(server, 80);
			socket.setSoTimeout(5000); // 改为３秒

			is = socket.getInputStream();
			os = socket.getOutputStream();
			os.write(cmd.getBytes());
			os.flush();

			// socket输入流
			BufferedInputStream bis = new BufferedInputStream(is);

			StringBuffer sb = new StringBuffer();
			int ret = -1;
			int lastRet = -1;
			while (!socket.isClosed() && (ret = bis.read()) > 0) {

				sb.append(Character.toString((char) ret));

				if (lastRet == '\r' && ret == '\n') {
					if (!Strings.isNullOrEmpty(sb.toString())) {
						System.out.print(sb.toString());
						sb.delete(0, sb.length());
					} else {
						break;
					}
				}
				lastRet = ret;
			}

			ByteArrayOutputStream baos = new ByteArrayOutputStream();
			byte[] buff = new byte[1024 * 8];
			int len = 0;
			while ((len = bis.read(buff)) > 0) {
				baos.write(buff, 0, len);
			}
			return baos.toByteArray();

		} catch (Exception e) {
			e.printStackTrace();
		} finally {

			if (os != null) {
				try {
					os.close();
				} catch (IOException e) {
				}
			}

			if (is != null) {
				try {
					is.close();
				} catch (IOException e) {
				}
			}

			if (socket != null) {
				try {
					socket.close();
				} catch (Exception e) {
				}
				socket = null;
			}
		}
		return null;
	}

}