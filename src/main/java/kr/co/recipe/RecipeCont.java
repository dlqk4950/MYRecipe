package kr.co.recipe;

import java.util.ArrayList;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import kr.co.recipe.member.MemberDAO;
import kr.co.recipe.member.MemberDTO;
import kr.co.recipe.rclass.ClassDAO;
import kr.co.recipe.rclass.ClassDTO;
@Controller
public class RecipeCont {
	private ClassDAO cdao = null;
	private MemberDAO mdao=null;
		
	
	public RecipeCont() {	
		cdao = new ClassDAO();	
		mdao=new MemberDAO();
		System.out.println("------recipeCont객체생성됨");
	}

	@RequestMapping("/index.do")
	public ModelAndView list() {
		ModelAndView mav = new ModelAndView();
		mav.setViewName("/index");
		ArrayList<ClassDTO> cdto =cdao.list();
		ArrayList<MemberDTO> mdto =mdao.list();
		mav.addObject("cdto", cdto);
		mav.addObject("mdto", mdto);
		return mav;
	}
}
