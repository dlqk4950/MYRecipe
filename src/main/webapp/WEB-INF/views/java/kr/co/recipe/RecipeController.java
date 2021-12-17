package kr.co.recipe;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class RecipeController {
	public RecipeController() {
		System.out.println("-----RecipeController()객체 생성됨");
	}//end
	
	/*
	 	MYRecipe프로젝트의 첫페이지 호출
	 	결과확인 http://localhost:9095/index.do
	*/
	@RequestMapping("/index.do")
	public ModelAndView index() {
		ModelAndView mav=new ModelAndView();
		mav.setViewName("/index");
		return mav;
	}//index() end
}//class end
