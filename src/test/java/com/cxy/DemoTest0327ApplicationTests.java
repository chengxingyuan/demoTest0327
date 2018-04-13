package com.cxy;

import com.cxy.service.ICarService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.math.BigDecimal;

@RunWith(SpringRunner.class)
@SpringBootTest
public class DemoTest0327ApplicationTests {

	@Autowired
	private ICarService carService;

	@Test
	public void contextLoads() {
		carService.insertCar("BWM520",new BigDecimal("600000"));
	}

}
