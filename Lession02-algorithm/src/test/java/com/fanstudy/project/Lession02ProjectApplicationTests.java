package com.fanstudy.project;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class Lession02ProjectApplicationTests {

	@Test
	void contextLoads() {
		boolean flag = true;
		Integer i = 0;
		int j = 1;
		int k = flag ? i:j;
		System.out.println(k);
	}

}
