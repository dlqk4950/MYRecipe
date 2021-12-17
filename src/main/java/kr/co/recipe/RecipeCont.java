package kr.co.recipe;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class RecipeCont {
	public RecipeCont() {
		System.out.println("------recipeCont객체생성됨");
	}

	@RequestMapping("/index.do")
	public ModelAndView list() {
		ModelAndView mav = new ModelAndView();
		mav.setViewName("/index");		
		return mav;
	}
	// TODO Auto-generated method stub

}
