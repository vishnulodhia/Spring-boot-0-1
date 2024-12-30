package com.springBootLearning.spring_boot_0_1;

import com.springBootLearning.spring_boot_0_1.Model.User;
import com.springBootLearning.spring_boot_0_1.Security.JwtService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class SpringBoot01ApplicationTests {

	@Autowired
	private JwtService jwtService;

	@Test
	void contextLoads() {

	}

}
