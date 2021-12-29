package kr.co.recipe.rclass;

import org.springframework.web.multipart.MultipartFile;

public class ClassDTO {
	private String l_code;
	private String l_title;
	private String l_photo;
	private String l_contents; 
	private String l_tumbsup;
	private int l_views;
	private String g_code;
	private String m_nick;
	
	private String p_code;
	private String m_code;
	private int p_price;
	private int p_count;
	private String p_div; 
	private String p_date;
	private String m_mail;
	private String m_img;
	
	
	
	
	public String getM_img() {
		return m_img;
	}
	public void setM_img(String m_img) {
		this.m_img = m_img;
	}
	public String getP_code() {
		return p_code;
	}
	public void setP_code(String p_code) {
		this.p_code = p_code;
	}
	public String getM_code() {
		return m_code;
	}
	public void setM_code(String m_code) {
		this.m_code = m_code;
	}
	public int getP_price() {
		return p_price;
	}
	public void setP_price(int p_price) {
		this.p_price = p_price;
	}
	public int getP_count() {
		return p_count;
	}
	public void setP_count(int p_count) {
		this.p_count = p_count;
	}
	public String getP_div() {
		return p_div;
	}
	public void setP_div(String p_div) {
		this.p_div = p_div;
	}
	public String getP_date() {
		return p_date;
	}
	public void setP_date(String p_date) {
		this.p_date = p_date;
	}
	public String getM_mail() {
		return m_mail;
	}
	public void setM_mail(String m_mail) {
		this.m_mail = m_mail;
	}
	public ClassDTO() {
	
	}

	// createForm.jsp
	// 1) 스프링 파일 객체 멩버 변수 선언
	// <input type='file' name='posterMF' size='50'>
	private MultipartFile posterMF;
	// <input type='file' name='filenameMF' size='50'>
	private MultipartFile filenameMF;
	// getter과 setter함수 작성
	
	public MultipartFile getPosterMF() {
		return posterMF;
	}
	public void setPosterMF(MultipartFile posterMF) {
		this.posterMF = posterMF;
	}

	public MultipartFile getFilenameMF() {
		return filenameMF;
	}

	public void setFilenameMF(MultipartFile filenameMF) {
		this.filenameMF = filenameMF;
	}
	public String getL_code() {
		return l_code;
	}
	public void setL_code(String l_code) {
		this.l_code = l_code;
	}
	public String getL_title() {
		return l_title;
	}
	public void setL_title(String l_title) {
		this.l_title = l_title;
	}
	public String getL_photo() {
		return l_photo;
	}
	public void setL_photo(String l_photo) {
		this.l_photo = l_photo;
	}

	public String getL_contents() {
		return l_contents;
	}
	public void setL_contents(String l_contents) {
		this.l_contents = l_contents;
	}
	public String getL_tumbsup() {
		return l_tumbsup;
	}
	public void setL_tumbsup(String l_tumbsup) {
		this.l_tumbsup = l_tumbsup;
	}
	public int getL_views() {
		return l_views;
	}
	public void setL_views(int l_views) {
		this.l_views = l_views;
	}
	public String getG_code() {
		return g_code;
	}
	public void setG_code(String g_code) {
		this.g_code = g_code;
	}
	public String getM_nick() {
		return m_nick;
	}
	public void setM_nick(String m_nick) {
		this.m_nick = m_nick;
	}

	
	
	
	
	
	
}
