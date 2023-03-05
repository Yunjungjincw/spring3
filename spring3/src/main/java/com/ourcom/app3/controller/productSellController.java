package com.ourcom.app3.controller;

import java.io.File;
import java.io.FileInputStream;
import java.io.OutputStream;
import java.net.URLEncoder;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Enumeration;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.MultipartHttpServletRequest;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

import com.ourcom.common.base.BaseController;
import com.ourcom.app3.domain.Criteria;
import com.ourcom.app3.domain.ImageFileVO;
import com.ourcom.app3.domain.PageDTO;
import com.ourcom.app3.domain.Product;
import com.ourcom.app3.repository.ProductRepository;
import com.ourcom.app3.service.ProductService;

@Controller
@PropertySource("classpath:image.properties")
@Configuration
public class productSellController extends  BaseController implements WebMvcConfigurer{
	
	
	
	 @Value("${resource.path}") 
	 private String resourcePath;
	 
	 @Value("${upload.path}") 
	 private String uploadPath;
	 
	 @Override
	 public void addResourceHandlers(ResourceHandlerRegistry registry) {
		 registry.addResourceHandler(uploadPath).addResourceLocations(resourcePath);
	 }
	 
	 
	//파일저장경로
  	private static final String REPO_PATH = "C:\\spring\\repo";
	
	@Autowired
	ProductService productService;
	@Autowired
	ProductRepository productRepository;
	
	 //판매하기 글 등록 페이지
	 @RequestMapping(value="/productAddForm", method= {RequestMethod.GET})
		public String productSell(HttpServletRequest request) {
		 	
		 	//임시 userId
		 	HttpSession session = request.getSession();
			session.setAttribute("AUTHUSER_ID", "hongid");//임시
			
			return "product/productAddForm";
		}
	
	 //판매하기 글 등록
	@RequestMapping(value="/productAdd",method= {RequestMethod.POST})
	public ModelAndView productAdd(ModelAndView mv,
			MultipartHttpServletRequest multipartRequest) throws Exception {
		
		Map map = new HashMap(); //글관련정보+첨부파일정보
  		
		//1.form요소 중에서(<input type="file">이 아닌 요소의 name속성의 값)파라미터명 가져오기
		Enumeration enu = multipartRequest.getParameterNames();   
		while( enu.hasMoreElements() ) {
			//map에는 key이름으로  파라미터명으로(form의 name속성값) 사용하겠다
			//value는 가져온 파라미터명을 이용하여 추출
			String name = (String)enu.nextElement();
			String value= multipartRequest.getParameter(name);
			System.out.println("컨트롤러 while문안 map.put(name,value)="+name+","+value);
	  		map.put(name,value);  //name에 들어가는 "memberId","file1","file2","file3"
	  		//<input type="file">이 아닌 것들에 대한 파라미터명과  값이 담긴다
		}
		
				
		//2.form요소 중에서<input type="file"> 가져오기		
		//여기에서는 다중파일업로드이므로  n개이니 List로 처리하겠다
		//여기에서는 BaseController로 부터 상속받은 upload()호출
		List<ImageFileVO> imageFileList = upload(multipartRequest);
		if( imageFileList!=null && imageFileList.size()!=0) {
			for( ImageFileVO imageFileVO  : imageFileList) {
				System.out.println("컨트롤러 for문안 imageFileVO="+imageFileVO);
			}
			map.put("imageFileList",imageFileList);
		}//if끝
		System.out.println("map======"+map);
	    //<input type="file">인 것들에 대한 => 업로드된 파일의 정보가 담긴다
		int sellNo=productService.productAdd(map);//글관련정보+첨부파일정보
		
	    //model처리
		mv.addObject("sellNo", sellNo);//입력된 글번호
		mv.addObject("map",map);
		mv.setViewName("redirect:/productList"); //ajax용 진행예정
		return mv;
	}
	/*
	@RequestMapping("/download")
	public void download(@RequestParam("filename") String filename, HttpServletRequest request,HttpServletResponse response)
			throws Exception {
	
			String UPLOAD_DIR="filerepo";
			String uploadPath = request.getServletContext().getRealPath("")+File.separator+UPLOAD_DIR;
			File f = new File(uploadPath+"\\"+filename);
			
			//클라이언트로부터 넘어오는 파일이름이 한글이 있는 경우 깨지지 않게하기 위함.
			filename=URLEncoder.encode(filename,"UTF-8");
			filename=filename.replace("+"," "); 	//크롬에서 간혹 공백이 + 로 바뀌어서 +를 다시  " "으로 바꿔주는 코드
			//다운로드 준비로 서버에서 클라이언트에게 다운로드 준비를 시키는 부분(다운로드 창을 띄운다)
			response.setContentLength((int)f.length());
			response.setContentType("application/x-msdownload;charset=utf-8");
			response.setHeader("Content-Disposition", "attachment;filename="+filename+";");
			response.setHeader("Content-Transfer-Encoding","binary");
			response.setHeader("Pragma", "no-cache");
			response.setHeader("Expires", "0");
			
			//다운로드를 하는 부분
			FileInputStream in = new FileInputStream(f);	//파일 읽기준비
			OutputStream out= response.getOutputStream();
			
			byte[] buffer=new byte[104];
			while(true) {
				int count=in.read(buffer);
				if(count==-1) {
					break;
				}
				out.write(buffer,0,count); //다운로드(0% ~~~~100%)
			} //while
			in.close();
			out.close();
		}   */
	
	
	// 전체 상품 목록
	@GetMapping("/productList")
	public String productList(Model model,Criteria cri) throws Exception {
		
		int count =productService.productListCount();
		
		//페이징 처리 전체 목록 조회
		model.addAttribute("list",productService.getListWithPaging(cri));
		model.addAttribute("pageMaker",new PageDTO(cri, count));
			
		
		return "product/productList";
	}
	
	//판매 상품 상세보기
	@GetMapping("/productDetail")
	public String productDetail (@RequestParam("sellNo") int sellNo,
								@RequestParam("pageNum") int pageNum,
								@RequestParam("amount") int amount,Model model,Criteria cri) throws Exception {
		
		//페이징 처리
		model.addAttribute("pageNum",cri.getPageNum());
		model.addAttribute("amount",cri.getAmount());
		
		//물품 상세 정보
		Product product = productService.productDetail(sellNo);
		 List<ImageFileVO> imageFile = productService.productImageList(sellNo);
		 model.addAttribute("productFileList",imageFile);
		 model.addAttribute("product",product);
		
		return "product/productDetail";
	}
	
	
	// 상품 상태 변경
	@PostMapping("/GoodsGradeChange")
	public String goodsGradeChange(@RequestParam("sellNo") int sellNo,
								   @RequestParam("grade") int grade, 
								   @RequestParam("vailDate") int vailDate, Model model) throws Exception {
		
		Map<String, Integer> map = new HashMap<>();
		map.put("sellNo", sellNo);
		map.put("grade", grade);
		map.put("vailDate", vailDate);
		
		productService.goodsGradeChange(map);
		
		return "redirect:/productDetail?sellNo="+sellNo;
	}
	
	
	//내가 등록한 판매글 보기
	
	
}










