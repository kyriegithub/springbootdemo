package com.example.springboot;


import com.example.springboot.config.GetPersonInfoProperties;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

/**
 * 读取配置
 */
@SpringBootTest
@RunWith(SpringRunner.class)
public class ApplicationConfigTests {
	@Autowired
	private GetPersonInfoProperties getPersonInfoProperties;

     @Value("${age}")
	 private int age;
     @Value("${name}")
	 private String name;

	@Test
	public void getName(){
		System.out.println(name);
	}

	@Test
	public void getAge(){
		System.out.println(age);
	}

	@Test
	public void getPersonInfo(){
		System.out.println(getPersonInfoProperties.toString());
	}



}
