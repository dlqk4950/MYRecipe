package kr.co.recipe.member;

import java.io.PrintWriter;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.json.simple.JSONObject;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;

import kr.co.recipe.member.MemberDTO;
import net.utility.*;


@Controller
public class MemberCont {
	
	private MemberDAO dao=null;
	
	public MemberCont() {
		dao=new MemberDAO();
		System.out.println("-----MemberCont()객체 생성됨");
	}//end
	
	/*
	 	MYRecipe프로젝트의 첫페이지 호출
	 	결과확인 http://localhost:9095/index.do
	*/

	@RequestMapping(value="/member/login.do" , method =RequestMethod.GET)
	public String loginform() {

		return "member/loginform"; // /WEB-INF/views/member/loginform.jsp		
	}//loginform() end
	
	@RequestMapping(value="/member/login.do" , method=RequestMethod.POST)
	public ModelAndView loginProc(HttpServletRequest req, HttpServletResponse resp, Model model) {
			
		ModelAndView mav=new ModelAndView();
		mav.setViewName("member/alert");
		
			HttpSession session=req.getSession();
			
			String m_mail=req.getParameter("m_mail");
			String m_passwd=req.getParameter("m_passwd");
			
			MemberDTO dto=dao.loginProc(m_mail, m_passwd);
			
			
			if (dto==null) { //로그인 실패
				model.addAttribute("msg", "아이디 또는 비밀번호가 잘못되었습니다.");
				dto=new MemberDTO();
				dto.setM_code("guest");
			}else {	//로그인 성공							
				//세션에 메일, 비번, 등급 올리기
				session.setAttribute("s_m_mail", m_mail);
				session.setAttribute("s_m_passwd", m_passwd);
				session.setAttribute("s_m_class", dto.getM_class());
				session.setAttribute("s_m_code", dto.getM_code());
				
				model.addAttribute("msg", "로그인 되었습니다.");
				String c_m_mail=Utility.checkNull(req.getParameter("c_m_mail"));
				Cookie cookie=null;
				if(c_m_mail.equals("SAVE")){
					cookie=new Cookie("c_m_mail", m_mail);
					cookie.setMaxAge(60*60*24*30);
				}else{
					cookie=new Cookie("c_m_mail", "");
					cookie.setMaxAge(0);
				}//if end
				
				resp.addCookie(cookie);
			}//if end

		//로그인에 성공하면 dto객체가 값을 가질 수 있지만
		//로그인에 실패하면 dto가 null이 반환되므로...dto.getM_code()를 꺼내올수 없습니다	
		mav.addObject("m_code", dto.getM_code());
			
		System.out.println(dto.getM_code());
		return mav;
		
	}//loginProc() end
	

	@RequestMapping(value="member/logout.do" , method =RequestMethod.GET)
	public String logout() {
		
		return "member/logout";
	}//logout() end	
	
	@RequestMapping(value="member/member.do" , method =RequestMethod.GET)
	public String memberform() {
		return "member/memberform"; // /WEB-INF/views/member/loginform.jsp		
	}//memberform() end
	
	
	@RequestMapping(value="member/member.do" , method=RequestMethod.POST)
	public ModelAndView memberProc(@ModelAttribute MemberDTO dto, HttpServletRequest req, Model model) {
		
		ModelAndView mav=new ModelAndView();
		mav.setViewName("member/alert");
		
		String basePath=req.getRealPath("/storage");
		
		MultipartFile m_imgmf=dto.getM_imgmf();
		String M_img=UploadSaveManager.saveFileSpring30(m_imgmf, basePath);
		dto.setM_img(M_img);
		
		String m_mail=req.getParameter("m_mail");
		String m_passwd=req.getParameter("m_passwd");
		String m_nick=req.getParameter("m_nick");
		String m_gen=req.getParameter("m_gen");
		String m_birth=req.getParameter("m_birth");
		String m_img=req.getParameter("m_img");

		dto.setM_mail(m_mail);
		dto.setM_passwd(m_passwd);
		dto.setM_nick(m_nick);
		dto.setM_gen(m_gen);
		dto.setM_birth(m_birth);
		dto.setM_img(m_img);
		
		int cnt=dao.insert(dto);
		if(cnt!=0) {
			model.addAttribute("msg", "회원가입 되었습니다.");			
		}else {
			model.addAttribute("msg", "회원가입 실패했습니다.");
		}//if end

		return mav;
	}//memberProc() end
//--------------------------------------------------------------------------------------	
	@RequestMapping("member/duplecatem_mail.do")
	public void duplecatem_mail(@ModelAttribute MemberDTO dto, HttpServletRequest req, HttpServletResponse resp) {
		try {

			String m_mail=req.getParameter("m_mail");
			int cnt=dao.duplecateemail(dto);
			
			JSONObject json=new JSONObject();
			json.put("count", cnt);
			
			resp.setContentType("text/plain; charset=UTF-8");
			PrintWriter out=resp.getWriter();
			out.print(json.toString());
			out.flush();
			

		}catch(Exception e) {
			System.out.println("email 중복확인 쿠키 실패:" + e);
		}//end
	}//duplecatem_mail() end
	
	@RequestMapping(value="member/read.do")
	public ModelAndView read(String m_code) {
		ModelAndView mav=new ModelAndView();
		MemberDTO dto=dao.read(m_code);
		mav.addObject("dto", dto);

		return mav;
	}//read() end
	
	@RequestMapping(value="member/delete.do" , method =RequestMethod.GET)
	public String delete(HttpServletRequest req) {
		HttpSession session=req.getSession();
		String s_m_mail = (String)session.getAttribute("s_m_mail");
		if (s_m_mail == null){
			return "redirect:/member/login.do";			
		}else
			return "member/delete"; // /WEB-INF/views/member/delete.jsp
		
	}//delete() end
	
	@RequestMapping(value="member/delete.do" , method =RequestMethod.POST)
	public ModelAndView deleteProc(@ModelAttribute MemberDTO dto, HttpServletRequest req, Model model) {
		
		ModelAndView mav=new ModelAndView();
		mav.setViewName("member/alert");
		
		HttpSession session=req.getSession();
		
		String m_mail	=req.getParameter("m_mail").trim();
		String m_passwd	=req.getParameter("m_passwd").trim();
		
		dto.setM_mail(m_mail);
		dto.setM_passwd(m_passwd);
		
		int cnt=dao.deleteProc(dto);
		if(cnt!=0) {
			session.removeAttribute("s_m_mail");
			session.removeAttribute("s_m_passwd");
			session.removeAttribute("s_m_class");
			model.addAttribute("msg", "회원탈퇴 되었습니다.");			
		}else {
			model.addAttribute("msg", "회원탈퇴 실패했습니다.");
		}//if end
			
		return mav;		
	}//deleteProc() end

	@RequestMapping(value="member/modify.do" , method =RequestMethod.GET)
	public ModelAndView membermodify(HttpServletRequest req ,String m_code) {
		HttpSession session=req.getSession();
		String s_m_mail = (String)session.getAttribute("s_m_mail");
		ModelAndView mav=new ModelAndView();
		
//----------------------------------------------------------------------------
		
		MemberDTO oldDTO=dao.read(m_code);
		mav.addObject("dto", oldDTO);
		if (s_m_mail == null){
			mav.setViewName("member/loginform");
			return mav;			
		}else
			mav.setViewName("member/membermodify");
			return mav;
	}//membermodify() end
		
	
	@RequestMapping(value="member/modify.do" , method =RequestMethod.POST)
	public ModelAndView modifyProc(@ModelAttribute MemberDTO dto, HttpServletRequest req, Model model) {
		System.out.println(dto.getM_imgmf());
		ModelAndView mav=new ModelAndView();
		mav.setViewName("member/alert");
		
//----------------------------------------------------------------------------
		String basePath=req.getRealPath("/storage");
		MemberDTO oldDTO=dao.read(dto.getM_code());
				
		MultipartFile m_imgmf=dto.getM_imgmf();
		
		if(m_imgmf.getSize()>0) {
			UploadSaveManager.deleteFile(basePath, oldDTO.getM_img());
			String m_img=UploadSaveManager.saveFileSpring30(m_imgmf, basePath);
			dto.setM_img(m_img);
		}else {			
			 dto.setM_img(oldDTO.getM_img());
		}//if end
	System.out.println(dto.getM_img());
		int cnt=dao.modifyProc(dto); 
		if(cnt!=0) {
			model.addAttribute("msg", "회원정보 수정 되었습니다.");			
		}else {
			model.addAttribute("msg", "회원정보 수정 실패했습니다.");
		}//if end
			

		return mav;		
	}//modifyProc() end
	
}//class end
