package com.example.sss.utill;

import cn.ac.iie.cloud.iie.logs.aop.annotation.OperLog;
import org.springframework.stereotype.Component;

/**
 * @className: com.example.sss.utill.aa
 * @author: sepY
 * @create: 2023-03-23 16:48
 * @description: TODO
 */
@Component
public class aa {
	@OperLog
	public void test(){
		System.out.println("sss");
	}
}
