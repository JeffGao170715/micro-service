package com.jeff;

import org.jasypt.encryption.StringEncryptor;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest
public class UserServiceApplicationTests {

	@Autowired
	StringEncryptor encryptor;

	@Test
	public void contextLoads() {
		// jdbc
		String jdbc_name = encryptor.encrypt("root");
		String jdbc_pwd = encryptor.encrypt("123456");
		System.out.println(jdbc_name + " : " + jdbc_pwd);
	}

}
