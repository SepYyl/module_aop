package com.example.sss.utill;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import javax.annotation.Resource;

/**
 * @className: cn.ac.iie.cloud.iie.logs.aop.utill.aaTest
 * @author: sepY
 * @create: 2023-03-23 16:50
 * @description: TODO
 */
@SpringBootTest
class aaTest {
	@Resource
    aa aa;
	@Test
	public void tes(){
		aa.test();
	}


}