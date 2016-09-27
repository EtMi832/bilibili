package com.nxy.spider.test;

import org.junit.Before;
import org.junit.Test;

import java.util.List;
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
}
