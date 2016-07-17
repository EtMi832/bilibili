package com.nxy.spider.parser;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;

import java.io.IOException;
import java.io.InputStream;

/**
 * Created by xinyang on 16/7/13.
 */
public class HtmlParser {
	/**
	 * 解析html
	 * 
	 * @param html
	 * @return
	 */
	public Document parser(String html) {

		return Jsoup.parse(html);

	}
	public static Document parser(InputStream in, String baseUrl) throws IOException {

		return Jsoup.parse(in, "utf-8", baseUrl);

	}
	/**
	 * 解析html
	 * 
	 * @param html
	 * @param baseUrl
	 * @return
	 */
	public Document parser(String html, String baseUrl) {

		return Jsoup.parse(html, baseUrl);

	}
}
