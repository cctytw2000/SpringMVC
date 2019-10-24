package ch02.controller;

import java.io.InputStream;
import java.io.OutputStream;
import java.text.SimpleDateFormat;
import java.util.Collection;
import java.util.TimeZone;

import javax.servlet.ServletContext;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import ch02.model.LotteryBean;


@Controller
@RequestMapping("/ch02")
public class Ch02Controller {

	ServletContext context;

	@Autowired
	public void setContext(ServletContext context) {
		this.context = context;
	}
	
	@RequestMapping(value= {"/mappings1", "/mappings2"}, method=RequestMethod.GET)
	public String mappings(HttpServletRequest req, Model model) {
		// 在瀏覽器中顯示Request URI
		String uri = req.getRequestURI();
		model.addAttribute("requestURI", uri);
		return "ch02/_02/mappings";
	}
	
	@RequestMapping("/lottery")
	public String lottery(Model model) { 
		// 直接送回/WEB-INF/views/ch02/_03/queryLottery.jsp，一個可輸入資料的空白表單
		model.addAttribute("lower", "1");
		model.addAttribute("upper", "39");
		model.addAttribute("ball", "5");
		return "ch02/_03/queryLotteryForm";  	
	}

	@RequestMapping(value = "queryLottery", 
			params = { "visitor", "upper", "lower", "ball" })
	public String goodLuck(Model model, 
			@RequestParam(value = "visitor", defaultValue = "訪客") String visitorName,
			@RequestParam(value = "upper") int upp, 
			@RequestParam(value = "lower") int low,
			@RequestParam(value = "ball") int bal) {

		LotteryBean lottery = new LotteryBean(); 	// LotteryBean負責程式的邏輯運算
		lottery.setLowerBound(low); 				// 設定LotteryBean所需的必要參數
		lottery.setUpperBound(upp);
		lottery.setBallNumber(bal);
		Collection<Integer> coll = lottery.getLuckyNumbers(); 	// 請LotteryBean產生所需的結果
		model.addAttribute("visitName", visitorName);	// 將第一項資訊放入model物件內
		model.addAttribute("luckyNumber", coll); 		// 將第二項資訊放入model物件內

		return "ch02/_03/goodLuck";
	}	
	
	@RequestMapping(value="/advancedLottery", method=RequestMethod.GET)
	public String advLottery(Model model) { 
		return "ch02/_04/advanceQueryLotteryForm";
	}
	
	@RequestMapping(value="/advncedQueryLottery", method=RequestMethod.POST)
	public String advancedGoodLuck(Model model, 
			@RequestParam(value="visitor", defaultValue="訪客") String name,
			@RequestParam(value="min", defaultValue="1") Integer min,
			@RequestParam(value="max", defaultValue="49") Integer max,
			@RequestParam(value="ballNumber", defaultValue="6") Integer ballNumber
		) {
		String ms = "請求參數(含查詢字串)為: name=" + name + ", min=" + min + ", max=" + max + ", ballNumbe=" + ballNumber;
		LotteryBean lottery = new LotteryBean();     	// LotteryBean負責程式的邏輯運算
		lottery.setLowerBound(min);                    	// 設定LotteryBean所需的必要參數
		lottery.setUpperBound(max);
		lottery.setBallNumber(ballNumber);
		Collection<Integer> coll = lottery.getLuckyNumbers(); // 請LotteryBean產生所需的結果
		model.addAttribute("visitName", name);       	// 將第一項資訊放入model物件內
		model.addAttribute("luckyNumber", coll);	  	// 將第二項資訊放入model物件內	   
		model.addAttribute("replyMessage", ms);	  		// 將第二項資訊放入model物件內	   
		return "ch02/_04/goodLuck";
	}
	
	
	@RequestMapping(value="/pathVariableLottery", method=RequestMethod.GET)
	public String advancedQueryLottery(Model model) { 
		model.addAttribute("lower", "1");
		model.addAttribute("upper", "39");
		model.addAttribute("ball", "5");
		return "ch02/_05/pathVariableQueryLotteryForm";
	}
	// 
	@RequestMapping(value="/pathVariableQueryLottery/{min}/{max}/{ball}", method=RequestMethod.POST)
	public String pathVariableGoodLuck(Model model,
			@PathVariable Integer min,
			@PathVariable Integer max,
			@PathVariable("ball") Integer ballNumber,
			@RequestParam(value="visitor", defaultValue="訪客") String name
		) {
		
		String ms = "Path Variable為: min=" + min + ", max=" + max + ", ballNumber=" + ballNumber;
		LotteryBean lottery = new LotteryBean();     	// LotteryBean負責程式的邏輯運算
		lottery.setLowerBound(min);                    	// 設定LotteryBean所需的必要參數
		lottery.setUpperBound(max);
		lottery.setBallNumber(ballNumber);
		Collection<Integer> coll = lottery.getLuckyStars(); // 請LotteryBean產生所需的結果
		model.addAttribute("luckyNumber", coll);	  	// 將第二項資訊放入model物件內
		model.addAttribute("visitName", name); 
		model.addAttribute("replyMessage", ms);	  		// 將第二項資訊放入model物件內	   
		return "ch02/_05/goodLuck";
	}
// -----------------------------------------------------------------------------	
	//  /
	@RequestMapping(value="/advancePathVariableLottery", method=RequestMethod.GET)
	public String advancePathVariableLottery(Model model) { 
		model.addAttribute("lower", "1");
		model.addAttribute("upper", "39");
		model.addAttribute("ball", "5");
		return "ch02/_06/advPathVariableQueryLotteryForm";
	}
	@RequestMapping(value="/advPathVariableGoodLuck/{min}/{max}/{ball}", method=RequestMethod.POST)
	public String advPathVariableGoodLuck(Model model,
			@PathVariable Integer min,
			@PathVariable Integer max,
			@PathVariable("ball") Integer ballNumber,
			@RequestParam(value="visitor", defaultValue="訪客") String name
		) {
		
		String ms = "Path Variable為: min=" + min + ", max=" + max + ", ballNumber=" + ballNumber;
		LotteryBean lottery = new LotteryBean();     	// LotteryBean負責程式的邏輯運算
		lottery.setLowerBound(min);                    	// 設定LotteryBean所需的必要參數
		lottery.setUpperBound(max);
		lottery.setBallNumber(ballNumber);
		Collection<Integer> coll = lottery.getLuckyStars(); // 請LotteryBean產生所需的結果
		model.addAttribute("luckyNumber", coll);	  	// 將第二項資訊放入model物件內
		model.addAttribute("visitName", name); 
		model.addAttribute("replyMessage", ms);	  		// 將第二項資訊放入model物件內	   
		return "ch02/_06/goodLuck";
	}
// -----------------------------------------------------------------------------
	@RequestMapping("/cityTime")
	public ModelAndView cityTime() {
		ModelAndView mv = new ModelAndView();
		mv.setViewName("ch02/_07/cityTimeForm");
		return mv;
	}
	@RequestMapping("/cityTimeZone")
	public ModelAndView cityTimeZone(
			@RequestParam(value="city", defaultValue="GMT") String timeZone
		) {
		ModelAndView mv = new ModelAndView();
		TimeZone tz = TimeZone.getTimeZone(timeZone);
		TimeZone.setDefault(tz);
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy年MM月dd日 HH時mm分ss秒 SSS豪秒");
		String timeNow = sdf.format(new java.util.Date());
		mv.addObject("now", timeZone + "->" + timeNow);
		mv.setViewName("ch02/_07/showTime");
		return mv;
	}
	
	
	@RequestMapping("/showPicture")
	public void sendRandomPicture(OutputStream os, HttpServletRequest request, 
			HttpServletResponse response) {
		String[] pics = { "autumn_fs.jpg", "fs.jpg", "m001.jpg" };
		int num = (int) (Math.random() * pics.length) + 0;
		String filename = pics[num]; 			// filename: 隨機挑選的檔案名稱
		String path = "\\WEB-INF\\views\\images\\" + filename; 	// path: 檔案在本系統內的路徑名稱
		ServletContext context = request.getServletContext();
		String mimeType = context.getMimeType(filename);
		response.setContentType(mimeType);
		try (
			InputStream is = context.getResourceAsStream(path);
		) {
			byte[] b = new byte[1024];
			int len;
			while ((len = is.read(b)) != -1) {
				os.write(b, 0, len);
			}
		} catch(Exception e) {
			e.printStackTrace();
		}
	}
	@RequestMapping("/nativeServletApi")
	public String nativeServletApi() { 
		return "ch02/_08/showPicture";
	}
	
	
	String[] sa = { "fs.jpg", "m001.jpg", "m12.jpg", "m46.jpg", "m536.jpg" };

	@RequestMapping("/picture")
	public String sendRenderPictureJSP() {
		return "ch02/ShowPicture";
	}

	
	@RequestMapping(value="/index", method=RequestMethod.GET)
	public String index() {
		return "ch02/index";
	}
	
	@RequestMapping(method = RequestMethod.GET)
	public String defaultMethod(HttpServletRequest req, Model model) {
		// 在瀏覽器中顯示Request URI
		String uri = req.getRequestURI();
		System.out.println(12345);
		model.addAttribute("requestURI", uri);
		return "ch02/_09/defaultMethod";
	}
}
 