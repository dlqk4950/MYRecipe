package kr.co.recipe.member;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

import kr.co.recipe.rclass.ClassDTO;
import net.utility.DBClose;
import net.utility.DBOpen;

public class MemberDAO {
	
	private DBOpen dbopen=null;
	private Connection con=null;
	private PreparedStatement pstmt=null;
	private ResultSet rs=null;
	private StringBuilder sql=null;
	
	public MemberDAO() {
		dbopen=new DBOpen();
	}//end
	
	public MemberDTO loginProc(String m_mail, String m_passwd) {
		MemberDTO dto = null;
		try {
			con=dbopen.getConnection();
            
            sql=new StringBuilder();
            sql.append(" SELECT m_class, m_code ");
            sql.append(" FROM ts_member ");
            sql.append(" WHERE m_mail=? AND m_passwd=? ");
            sql.append(" AND m_class IN('A','S','M') ");
            
            pstmt=con.prepareStatement(sql.toString());
            pstmt.setString(1, m_mail);
            pstmt.setString(2, m_passwd);
            rs= pstmt.executeQuery();
            
            if(rs.next()) {//로그인 성공했을때
            	dto= new MemberDTO();
            	dto.setM_code(rs.getString("m_code"));
            	dto.setM_class(rs.getString("m_class"));
            }//if end
            
        }catch (Exception e) {
            System.out.println("로그인실패:"+e);
        }finally {
            DBClose.close(con, pstmt,rs);
        }//end
        return dto;
	}//loginProc() end
	
	public int insert(MemberDTO dto) {
		int cnt=0;
		try {
			 con=dbopen.getConnection();
	        
	        sql=new StringBuilder();
	        sql.append(" INSERT INTO ts_member(m_code, m_class, m_mail, m_passwd, m_nick, m_gen, m_birth, m_img) ");
	        sql.append(" VALUES ((select CONCAT('m_code',(SELECT nvl(max(TO_NUMBER(SUBSTR(m_code,7))),0)+1 from ts_member)) from ts_member where rownum=1), 'A', ?, ?, ?, ?, ?, ?)");
	        
	        pstmt=con.prepareStatement(sql.toString());
	        pstmt.setString(1, dto.getM_mail());
	        pstmt.setString(2, dto.getM_passwd());
	        pstmt.setString(3, dto.getM_nick());
	        pstmt.setString(4, dto.getM_gen());
	        pstmt.setString(5, dto.getM_birth());
	        pstmt.setString(6, dto.getM_img());

	        cnt=pstmt.executeUpdate();
	        
	    }catch (Exception e) {
	        System.out.println("회원 가입 실패:" + e);
	    }finally {
	        DBClose.close(con, pstmt);
	    }//end
	    return cnt;
		
	}//insert() end
	
	public int duplecateemail(MemberDTO dto) {
		int cnt=0;
		try {
			 con=dbopen.getConnection();
            
            sql=new StringBuilder();
            sql.append(" SELECT COUNT(*) as cnt ");
            sql.append(" FROM ts_member ");
            sql.append(" WHERE m_mail=? ");
            
            pstmt=con.prepareStatement(sql.toString());
			pstmt.setString(1, dto.getM_mail());
            
            rs= pstmt.executeQuery();
            if(rs.next()) {
            	cnt=rs.getInt("cnt");
            }//if end	
            
        }catch (Exception e) {
            System.out.println("이메일 중복확인 실패:" + e);
        }finally {
            DBClose.close(con, pstmt,rs);
        }//end
        return cnt;
		
	}//duplecateemail() end
		
	public MemberDTO read(String m_code) {
		MemberDTO dto = null;
		try {
			con = dbopen.getConnection();
			sql = new StringBuilder();
			sql.append(" SELECT m_code, m_mail, m_nick, m_gen, m_birth, m_img ");
			sql.append(" FROM ts_member ");
			sql.append(" WHERE m_code = ? ");
			pstmt=con.prepareStatement(sql.toString());
			pstmt.setString(1, m_code);
			rs = pstmt.executeQuery();
			if(rs.next()) {
				dto = new MemberDTO();
				dto.setM_code(rs.getString("m_code"));
				dto.setM_mail(rs.getString("m_mail"));
				dto.setM_nick(rs.getString("m_nick"));
				dto.setM_gen(rs.getString("m_gen"));
				dto.setM_birth(rs.getString("m_birth"));
				dto.setM_img(rs.getString("m_img"));
			}//if end
			
		}catch(Exception e){
			System.out.println("회원정보보기 실패 : " + e);
		}finally {
			DBClose.close(con, pstmt, rs);
		}//end
		return dto;	
	}//read() end

	public int deleteProc(MemberDTO dto) {
        int cnt=0;
        try {
            con=dbopen.getConnection();
            
            sql=new StringBuilder();
            sql.append(" UPDATE ts_member ");
            sql.append(" SET m_class='F' ");
            sql.append(" WHERE m_mail=? AND m_passwd=? ");
            
            pstmt=con.prepareStatement(sql.toString());
            pstmt.setString(1, dto.getM_mail());
            pstmt.setString(2, dto.getM_passwd());
            cnt=pstmt.executeUpdate();

        }catch (Exception e) {
            System.out.println("회원탈퇴 실패:"+e);
        }finally {
            DBClose.close(con, pstmt);
        }//end
        return cnt;
	}//deleteProc() end 
	
	public int modifyProc(MemberDTO dto) {
        int cnt=0;
        try {
            con=dbopen.getConnection();
            
            sql=new StringBuilder();
            sql.append(" UPDATE ts_member ");
            sql.append(" SET m_passwd=? ");
            sql.append(" 	,m_nick=? ");
            sql.append(" 	,m_gen=? ");
            sql.append(" 	,m_img=? ");
            sql.append(" WHERE m_code=? ");
            
            pstmt=con.prepareStatement(sql.toString());
            pstmt.setString(1, dto.getM_passwd());
            pstmt.setString(2, dto.getM_nick());
            pstmt.setString(3, dto.getM_gen());
            pstmt.setString(4, dto.getM_img());
            pstmt.setString(5, dto.getM_code());
            cnt=pstmt.executeUpdate();
            
        }catch (Exception e) {
            System.out.println("수정 실패:" + e);
        }finally {
            DBClose.close(con, pstmt);
        }//end
        return cnt;
    }//modifyProc() end 
	public ArrayList<MemberDTO> list() {
		ArrayList<MemberDTO> list = null;
		try {
			con = dbopen.getConnection();

			sql = new StringBuilder();
			sql.append("select m_code, m_mail, m_nick, m_gen, m_birth, m_img  FROM ts_member");

			pstmt = con.prepareStatement(sql.toString());
			rs = pstmt.executeQuery();
			if (rs.next()) {
				list = new ArrayList<MemberDTO>();
				do {
					MemberDTO dto = new MemberDTO();
					dto.setM_code(rs.getString("m_code"));
					dto.setM_mail(rs.getString("m_mail"));
					dto.setM_nick(rs.getString("m_nick"));
					dto.setM_gen(rs.getString("m_gen"));
					dto.setM_birth(rs.getString("m_birth"));
					dto.setM_img(rs.getString("m_img"));
					list.add(dto);
				} while (rs.next());
			}
		} catch (Exception e) {
			System.out.println("member 목록 실패" + e);
		} finally {
			DBClose.close(con, pstmt, rs);
		}
		return list;
	}
}//class end