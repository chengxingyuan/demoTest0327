package com.cxy;

import com.cxy.job.UpdateTodaySupportJob;
import com.cxy.service.ICarService;
import com.cxy.utils.PicUtils;
import net.coobird.thumbnailator.Thumbnails;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.io.IOException;
import java.math.BigDecimal;

@RunWith(SpringRunner.class)
@SpringBootTest
public class DemoTest0327ApplicationTests {

	@Autowired
	private ICarService carService;

	@Autowired
	UpdateTodaySupportJob updateTodaySupportJob;

	@Test
	public void contextLoads() {
		carService.insertCar("BWM520",new BigDecimal("600000"));
	}

	@Test
	public void testJob(){
		updateTodaySupportJob.updateAvailableSupportEveryDay();
	}

	/**
	 * 按照分辨率比例进行压缩
	 * */
	@Test
	public void testPressPicture() throws IOException {
		//scale是可以指定图片的大小，值在0到1之间，1f就是原图大小，0.5就是原图的一半大小，这里的大小是指图片的长宽。
		//outputQuality是图片的质量，值也是在0到1，越接近于1质量越好，越接近于0质量越差。
		Thumbnails.of("C:\\123.jpg")
				.scale(1f)
				.outputQuality(0.5f)
				.toFile("C:\\temp\\000123.jpg");
	}

	/**
	 * 指定大小压缩，如压缩到300kb以下
	 * */
	@Test
	public void testPicUtils(){
		PicUtils.compressPicForScale("C:\\333.jpg",
				"D:\\3333333.jpg", 300, 0.9); // 图片小于300kb
	}

}
