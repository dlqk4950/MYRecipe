package kr.co.recipe.cooking;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

import kr.co.recipe.member.MemberDTO;
import kr.co.recipe.rclass.ClassDTO;
import net.utility.DBClose;
import net.utility.DBOpen;

public class cookingDAO {

	private DBOpen dbopen=null;
	private Connection con=null;
	private PreparedStatement pstmt=null;
	private ResultSet rs=null;
	private StringBuilder sql=null;
	
	public cookingDAO() {
		dbopen=new DBOpen();
	}//end
	
	public ArrayList<cookingDTO> list() {
		ArrayList<cookingDTO> list = null;
		try {
			con = dbopen.getConnection();

			sql = new StringBuilder();
			sql.append(" SELECT ts_recipe.*, ts_member.m_nick, ts_member.m_img, ts_postscript.h_star ");
			sql.append(" FROM ts_recipe JOIN ts_member ");
			sql.append(" ON ts_recipe.m_code = ts_member.m_code JOIN ts_postscript ");
			sql.append(" ON ts_recipe.r_code = ts_postscript.r_code ");
			
			pstmt = con.prepareStatement(sql.toString());
			rs = pstmt.executeQuery();
			if (rs.next()) {
				list = new ArrayList<cookingDTO>();
				do {
					cookingDTO dto = new cookingDTO();
					dto.setR_code(rs.getString("r_code"));
					dto.setR_name(rs.getString("r_name"));
					dto.setR_intro(rs.getString("r_intro"));
					dto.setR_photo(rs.getString("r_photo"));
					dto.setM_code(rs.getString("m_code"));
					dto.setM_nick(rs.getString("m_nick"));
					dto.setM_img(rs.getString("m_img"));
					dto.setH_star(rs.getInt("h_star"));
					list.add(dto);
				} while (rs.next());
			}
		} catch (Exception e) {
			System.out.println("recipe 목록 실패" + e);
		} finally {
			DBClose.close(con, pstmt, rs);
		}
		return list;
	}
	
	public cookingDTO mread(String m_code) {
		cookingDTO dto = null;
		try {
			con = dbopen.getConnection();
			sql = new StringBuilder();
			sql.append(" SELECT m_code, m_nick, m_img ");
			sql.append(" FROM ts_member ");
			sql.append(" WHERE m_code = ? ");
			pstmt=con.prepareStatement(sql.toString());
			pstmt.setString(1, m_code);
			rs = pstmt.executeQuery();
			if(rs.next()) {
				dto = new cookingDTO();
				dto.setM_code(rs.getString("m_code"));
				dto.setM_nick(rs.getString("m_nick"));
				dto.setM_img(rs.getString("m_img"));
			}//if end
			
		}catch(Exception e){
			System.out.println("회원정보보기 실패 : " + e);
		}finally {
			DBClose.close(con, pstmt, rs);
		}//end
		return dto;	
	}//mread() end
	
	public cookingDTO read(String r_code) {
		cookingDTO dto = null;
		try {
			con = dbopen.getConnection();

			sql = new StringBuilder();
			sql.append(" SELECT ts_recipe.*, ts_member.m_nick, ts_member.m_img ");
			sql.append(" FROM ts_recipe JOIN ts_member ");
			sql.append(" ON ts_recipe.m_code = ts_member.m_code ");
			sql.append(" WHERE ts_recipe.r_code = ? ");

			pstmt = con.prepareStatement(sql.toString());
			pstmt.setString(1, r_code);
			rs = pstmt.executeQuery();
			if (rs.next()) {
				dto = new cookingDTO();
				dto.setR_code(rs.getString("r_code"));
				dto.setR_name(rs.getString("r_name"));
				dto.setR_intro (rs.getString("r_intro"));
				dto.setR_video(rs.getString("r_video"));
				dto.setR_photo(rs.getString("r_photo"));
				dto.setR_tip(rs.getString("r_tip"));
				dto.setJ_no(rs.getString("j_no"));
				dto.setS_no(rs.getString("s_no"));
				dto.setG_no(rs.getString("g_no"));
				dto.setCi_per(rs.getString("ci_per"));
				dto.setCi_time(rs.getString("ci_time"));
				dto.setCi_diff(rs.getString("ci_diff"));
				dto.setM_code(rs.getString("m_code"));
				dto.setM_nick(rs.getString("m_nick"));
				dto.setM_img(rs.getString("m_img"));
			}
		} catch (Exception e) {
			System.out.println("recipe 보기 실패" + e);
		}finally {
			DBClose.close(con, pstmt, rs);
		}//end
		return dto;	
	}//read() end
	
	public ArrayList<cookingDTO> read2(String r_code) {
		ArrayList<cookingDTO> read2 = null;
		try {
			con = dbopen.getConnection();

			sql = new StringBuilder();
			sql.append(" SELECT ts_recipe.r_code, ts_mate.r_kind, ts_mate.r_tname, ts_mate.r_mea ");
			sql.append(" FROM ts_recipe JOIN ts_mate ");
			sql.append(" ON ts_recipe.r_code = ts_mate.r_code ");
			sql.append(" WHERE ts_recipe.r_code = ? ");	

			pstmt = con.prepareStatement(sql.toString());
			pstmt.setString(1, r_code);
			rs = pstmt.executeQuery();
			if (rs.next()) {
				read2 = new ArrayList<cookingDTO>();
				do {
					cookingDTO dto = new cookingDTO();
					dto.setR_code(rs.getString("r_code"));
					dto.setR_kind(rs.getString("r_kind"));
					dto.setR_tname(rs.getString("r_tname"));
					dto.setR_mea(rs.getString("r_mea"));
					read2.add(dto);
				} while (rs.next());
			}
		} catch (Exception e) {
			System.out.println("recipe 재료 보기 실패" + e);
		} finally {
			DBClose.close(con, pstmt, rs);
		}
		return read2;
	}
	
	public ArrayList<cookingDTO> read3(String r_code) {
		ArrayList<cookingDTO> read3 = null;
		try {
			con = dbopen.getConnection();

			sql = new StringBuilder();
			sql.append(" SELECT ts_recipe.r_code, ts_sequence.r_explan, ts_sequence.r_img, ts_sequence.r_seq ");
			sql.append(" FROM ts_recipe JOIN ts_sequence ");
			sql.append(" ON ts_recipe.r_code = ts_sequence.r_code ");
			sql.append(" WHERE ts_recipe.r_code = ? ");	

			pstmt = con.prepareStatement(sql.toString());
			pstmt.setString(1, r_code);
			rs = pstmt.executeQuery();
			if (rs.next()) {
				read3 = new ArrayList<cookingDTO>();
				do {
					cookingDTO dto = new cookingDTO();
					dto.setR_code(rs.getString("r_code"));
					dto.setR_explan(rs.getString("r_explan"));
					dto.setR_img(rs.getString("r_img"));
					dto.setR_seq(rs.getString("r_seq"));
					read3.add(dto);
				} while (rs.next());
			}
		} catch (Exception e) {
			System.out.println("recipe 순서 보기 실패" + e);
		} finally {
			DBClose.close(con, pstmt, rs);
		}
		return read3;
	}
	
	public ArrayList<cookingDTO> read4(String r_code) {
		ArrayList<cookingDTO> read4 = null;
		try {
			con = dbopen.getConnection();

			sql = new StringBuilder();
			sql.append(" SELECT ts_recipe.r_code, ts_postscript.h_code, ts_postscript.h_star, ts_postscript.h_postcon, ts_postscript.h_photo, ts_postscript.h_date, ts_member.m_code, ts_member.m_nick, ts_member.m_img ");
			sql.append(" FROM ts_recipe JOIN ts_postscript ");
			sql.append(" ON ts_recipe.r_code = ts_postscript.r_code JOIN ts_member ");
			sql.append(" ON ts_recipe.m_code = ts_member.m_code ");
			sql.append(" WHERE ts_recipe.r_code = ? ");	

			pstmt = con.prepareStatement(sql.toString());
			pstmt.setString(1, r_code);
			rs = pstmt.executeQuery();
			if (rs.next()) {
				read4 = new ArrayList<cookingDTO>();
				do {
					cookingDTO dto = new cookingDTO();
					dto.setR_code(rs.getString("r_code"));
					dto.setH_code(rs.getString("h_code"));
					dto.setM_code(rs.getString("m_code"));
					dto.setM_nick(rs.getString("m_nick"));
					dto.setM_img(rs.getString("m_img"));
					dto.setH_star(rs.getInt("h_star"));
					dto.setH_postcon(rs.getString("h_postcon"));
					dto.setH_photo(rs.getString("h_photo"));
					dto.setH_date(rs.getString("h_date"));

					read4.add(dto);
				} while (rs.next());
			}
		} catch (Exception e) {
			System.out.println("recipe 후기 보기 실패" + e);
		} finally {
			DBClose.close(con, pstmt, rs);
		}
		return read4;
	}

	public int post(cookingDTO dto, String r_code, String m_code) {
		int cnt=0;
		try {
			 con=dbopen.getConnection();
	        
			 String m_img = null;
			 String m_nick = null;
	         sql=new StringBuilder();
	         sql.append(" INSERT INTO ts_postscript(h_code, r_code, m_code, m_img, m_nick, h_postcon, h_star, h_photo, h_date) ");
	         sql.append(" VALUES ((select CONCAT('h_code',(SELECT nvl(max(TO_NUMBER(SUBSTR(h_code,7))),0)+1 from ts_postscript)) from ts_postscript where rownum=1), ?, ?, ?, ?, ?, sysdate)");
	         
	         pstmt=con.prepareStatement(sql.toString());
	         pstmt.setString(1, r_code);
	         pstmt.setString(2, m_code);
		 	 pstmt.setString(3, m_img);
			 pstmt.setString(4, m_nick);
	         pstmt.setString(5, dto.getH_postcon());
	         pstmt.setInt(6, dto.getH_star());
	         pstmt.setString(7, dto.getH_photo());

	        cnt=pstmt.executeUpdate();

	    }catch (Exception e) {
	        System.out.println("후기등록 실패:" + e);
	    }finally {
	        DBClose.close(con, pstmt);
	    }//end
	    return cnt;

	}//post() end

	public int insert(cookingDTO dto, String m_code) {
		int cnt=0;
		try {
			con=dbopen.getConnection();
			
			sql=new StringBuilder();
	        sql.append(" INSERT INTO ts_recipe(r_code, r_name, r_intro, r_video, r_photo, r_tip, j_no, s_no, g_no, ci_per, ci_time, ci_diff, m_code) ");
	        sql.append(" VALUES ((select CONCAT('r_code',(SELECT nvl(max(TO_NUMBER(SUBSTR(r_code,7))),0)+1 from ts_recipe)) from ts_recipe where rownum=1), ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?)");
	        
	        pstmt=con.prepareStatement(sql.toString());
	        pstmt.setString(1, dto.getR_code());
	        pstmt.setString(2, dto.getR_name());
	        pstmt.setString(3, dto.getR_intro());
	        pstmt.setString(4, dto.getR_video());
	        pstmt.setString(5, dto.getR_photo());
	        pstmt.setString(6, dto.getR_tip());
	        pstmt.setString(7, dto.getJ_no());
	        pstmt.setString(8, dto.getS_no());
	        pstmt.setString(9, dto.getG_no());
	        pstmt.setString(10, dto.getCi_per());
	        pstmt.setString(11, dto.getCi_time());
	        pstmt.setString(12, dto.getCi_diff());
	        pstmt.setString(13, dto.getM_code());

	        cnt=pstmt.executeUpdate();
		}catch(Exception e) {
			System.out.println("레시피 등록 실패" + e);
		}finally {
			DBClose.close(con, pstmt);
		}
		return cnt;
	}

	public void incrementCnt(String r_code) {
		// TODO Auto-generated method stub
		
	}
}
