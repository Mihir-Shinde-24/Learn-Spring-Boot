package com.itvedant.controllers;

import java.util.Date;

import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Controller;

@Controller
public class MyController {

	/* 1. fixedRate */
//	@Scheduled(fixedRate = 5000)
//	public void getDate() throws InterruptedException
//	{
//		Thread.sleep(2000);
//		System.out.println(new Date());
//	}
	
	/* 2. fixedDelay */
//	@Scheduled(fixedDelay = 5000, initialDelay = 10000L)
//	public void getDate() throws InterruptedException
//	{
//		Thread.sleep(2000);
//		System.out.println(new Date());
//	}
	
	/* 3. Cron */
	@Scheduled(cron = "*/2 * * * * *")
	public void getDate() throws InterruptedException
	{
		System.out.println(new Date());
	}
	
	
	
	

}
