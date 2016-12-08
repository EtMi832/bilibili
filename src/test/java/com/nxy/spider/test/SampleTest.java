package com.nxy.spider.test;

import com.nxy.spider.util.JsonUtil;
import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.stream.Collector;
import java.util.stream.Collectors;
import java.util.stream.Stream;

/**
 * Created by snailnan on 2016/9/26.
 */
public class SampleTest {
	private Stream<Long> s;

	@Before
	public void before() {
		s = Stream.of(100L, 12L, 14L);
	}

	@Test
	public void test() {
	    List<Integer> x = s.map(e-> e.intValue()).collect(Collectors.toList());
        System.out.println(x.toString());
    }
    @Test
    public void testLong() {
    	Integer i= 100;
        Long l= i.longValue();

    }
    @Test
	public void test3(){
		AtomicInteger ai = new AtomicInteger(10);
		System.out.println(ai.getAndIncrement());
		System.out.println(ai.get());
	}
	@Test
	public void testMap(){
		Map<String,String>  map = new HashMap<>();
		map.put("hello","1");
		map.put("world","2");
		System.out.println(JsonUtil.toJsonString(map));
		map.remove("hello2");
		System.out.println(JsonUtil.toJsonString(map));
	}
	@Test
	public void testList(){
		List<Integer> l = new ArrayList();
		l.add(1);
	}
}
