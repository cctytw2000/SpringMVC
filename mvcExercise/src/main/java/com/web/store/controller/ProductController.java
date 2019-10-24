package com.web.store.controller;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.sql.Blob;
import java.sql.SQLException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.ServletConfig;
import javax.servlet.ServletContext;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.CacheControl;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.web.store.model.BookBean;
import com.web.store.model.CompanyBean;
import com.web.store.service.ProductService;

@Controller
public class ProductController {
	ProductService service;
	ServletContext context;

	@Autowired
	public void setContext(ServletContext context) {
		this.context = context;
	}

	@Autowired
	public void setService(ProductService service) {
		this.service = service;
	}

//	@RequestMapping("/products")
//	public String list(Model model) {
//		CompanyBean cb = new CompanyBean(1, "學貫行銷股份有限公司", "台北市林森南路四號六樓", "http://www.xbook.com.tw/");
//
//		BookBean bb = new BookBean(1002, "PHP&MySQL程式設計實例講座", "陳惠貞", 580.0, 0.6, "bookxb002.jpg", "P832", null, 25,
//				"Web", cb);
//		model.addAttribute("product", bb);
//		return "products";
//	}

	@RequestMapping("/products")
	public String list(Model model) {
		List<BookBean> list = service.getAllProduct();
		model.addAttribute("products", list);
		return "products";
	}

	@RequestMapping("/update/stock")
	public String updateSrock(Model model) {
		service.updateAllstocks();
		return "redirect:/products";
	}

	@RequestMapping("/queryByCategory")
	public String queryByCategory(Model model) {
		List<String> list = service.getAllCategories();
		model.addAttribute("categoryList", list);
		return "types/category";
	}

	@RequestMapping("/products/{category}")
	public String getqueryByCategory(@PathVariable String category, Model model) {
		List<BookBean> products = service.getProductByCategory(category);
		model.addAttribute("products", products);
		return "products";
	}

	@RequestMapping("/product")
	public String getProductById(@RequestParam("id") Integer id, Model model) {

		model.addAttribute("product", service.getProductById(id));
		return "product";
	}

	@RequestMapping(value = "/products/add", method = RequestMethod.GET)
	public String getAddproductForm(Model model) {
		BookBean bb = new BookBean();
		bb.setTitle("哈哈第章");
		bb.setAuthor("葉冠麟");
		model.addAttribute("bookBean", bb);
		return "addProduct";
	}

	@RequestMapping(value = "/products/add", method = RequestMethod.POST)
	public String processAddNewProductForm(@ModelAttribute("bookBean") BookBean bb, Model model, BindingResult result) {
		String[] suppressedFields = result.getSuppressedFields();
		if (suppressedFields.length > 0) {
			throw new RuntimeException(
					"嘗試輸入錯誤的欄位:" + org.springframework.util.StringUtils.arrayToCommaDelimitedString(suppressedFields));

		}
		if (bb.getStock() == null) {
			bb.setStock(0);
		}
		service.addProduct(bb);

		return "redirect:/products";
	}

	@ModelAttribute(value = "companyList")
	public Map<Integer, String> getCompanyList() {
		Map<Integer, String> companyMap = new HashMap<>();
		List<CompanyBean> list = service.getCompanyList();
		for (CompanyBean cb : list) {
			companyMap.put(cb.getId(), cb.getName());
		}
		return companyMap;
	}

	@ModelAttribute(value = "categoryList")
	public List<String> getCategoryList() {

		return service.getAllCategories();
	}

	@InitBinder
	public void whiteListion(WebDataBinder binder) {
		binder.setAllowedFields("author", "bookNo", "category", "price", "title", "companyId");
	}

	@RequestMapping(value = "/forwardDemo")
	public String forward(Model model, HttpServletRequest req) {
		String uri = req.getRequestURI();
		model.addAttribute("modelData0", "這是以/forwardDemo送來的請求");
		model.addAttribute("uri0", uri);
		return "forward:/anotherFWD";
	}

	@RequestMapping(value = "/anotherFWD")
	public String forward1(Model model, HttpServletRequest req) {
		String uri = req.getRequestURI();
		model.addAttribute("modelData1", "這是以/anotherFWD送來的請求");
		model.addAttribute("uri1", uri);
		return "forwardedPage";
	}

	@RequestMapping(value = "/redirectDemo")
	public String redirect(Model model, RedirectAttributes redirectAttributes, HttpServletRequest req) {
		String uri = req.getRequestURI();
		model.addAttribute("modelData2", "這是以/redirectDemo送來的請求，即將通知瀏覽器對" + "新網址發出請求，但瀏覽器不會顯示這樣的訊息");
		model.addAttribute("uri0", uri);

		redirectAttributes.addFlashAttribute("modelData3", "這是加在redirectAttributes" + "物件內的屬性物件，瀏覽器會顯示");
		redirectAttributes.addFlashAttribute("uri3", uri);
		return "redirect:/redirectanother";
	}

	@RequestMapping(value = "/redirectanother")
	public String redirectA(Model model, HttpServletRequest req) {
		String uri = req.getRequestURI();
		model.addAttribute("modelData1", "這是以/anotherFWD送來的請求");
		model.addAttribute("uri1", uri);
		return "redirectedPage";
	}

	@RequestMapping(value = "/getPicture/{bookId}", method = RequestMethod.GET)
	public ResponseEntity<byte[]> getPicture(HttpServletResponse resp, @PathVariable Integer bookId) {
		String filePath = "/resources/images/NoImage.jpg";

		byte[] media = null;
		HttpHeaders headers = new HttpHeaders();
		String filename = "";
		int len = 0;
		BookBean bean = service.getProductById(bookId);
		if (bean != null) {
			Blob blob = bean.getCoverImage();
			filename = bean.getFileName();
			if (blob != null) {
				try {
					len = (int) blob.length();
					media = blob.getBytes(1, len);
				} catch (SQLException e) {
					throw new RuntimeException("ProductController的getPicture()發生SQLException: " + e.getMessage());
				}
			} else {
				media = toByteArray(filePath);
				filename = filePath;
			}
		} else {
			media = toByteArray(filePath);
			filename = filePath;
		}
		headers.setCacheControl(CacheControl.noCache().getHeaderValue());
		String mimeType = context.getMimeType(filename);
		MediaType mediaType = MediaType.valueOf(mimeType);
		System.out.println("mediaType =" + mediaType);
		headers.setContentType(mediaType);
		ResponseEntity<byte[]> responseEntity = new ResponseEntity<>(media, headers, HttpStatus.OK);
		return responseEntity;
	}

	private byte[] toByteArray(String filepath) {
		byte[] b = null;
		String realPath = context.getRealPath(filepath);
		try {
			File file = new File(realPath);
			long size = file.length();
			b = new byte[(int) size];
			InputStream fis = context.getResourceAsStream(filepath);
			fis.read(b);
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		return b;
	}

}
