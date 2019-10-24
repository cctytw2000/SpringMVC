package ch01.controller;

import java.text.SimpleDateFormat;

import javax.servlet.ServletContext;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.context.WebApplicationContext;
import org.springframework.web.context.support.WebApplicationContextUtils;

import mvc.examples.model.Cat;

@Controller
public class Ch01Controller {

	@Autowired
	ServletContext servletContext;
	
	@RequestMapping("/")
	public String home() {
		return "index";     // 請視圖解析器由視圖的邏輯名稱index來找出真正的視圖
	}

	@RequestMapping("/ch01/index")
	public String index() {
		
		return "ch01/index";   // 請視圖解析器由視圖的邏輯名稱ch01/index來找出真正的視圖
	}

	@RequestMapping("/ch01/sayHello")
	public String sayHello(Model model) {
		return "ch01/hello";
	}
	
	@RequestMapping("/ch01/serverTime")
	public String serverTime(Model model) {
		java.util.Date d = new java.util.Date();
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy年MM月dd日 HH時mm分ss秒 SSS豪秒");
		String timeNow = sdf.format(d);
		// 如果Controller有資料要交給View，可以透過Model.addAttribute()方法
		model.addAttribute("now", timeNow + ", Spring MVC版");
		return "ch01/serverTime";
	}
	@RequestMapping("/ch02/beanLifeCycle")
	public void beanLifeCycle(Model model){
		WebApplicationContext wac = WebApplicationContextUtils
									.getRequiredWebApplicationContext(servletContext);
		Cat c1 = wac.getBean(Cat.class);
		model.addAttribute("timeCreating", c1.getTimeCreating());

		
    }
//	@RequestMapping("/ch01/showPicture")
//	public void sendRandomPicture(OutputStream os, HttpServletRequest request, 
//			HttpServletResponse response) {
//		String[] pics = { "autumn_fs.jpg", "fs.jpg", "m001.jpg" };
//		int num = (int) (Math.random() * pics.length) + 0;
//		String filename = pics[num]; 			// filename: 隨機挑選的檔案名稱
//		String path = "\\WEB-INF\\views\\images\\" + filename; 	// path: 檔案在本系統內的路徑名稱
//		ServletContext context = request.getServletContext();
//		String mimeType = context.getMimeType(filename);
//		response.setContentType(mimeType);
//		try (
//			InputStream is = context.getResourceAsStream(path);
//		) {
//			byte[] b = new byte[1024];
//			int len;
//			while ((len = is.read(b)) != -1) {
//				os.write(b, 0, len);
//			}
//		} catch(Exception e) {
//			e.printStackTrace();
//		}
//	}
//	
//	@RequestMapping("/ch01/lottery")
//	public String lottery(Model model) {
//		return "ch01/queryLottery";
//	}
//	@RequestMapping("/ch01/LotteryController")
//	//public String goodLuck(Model model, @RequestParam(value="visitor", defaultValue="訪客") String name ) {
//	public String goodLuck(Model model) {
//		 LotteryBean lottery = new LotteryBean();     // LotteryBean負責程式的邏輯運算
//         lottery.setLowerBound(1);                    // 設定LotteryBean所需的必要參數
//         lottery.setUpperBound(49);
//         lottery.setBallNumber(6);
//         Collection<Integer> coll = lottery.getLuckyNumbers(); // 請LotteryBean產生所需的結果
//         model.addAttribute("visitName", "訪客");       // 將第一項資訊放入model物件內
//         model.addAttribute("luckyNumber", coll);	  // 將第二項資訊放入model物件內	   
//		return "ch01/goodLuck";
//	}

}
