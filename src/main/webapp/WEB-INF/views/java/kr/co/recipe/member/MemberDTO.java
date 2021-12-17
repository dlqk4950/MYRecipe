package kr.co.recipe.member;

import org.springframework.web.multipart.MultipartFile;

	public class MemberDTO {
		private String m_code;
		private String m_class;
		private String m_mail;
		private String m_passwd;
		private String m_nick;
		private String m_gen;
		private String m_birth;
		private String m_img;
	
		public MemberDTO() {}
//---------------------------------------------------------------------------
		//첨부된 파일 저장
		private MultipartFile m_imgmf;
		

		public MultipartFile getM_imgmf() {
			return m_imgmf;
		}

		public void setM_imgmf(MultipartFile m_imgmf) {
			this.m_imgmf = m_imgmf;
		}
//---------------------------------------------------------------------------		

		public String getM_code() {
			return m_code;
		}

		public void setM_code(String m_code) {
			this.m_code = m_code;
		}

		public String getM_class() {
			return m_class;
		}

		public void setM_class(String m_class) {
			this.m_class = m_class;
		}

		public String getM_mail() {
			return m_mail;
		}

		public void setM_mail(String m_mail) {
			this.m_mail = m_mail;
		}

		public String getM_passwd() {
			return m_passwd;
		}

		public void setM_passwd(String m_passwd) {
			this.m_passwd = m_passwd;
		}

		public String getM_nick() {
			return m_nick;
		}

		public void setM_nick(String m_nick) {
			this.m_nick = m_nick;
		}

		public String getM_gen() {
			return m_gen;
		}

		public void setM_gen(String m_gen) {
			this.m_gen = m_gen;
		}

		public String getM_birth() {
			return m_birth;
		}

		public void setM_birth(String m_birth) {
			this.m_birth = m_birth;
		}

		public String getM_img() {
			return m_img;
		}

		public void setM_img(String m_img) {
			this.m_img = m_img;
		}
		
		
}
