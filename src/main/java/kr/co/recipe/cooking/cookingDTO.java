package kr.co.recipe.cooking;

import org.springframework.web.multipart.MultipartFile;

public class cookingDTO {
	private String r_code;
	private String r_name;
	private String r_intro;
	private String r_video;
	private String r_photo;
	private String r_tip;
	private String j_no;
	private String s_no;
	private String g_no;
	private String ci_per;
	private String ci_time;
	private String ci_diff;
	private String m_code;
	private String m_nick;
	private String m_img;
	private int h_star;
	private String h_code;	
	private String h_postcon;
	private String h_photo;
	private String h_date;
	private String r_kind;
	private String r_tname;
	private String r_mea;
	private String r_explan;
	private String r_img;
	private String r_seq;
	
	
	public cookingDTO() {}
//---------------------------------------------------------------------------
		//첨부된 파일 저장
		private MultipartFile h_photomf;
		

		public MultipartFile getH_photomf() {
			return h_photomf;
		}

		public void setH_photomf(MultipartFile h_photomf) {
			this.h_photomf = h_photomf;
		}
//---------------------------------------------------------------------------		

	private MultipartFile posterMF;

	public String getR_code() {
		return r_code;
	}
	public void setR_code(String r_code) {
		this.r_code = r_code;
	}
	public String getR_name() {
		return r_name;
	}
	public void setR_name(String r_name) {
		this.r_name = r_name;
	}
	public String getR_intro() {
		return r_intro;
	}
	public void setR_intro(String r_intro) {
		this.r_intro = r_intro;
	}
	public String getR_video() {
		return r_video;
	}
	public void setR_video(String r_video) {
		this.r_video = r_video;
	}
	public String getR_photo() {
		return r_photo;
	}
	public void setR_photo(String r_photo) {
		this.r_photo = r_photo;
	}
	public String getR_tip() {
		return r_tip;
	}
	public void setR_tip(String r_tip) {
		this.r_tip = r_tip;
	}
	public String getJ_no() {
		return j_no;
	}
	public void setJ_no(String j_no) {
		this.j_no = j_no;
	}
	public String getS_no() {
		return s_no;
	}
	public void setS_no(String s_no) {
		this.s_no = s_no;
	}
	public String getG_no() {
		return g_no;
	}
	public void setG_no(String g_no) {
		this.g_no = g_no;
	}
	public String getCi_per() {
		return ci_per;
	}
	public void setCi_per(String ci_per) {
		this.ci_per = ci_per;
	}
	public String getCi_time() {
		return ci_time;
	}
	public void setCi_time(String ci_time) {
		this.ci_time = ci_time;
	}
	public String getCi_diff() {
		return ci_diff;
	}
	public void setCi_diff(String ci_diff) {
		this.ci_diff = ci_diff;
	}
	public String getM_code() {
		return m_code;
	}
	public void setM_code(String m_code) {
		this.m_code = m_code;
	}
	public String getM_nick() {
		return m_nick;
	}
	public void setM_nick(String m_nick) {
		this.m_nick = m_nick;
	}
	public int getH_star() {
		return h_star;
	}
	public void setH_star(int h_star) {
		this.h_star = h_star;
	}
	public String getM_img() {
		return m_img;
	}
	public void setM_img(String m_img) {
		this.m_img = m_img;
	}
	public String getH_code() {
		return h_code;
	}
	public void setH_code(String h_code) {
		this.h_code = h_code;
	}
	public String getH_postcon() {
		return h_postcon;
	}
	public void setH_postcon(String h_postcon) {
		this.h_postcon = h_postcon;
	}
	public String getH_photo() {
		return h_photo;
	}
	public void setH_photo(String h_photo) {
		this.h_photo = h_photo;
	}
	public String getH_date() {
		return h_date;
	}
	public void setH_date(String h_date) {
		this.h_date = h_date;
	}
	public String getR_kind() {
		return r_kind;
	}
	public void setR_kind(String r_kind) {
		this.r_kind = r_kind;
	}
	public String getR_tname() {
		return r_tname;
	}
	public void setR_tname(String r_tname) {
		this.r_tname = r_tname;
	}
	public String getR_mea() {
		return r_mea;
	}
	public void setR_mea(String r_mea) {
		this.r_mea = r_mea;
	}
	public String getR_explan() {
		return r_explan;
	}
	public void setR_explan(String r_explan) {
		this.r_explan = r_explan;
	}
	public String getR_img() {
		return r_img;
	}
	public void setR_img(String r_img) {
		this.r_img = r_img;
	}
	public String getR_seq() {
		return r_seq;
	}
	public void setR_seq(String r_seq) {
		this.r_seq = r_seq;
	}

	public MultipartFile getPosterMF() {
		return posterMF;
	}

	public void setPosterMF(MultipartFile posterMF) {
		this.posterMF = posterMF;
	}

}
