package com.xue.test;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.xue.redis.entity.TbUse;
import com.xue.redis.service.TbUseService;


@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration({ "classpath:spring/spring-dao.xml", "classpath:spring/spring-service.xml","classpath:spring/spring-web.xml","classpath:redis/redis-config.xml" })
public class ServiceTest {

	@Autowired
	private TbUseService useService;
	
	@Test
	public void getUseById() throws InterruptedException{
		TbUse useById = useService.getUseById(2);
		System.out.println(useById);
		
		Thread.sleep(1000);
		useService.getUseById(2);
	}
}
