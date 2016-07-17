package com.nxy;

import com.nxy.spider.except.NoSupportRequestException;
import com.nxy.spider.fetcher.Request;
import com.nxy.spider.parser.HtmlParser;
import org.apache.http.HttpResponse;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

import java.io.IOException;

/**
 * Created by xinyang on 16/6/17.
 */
public class RequestTest {

	public static void testRequest() {
		HttpResponse res = null;
		try {
			Request req = Request.get("http://www.bilibili.com/video/av4995866/");
			res = req.head("name", "nxy")
                    .head("name", "hello")
                    .query("hello", "world")
                    .query("hello", "nxy")
                    .end();
			Document document;
			try {
				document = HtmlParser.parser(res.getEntity().getContent(), req.getUrl());
				Elements elements = document.select("a[href~=(/video)");
				out(elements.size());
				for (Element link : elements) {
					out(link.attr("abs:href"));
				}
			} catch (IOException e) {
				e.printStackTrace();
			}

		} catch (NoSupportRequestException e) {
			e.printStackTrace();
		}
	}
	public static void main(String[] args) {

        testRequest();
	}
	public static void out(Object obj) {
		System.out.println(obj);
    }
}
