package com.web.store.controller;

import java.text.SimpleDateFormat;
import java.util.Date;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class HomeController {
	@RequestMapping("/welcome")
	public String welcome(Model model) {
		model.addAttribute("title", "歡迎光臨 巴哈姆特");
		model.addAttribute("subtitle", "唯一遊戲網站");
		return "welcome";
	}

	@RequestMapping("/")
	public String index() {

		return "index";
	}

	@RequestMapping("/ServerTime")
	public String ServerTime(Model model) {
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss SSS");
		Date d = new Date();
		String timeNows = sdf.format(d);
		model.addAttribute("now", timeNows);
		return "serverTime";
	}

}
