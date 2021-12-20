package kr.co.recipe.rclass;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;




import net.utility.DBClose;
import net.utility.DBOpen;

public class ClassDAO {
	private DBOpen dbOpen = null;
	private Connection con = null;
	private PreparedStatement pstmt = null;
	private ResultSet rs = null;
	private StringBuilder sql = null;

	public ClassDAO() {
		dbOpen = new DBOpen();
	}

	//l_code,l_title,l_photo,m_code,l_contents,l_tumbsup,l_views
	public ArrayList<ClassDTO> list() {
		ArrayList<ClassDTO> list = null;
		try {
			con = dbOpen.getConnection();

			sql = new StringBuilder();
			sql.append("select l_code,l_title,l_photo,m_code,l_contents,l_views FROM ts_lecture");

			pstmt = con.prepareStatement(sql.toString());
			rs = pstmt.executeQuery();
			if (rs.next()) {
				list = new ArrayList<ClassDTO>();
				do {
					ClassDTO dto = new ClassDTO();
					dto.setL_code(rs.getString("l_code"));
					dto.setL_title(rs.getString("l_title"));
					dto.setL_photo(rs.getString("l_photo"));
					dto.setL_contents(rs.getString("l_contents"));
					dto.setL_views(rs.getInt("l_views"));
					dto.setM_code(rs.getString("m_code"));
					list.add(dto);
				} while (rs.next());
			}
		} catch (Exception e) {
			System.out.println("class 목록 실패" + e);
		} finally {
			DBClose.close(con, pstmt, rs);
		}
		return list;
	}
	public int create(ClassDTO dto,String m_code) {		
		int cnt=0;
		try {			
			con = dbOpen.getConnection();
			sql=new StringBuilder();
			sql.append(" insert into ts_lecture (l_code, l_title, l_contents, l_photo, l_tumbsup, m_code, l_views) ");
			sql.append(" values ((select CONCAT('l_code',(SELECT nvl(max(TO_NUMBER(SUBSTR(l_code,7))),0)+1 from ts_lecture)) from ts_lecture where rownum=1) ");
			sql.append(" ,?,?,?,?,?,0)");

			pstmt=con.prepareStatement(sql.toString());
			pstmt.setString(1,dto.getL_title());			
			pstmt.setString(2, dto.getL_contents());
			pstmt.setString(3, dto.getL_photo());
			pstmt.setString(4, dto.getL_tumbsup());
			pstmt.setString(5, m_code);
			
						
			cnt=pstmt.executeUpdate();			
		}catch (Exception e) {		
			System.out.println("class등록 실패"+e);
		} finally {
			DBClose.close(con, pstmt);
		}
		return cnt;
	}
	
	public void incrementCnt(String l_code) {
    	try {    	
    		con = dbOpen.getConnection();
		
			sql = new StringBuilder();
			sql.append("update ts_lecture set l_views=l_views+1 where l_code=? ");
		
		
			pstmt=con.prepareStatement(sql.toString());
			pstmt.setString(1, l_code);
		
			pstmt.executeQuery();		
		
		}catch(Exception e) {
			System.out.println("조회수증가실패"+e);
		}finally {
			DBClose.close(con,pstmt);
		}
    	
	}
	public ClassDTO read(String l_code) {
		ClassDTO dto = null;
		try {
			con = dbOpen.getConnection();
			sql = new StringBuilder();
			sql.append("select lt.*, mem.m_nick from ts_lecture lt join ts_member mem on lt.m_code = mem.m_code where l_code = ? ");
			pstmt = con.prepareStatement(sql.toString());
			pstmt.setString(1, l_code);
			rs = pstmt.executeQuery();
			if (rs.next()) {
				dto = new ClassDTO();
				dto.setL_code(rs.getString("l_code"));
				dto.setL_title(rs.getString("l_title"));
				dto.setL_contents(rs.getString("l_contents"));
				dto.setL_photo(rs.getString("l_photo"));
				dto.setL_tumbsup(rs.getString("l_tumbsup"));
				dto.setL_views(rs.getInt("l_views"));
				dto.setM_nick(rs.getString("m_nick"));
			}
		} catch (Exception e) {
			System.out.println("상세보기 실패" + e);
		} finally {
			DBClose.close(con, pstmt, rs);
		}
		return dto;
	}
	 public int delete(String l_code) {
		 int cnt=0;
			try {
				con = dbOpen.getConnection();
				sql=new StringBuilder();
				sql.append("delete from ts_lecture where l_code =? ");
				pstmt=con.prepareStatement(sql.toString());				
				pstmt.setString(1, l_code);
				cnt=pstmt.executeUpdate();			
			}catch (Exception e) {		
				System.out.println("삭제 실패"+e);
			} finally {
				DBClose.close(con, pstmt);
			}
			return cnt;
		}
	 public int update(ClassDTO dto, String l_code) {
		 int cnt=0;
			try {
				con = dbOpen.getConnection();
				sql=new StringBuilder();
				
				sql.append("update ts_lecture set l_title=?, l_contents=?, l_photo=?, l_tumbsup=? where l_code =? ");
				pstmt=con.prepareStatement(sql.toString());
				pstmt.setString(1, dto.getL_title());
				pstmt.setString(2, dto.getL_contents());
				pstmt.setString(3, dto.getL_photo());
				pstmt.setString(4, dto.getL_tumbsup());
				pstmt.setString(5, l_code);
								
				cnt=pstmt.executeUpdate();			
			}catch (Exception e) {		
				System.out.println("강의수정 실패"+e);
			} finally {
				DBClose.close(con, pstmt);
			}
			return cnt;
		}
}
