package kr.co.recipe.rclass;

import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;

import net.utility.UploadSaveManager;

@Controller
public class ClassCont {
	private ClassDAO dao = null;

	public ClassCont() {
		dao = new ClassDAO();
		System.out.println("--classcont객체생성");
	}

	@RequestMapping("/class/classlist.do")
	public ModelAndView list() {
		ModelAndView mav = new ModelAndView();
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
		
		int cnt=dao.create(dto,m_code);
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
	public ModelAndView read(String l_code) {		
		 ModelAndView mav= new ModelAndView();
		 ClassDTO dto =dao.read(l_code);
		 dao.incrementCnt(l_code);
		mav.setViewName("class/ClassRead");
		mav.addObject("dto", dto);	
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
}