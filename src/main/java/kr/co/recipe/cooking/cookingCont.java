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

import net.utility.UploadSaveManager;


@Controller
public class cookingCont {
	private cookingDAO dao=null;
	private cookingDAO kdao= null;
	private cookingDAO kdao2= null;
	private cookingDAO kdao3= null;
	private cookingDAO kdao4= null;
	
	public cookingCont() {
		dao = new cookingDAO();
		kdao = new cookingDAO();
		kdao2 = new cookingDAO();
		kdao3 = new cookingDAO();
		kdao4 = new cookingDAO();
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
		ArrayList<cookingDTO> kdto2 =kdao2.read2(r_code);
		ArrayList<cookingDTO> kdto3 =kdao3.read3(r_code);
		ArrayList<cookingDTO> kdto4 =kdao4.read4(r_code);		
		mav.addObject("kdto2", kdto2);
		mav.addObject("kdto3", kdto3);
		mav.addObject("kdto4", kdto4);
		cookingDTO kdto =kdao.read(r_code);
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
	}

	@RequestMapping(value = "/recipe/insert.do", method = RequestMethod.GET) 
	public ModelAndView createForm(String m_code) {
		ModelAndView mav=new ModelAndView();
		mav.setViewName("recipe/RecipeForm");		
		mav.addObject("m_code", m_code);
		return mav;
	}
	
	@RequestMapping(value = "/recipe/insert.do", method = RequestMethod.POST)
	public ModelAndView createProc(@ModelAttribute cookingDTO dto, String m_code, HttpServletRequest req) {
		ModelAndView mav=new ModelAndView();
		mav.setViewName("redirect:/recipe/recipelist.do");

		String basePath=req.getRealPath("/storage");

		MultipartFile posterMF= dto.getPosterMF();

		String r_photo = UploadSaveManager.saveFileSpring30(posterMF, basePath);
		dto.setR_photo(r_photo);

		int cnt=dao.insert(dto,m_code);
		if (cnt==0) {

			UploadSaveManager.deleteFile(basePath, r_photo);
			System.out.println("등록 실패");
		}else {
			System.out.println("등록 성공");	
		}
		return mav;
	}
}
