package kr.co.recipe.cooking;


import java.util.ArrayList;

import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;

import kr.co.recipe.rclass.ClassDAO;
import net.utility.UploadSaveManager;


@Controller
public class cookingCont {
	private cookingDAO dao=null;	
	
	public cookingCont() {		
		dao = new cookingDAO();
		System.out.println("--cookingcont객체생성");
	}

	@RequestMapping("/recipe/recipelist.do")
	public ModelAndView list() {
		ModelAndView mav = new ModelAndView();
		mav.setViewName("recipe/RecipeList");		
		mav.addObject("list", dao.list());		
		return mav;
	}

	@RequestMapping("/recipe/reciperead.do")
	public ModelAndView read(String r_code, String m_code) {
		ModelAndView mav = new ModelAndView();
		mav.setViewName("recipe/RecipeRead");
		cookingDTO kdto =dao.read(r_code);
		ArrayList<cookingDTO> kdto2 =dao.read2(r_code);
		ArrayList<cookingDTO> kdto3 =dao.read3(r_code);
		ArrayList<cookingDTO> kdto4 =dao.read4(r_code);		
		mav.addObject("kdto2", kdto2);
		mav.addObject("kdto3", kdto3);
		mav.addObject("kdto4", kdto4);		
		cookingDTO dto=dao.mread(m_code);
		mav.addObject("kdto", kdto);
		mav.addObject("dto", dto);
		
		return mav;
	}
	
	@RequestMapping(value="recipe/script.do" , method=RequestMethod.POST)
	public ModelAndView recipeProc(@ModelAttribute cookingDTO dto, String r_code, String m_code, HttpServletRequest req, Model model) {
		ModelAndView mav=new ModelAndView();
		mav.setViewName("recipe/alert");
		String basePath=req.getRealPath("/storage");
		MultipartFile h_photomf=dto.getH_photomf();
		String H_photo=UploadSaveManager.saveFileSpring30(h_photomf, basePath);
		dto.setM_img(H_photo);
		
		cookingDTO cookingDTO=dao.read(r_code);

		int cnt=dao.post(dto, r_code, m_code);
		if(cnt!=0) {
			model.addAttribute("msg", "후기 등록 되었습니다.");	
		}else {
			model.addAttribute("msg", "후기 등록 실패했습니다.");
		}//if end

		return mav;
	}//recipeProc() end


}
