package kr.co.recipe.rclass;

import java.io.BufferedReader;
import java.io.DataOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.PrintWriter;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.ArrayList;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.json.simple.JSONObject;
import org.springframework.stereotype.Controller;

import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;

import kr.co.recipe.member.MemberDAO;
import kr.co.recipe.member.MemberDTO;
import net.utility.UploadSaveManager;


@Controller
public class ClassCont {
	private ClassDAO dao = null;
	private MemberDAO mdao = null;
	
	public ClassCont() {
		dao = new ClassDAO();
		System.out.println("--classcont객체생성");
	}

	@RequestMapping("/class/classlist.do")
	public ModelAndView list(HttpServletRequest req) {
		ModelAndView mav = new ModelAndView();
		HttpSession session=req.getSession();
		String m_code = (String)session.getAttribute("s_m_code");	
		mav.setViewName("class/ClassList");
		mav.addObject("list", dao.list());	

		return mav;
	}
	@RequestMapping(value = "/class/create.do", method = RequestMethod.GET) 
	public ModelAndView createForm(String m_code) {
		ModelAndView mav=new ModelAndView();
		mav.setViewName("class/ClassForm");		
		mav.addObject("m_code", m_code);
		return mav;
	}
	
	@RequestMapping(value = "/class/create.do", method = RequestMethod.POST)
	public ModelAndView createProc(@ModelAttribute ClassDTO dto, String m_code, HttpServletRequest req) {
		ModelAndView mav=new ModelAndView();
		mav.setViewName("redirect:/class/classlist.do");
		//첨부된 파일 처리
		//실제파일은 /storage폴더에저장
		//저장된 관련 정보는 media테이블에 저장
		
		//파일 저장 폴더의 실제 물리적인경로 가져오기
		String basePath=req.getRealPath("/storage");
		//1)<input type='file' name='posterMF' size='50'>
		//파일가져오기
		MultipartFile posterMF= dto.getPosterMF();
		//storage폴더에 파일을 저장하고, 리네임된 파일명 변환
		String l_photo = UploadSaveManager.saveFileSpring30(posterMF, basePath);
		dto.setL_photo(l_photo);
		
		
		MultipartFile filenameMF= dto.getFilenameMF();
		String l_tumbsup = UploadSaveManager.saveFileSpring30(filenameMF, basePath);
		dto.setL_tumbsup(l_tumbsup);
		int cnt=0;
		String lcode = dao.lcode();
		
		if (lcode=="l_code1") {
			dto.setP_code("l_code1");			
			cnt=dao.create(dto,m_code);	
		}else {
			cnt=dao.create(dto,m_code);	
		}
		
		if (cnt==0) {
			
			UploadSaveManager.deleteFile(basePath, l_photo);
			UploadSaveManager.deleteFile(basePath, l_tumbsup);
			System.out.println("등록 실패");
		}else {
			System.out.println("등록 성공");	
		}
		return mav;
	}
	@RequestMapping(value = "/class/classread.do", method = RequestMethod.GET)
	public ModelAndView read(String l_code, String g_code, HttpServletRequest req) {		
		 ModelAndView mav= new ModelAndView();
		 HttpSession session=req.getSession();
		 String m_code = (String)session.getAttribute("s_m_code");			 
		 
		 ClassDTO cdto =dao.subdiv(m_code, g_code); 
		 ClassDTO dto =dao.read(l_code);
		 dao.incrementCnt(l_code);	
		 
		 
		mav.setViewName("class/ClassRead");
		mav.addObject("dto", dto);
		mav.addObject("cdto", cdto);
		 	
		
		return mav;
	}
	
	@RequestMapping(value = "class/delete.do")
	public ModelAndView deleteProc(String l_code, HttpServletRequest req) {
		ModelAndView mav=new ModelAndView();
		mav.setViewName("redirect:/class/classlist.do");
		
		//삭제하고자 하는 글정보 가져오기 (storage 폴더에서 삭제할 파일명을 보관하기위해)
		ClassDTO classDTO=dao.read(l_code);
		
		int cnt=dao.delete(l_code);		
		
		if (cnt==0) {
			System.out.println("강의 삭제 실패");		
		}else {
			String basePath= req.getRealPath("/storage");
			UploadSaveManager.deleteFile(basePath, classDTO.getL_photo());
			UploadSaveManager.deleteFile(basePath, classDTO.getL_tumbsup());
		}
		return mav;
	}
	@RequestMapping(value = "class/update.do", method = RequestMethod.GET)
	public ModelAndView updateForm(String l_code) {
		ModelAndView mav=new ModelAndView();
		mav.setViewName("class/UpdateForm");
		ClassDTO dto = dao.read(l_code);// 수정하고자하는 행
		mav.addObject("dto", dto);
		return mav;
	}
	@RequestMapping(value = "class/update.do", method = RequestMethod.POST)
	public ModelAndView updateProc(@ModelAttribute ClassDTO dto, HttpServletRequest req, String l_code) {		
		ModelAndView mav=new ModelAndView();	
		mav.setViewName("redirect:/class/classlist.do");
		
		String basePath = req.getRealPath("/storage");
		ClassDTO oldDTO = dao.read(l_code);
		
		//파일을 수정할것인지
		//1)
		MultipartFile posterMF=dto.getPosterMF();
		if (posterMF.getSize()>0) {
			//기존 파일 삭제
			UploadSaveManager.deleteFile(basePath, oldDTO.getL_photo());
			//신규 파일 저장
			String l_photo=UploadSaveManager.saveFileSpring30(posterMF, basePath);
			dto.setL_photo(l_photo);
		}else {
			dto.setL_photo(oldDTO.getL_photo());
		}
		//2)
		MultipartFile filenameMF=dto.getFilenameMF();
		if (filenameMF.getSize()>0) {
			//기존 파일 삭제
			UploadSaveManager.deleteFile(basePath, oldDTO.getL_tumbsup());
			//신규 파일 저장
			String l_tumbsup=UploadSaveManager.saveFileSpring30(filenameMF, basePath);
			dto.setL_tumbsup(l_tumbsup);			
		}else {
			dto.setL_tumbsup(oldDTO.getL_tumbsup());
			
		}
		int cnt= dao.update(dto,l_code);		
		if (cnt==0) {
			System.out.println("등록 실패");
		}else {
			System.out.println("등록 성공");	
		}		
		return mav;
	}
	@RequestMapping(value = "class/subscribe.do", method = RequestMethod.GET)
	public ModelAndView subscribeForm(HttpServletRequest req, String m_code) {
		ModelAndView mav=new ModelAndView();
		HttpSession session=req.getSession();
		String s_m_mail = (String)session.getAttribute("s_m_mail");	

		if (s_m_mail == null){
			mav.setViewName("redirect:/member/login.do");
			return mav;			
		}else
			mav.setViewName("class/ClassSubScribe");
		ArrayList<ClassDTO> dto =dao.sublist(m_code);
		ArrayList<ClassDTO> cdto =dao.sublist2(m_code);		
		mav.addObject("sublist", dto);		
		mav.addObject("sublist2", cdto);			
		
		return mav;
	}
	@RequestMapping(value = "class/kakaopay.do", method = RequestMethod.POST)
	@ResponseBody
	public String kakaopay(HttpServletRequest req, HttpServletResponse resp) { //dto로 받는거 보다는 request로 받아서 해당값만 뽑아쓰는 것이 좋을 듯합닏
		try {
			// 보내는 부분
			System.out.println(req.getParameter("suburl"));
			System.out.println(req.getParameter("p_count"));	
			String suburl="";
			
			URL address = new URL("https://kapi.kakao.com/v1/payment/ready");
			HttpURLConnection connection = (HttpURLConnection) address.openConnection(); // 서버연결
			connection.setRequestMethod("POST");
			connection.setRequestProperty("Authorization", "KakaoAK 8baccfa6b8497ace4a77d5b7a58ca021"); // 어드민 키
			connection.setRequestProperty("Content-type", "application/x-www-form-urlencoded;charset=utf-8");
			connection.setDoOutput(true); // 서버한테 전달할게 있는지 없는지
			String parameter = "cid=TC0ONETIME" // 가맹점 코드
					+ "&partner_order_id=partner_order_id" // 가맹점 주문번호
					+ "&partner_user_id=partner_user_id" // 가맹점 회원 id
					+ "&item_name=초코파이" // 상품명
					+ "&quantity=1" // 상품 수량
					+ "&total_amount=5000" // 총 금액
					+ "&vat_amount=200" // 부가세
					+ "&tax_free_amount=0" // 상품 비과세 금액
					+ "&approval_url=http://localhost:9095/class/"+suburl // 결제 성공 시
					+ "&fail_url=http://localhost:9095/" // 결제 실패 시
					+ "&cancel_url=http://localhost:9095/class/subscribepay.do";
					//+ "&cancel_url=http://localhost:9095/class/subscribepay.do"; // 결제 취소 시
			OutputStream send = connection.getOutputStream(); // 이제 뭔가를 를 줄 수 있다.
			DataOutputStream dataSend = new DataOutputStream(send); // 이제 데이터를 줄 수 있다.
			dataSend.writeBytes(parameter); // OutputStream은 데이터를 바이트 형식으로 주고 받기로 약속되어 있다. (형변환)			
			dataSend.close(); // flush가 자동으로 호출이 되고 닫는다. (보내고 비우고 닫다)
			
			int result = connection.getResponseCode(); // 전송 잘 됐나 안됐나 번호를 받는다.
			InputStream receive; // 받다
			
			if(result == 200) {
				receive = connection.getInputStream();		
				
			}else {
				receive = connection.getErrorStream();				
			}
			// 읽는 부분
			InputStreamReader read = new InputStreamReader(receive); // 받은걸 읽는다.			
			BufferedReader change = new BufferedReader(read); // 바이트를 읽기 위해 형변환 버퍼리더는 실제로 형변환을 위해 존제하는 클레스는 아니다.
			// 받는 부분
			
			//JSONObject json=new JSONObject();
			//json.put("data", change.readLine());
			String paysite =change.readLine();
			int a= paysite.lastIndexOf("next_redirect_pc_url");
			int b= paysite.lastIndexOf("android_app_scheme");
			String resultsite = paysite.substring(a+23,b-3);
			
			return resultsite; // 문자열로 형변환을 알아서 해주고 찍어낸다 그리고 본인은 비워진다.
			
		} catch (MalformedURLException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		return "(\"result\":\"NO\")";
	}


	@RequestMapping(value = "class/subscribepay.do")
	public ModelAndView subscribeProc(String g_code, HttpServletRequest req) {
		ClassDTO cdto = null;		
		String s_g_code=g_code;
		
		ModelAndView mav = new ModelAndView();
		
		HttpSession session=req.getSession();
		String m_code = (String)session.getAttribute("s_m_code");		
		cdto =dao.subdiv(m_code, g_code);
		
		
		if (cdto==null) {			
			mav.setViewName("class/SubScribeInsert");
			mav.addObject("g_code", s_g_code);						
		}else {
			mav.setViewName("redirect:/class/subscribe.do");
			mav.addObject("m_code", m_code);
			mav.addObject("req", req);			
		}
		return mav;
	}
	@RequestMapping(value = "/class/insertsubscribe.do", method = RequestMethod.POST)
	public ModelAndView insertsubsctibe(@ModelAttribute ClassDTO dto, String g_code, HttpServletRequest req) {
		ModelAndView mav=new ModelAndView();
		mav.setViewName("redirect:/class/classlist.do");
		HttpSession session=req.getSession();
		String m_code = (String)session.getAttribute("s_m_code");	
		int cnt=0;
		String pcode = dao.pcode();
		System.out.println(pcode);
		if (pcode=="p_code1") {
			dto.setP_code("p_code1");			
			cnt=dao.insertsubscribe(dto, g_code, m_code);	
		}else {
			cnt=dao.insertsubscribe(dto, g_code, m_code);	
		}
		
		if (cnt==0) {
			System.out.println("등록 실패");
		}else {
			System.out.println("등록 성공");	
		}
		return mav;
	}	
	@RequestMapping(value = "/class/presentsubscribe.do", method = RequestMethod.POST)
	public ModelAndView  presentsubsctibe(@ModelAttribute ClassDTO dto, String g_code) {
		ModelAndView mav=new ModelAndView();
		mav.setViewName("redirect:/class/classlist.do");
		
		ClassDTO cdto = null;
		cdto =dao.nickread(dto.getM_nick());
		
		int cnt=dao.insertsubscribe(dto, g_code,cdto.getM_code());
		if (cnt==0) {
			System.out.println("등록 실패");
		}else {
			System.out.println("등록 성공");	
		}
		return mav;
	}	
	@RequestMapping(value = "/class/updatesubscribe.do")
	public ModelAndView updatesubsctibe(@ModelAttribute ClassDTO dto, String g_code, HttpServletRequest req) {
		ModelAndView mav=new ModelAndView();
		mav.setViewName("redirect:/class/classlist.do");
		HttpSession session=req.getSession();
		String m_code = (String)session.getAttribute("s_m_code");
		
		int cnt=dao.updatesubscribe(dto, g_code, m_code);
		if (cnt==0) {
			System.out.println("update 등록 실패");
		}else {
			System.out.println("update등록 성공");	
		}
		return mav;
	}	
	@RequestMapping(value = "/class/uppresentsubscribe.do", method = RequestMethod.POST)
	public ModelAndView  uppresentsubsctibe(@ModelAttribute ClassDTO dto, String g_code) {
		ModelAndView mav=new ModelAndView();
		mav.setViewName("redirect:/class/classlist.do");
		
		ClassDTO cdto = null;
		cdto =dao.nickread(dto.getM_nick());
		System.out.println(cdto.getM_code());
		int cnt=dao.updatesubscribe(dto, g_code,cdto.getM_code());
		if (cnt==0) {
			System.out.println("등록 실패");
		}else {
			System.out.println("등록 성공");	
		}
		return mav;
	}	
}