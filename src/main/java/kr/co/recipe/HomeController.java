package kr.co.recipe;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class HomeController {
	public HomeController() {
		System.out.println("---homecontroller");	
	}
	@RequestMapping("/home.do")
	public ModelAndView home() {
		ModelAndView mav = new ModelAndView();
		mav.setViewName("redirect:/index.do");
		return mav;
	}
	
	//http://localhost:9095/../home.do
}
