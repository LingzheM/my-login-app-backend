package com.example.myapp.serivce;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.example.myapp.service.UserAuthService;

@SpringBootTest
public class UserAuthServiceTest {
	@Autowired
	UserAuthService userAuthService;
	
	@Test
    public void testMd5() throws Exception {
        System.out.println(userAuthService.md5("ge2021"));
    }


}
