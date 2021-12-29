package kr.co.recipe.rclass;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

import kr.co.recipe.member.MemberDTO;
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
			sql.append("select lt.*, mem.m_nick from ts_lecture lt join ts_member mem on lt.g_code = mem.m_code");

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
					dto.setG_code(rs.getString("g_code"));
					dto.setM_nick(rs.getString("m_nick"));
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
	public int create(ClassDTO dto,String g_code) {		
		int cnt=0;
		try {			
			con = dbOpen.getConnection();
			sql=new StringBuilder();
			
			if (dto.getP_code()=="p_code1") {
				sql.append(" insert into ts_lecture (l_code, l_title, l_contents, l_photo, l_tumbsup, g_code, l_views) ");
				sql.append(" values ('l_code1',?,?,?,?,?,0)");
			}else {
				sql.append(" insert into ts_lecture (l_code, l_title, l_contents, l_photo, l_tumbsup, g_code, l_views) ");
				sql.append(" values ((select CONCAT('l_code',(SELECT nvl(max(TO_NUMBER(SUBSTR(l_code,7))),0)+1 from ts_lecture)) from ts_lecture where rownum=1) ");
				sql.append(" ,?,?,?,?,?,0)");	
			}
			

			pstmt=con.prepareStatement(sql.toString());
			pstmt.setString(1,dto.getL_title());			
			pstmt.setString(2, dto.getL_contents());
			pstmt.setString(3, dto.getL_photo());
			pstmt.setString(4, dto.getL_tumbsup());
			pstmt.setString(5, g_code);
			
						
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
			sql.append("select lt.*, mem.m_nick from ts_lecture lt join ts_member mem on lt.g_code = mem.m_code where l_code = ? ");
			pstmt = con.prepareStatement(sql.toString());
			pstmt.setString(1, l_code);
			rs = pstmt.executeQuery();
			if (rs.next()) {
				dto = new ClassDTO();
				
				dto.setL_code(rs.getString("l_code"));
				dto.setG_code(rs.getString("g_code"));
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
	 public ArrayList<ClassDTO> sublist(String m_code) {
			ArrayList<ClassDTO> sublist = null;
			try {
				con = dbOpen.getConnection();

				sql = new StringBuilder();
				sql.append("select pay.*, mem.m_nick, mem.m_mail, mem.m_img from ts_pay pay join ts_member mem on pay.g_code = mem.m_code where pay.m_code = ? and TO_CHAR(SYSDATE, 'MM/dd') >= TO_CHAR(p_date, 'MM/dd')");

				pstmt = con.prepareStatement(sql.toString());
				pstmt.setString(1, m_code);
				rs = pstmt.executeQuery();
				if (rs.next()) {
					sublist = new ArrayList<ClassDTO>();
					do {
						ClassDTO dto = new ClassDTO();
						dto.setP_code(rs.getString("p_code"));
						dto.setG_code(rs.getString("g_code"));
						dto.setM_code(rs.getString("m_code"));
						dto.setP_price(rs.getInt("p_price"));
						dto.setP_count(rs.getInt("p_count"));
						dto.setP_div(rs.getString("p_div"));
						dto.setP_date(rs.getString("p_date"));
						dto.setM_nick(rs.getString("m_nick"));
						dto.setM_mail(rs.getString("m_mail"));
						dto.setM_img(rs.getString("m_img"));			
						sublist.add(dto);
					} while (rs.next());
				}
			} catch (Exception e) {
				System.out.println("class 목록 실패" + e);
			} finally {
				DBClose.close(con, pstmt, rs);
			}
			return sublist;
		}
	 public ArrayList<ClassDTO> sublist2(String m_code) {
			ArrayList<ClassDTO> sublist = null;
			try {
				con = dbOpen.getConnection();

				sql = new StringBuilder();
				sql.append("select pay.*, mem.m_nick, mem.m_mail, mem.m_img from ts_pay pay join ts_member mem on pay.g_code = mem.m_code where pay.m_code = ? and TO_CHAR(SYSDATE, 'MM/dd') <= TO_CHAR(p_date, 'MM/dd')");

				pstmt = con.prepareStatement(sql.toString());
				pstmt.setString(1, m_code);
				rs = pstmt.executeQuery();
				if (rs.next()) {
					sublist = new ArrayList<ClassDTO>();
					do {
						ClassDTO dto = new ClassDTO();
						dto.setP_code(rs.getString("p_code"));
						dto.setG_code(rs.getString("g_code"));
						dto.setM_code(rs.getString("m_code"));
						dto.setP_price(rs.getInt("p_price"));
						dto.setP_count(rs.getInt("p_count"));
						dto.setP_div(rs.getString("p_div"));
						dto.setP_date(rs.getString("p_date"));
						dto.setM_nick(rs.getString("m_nick"));
						dto.setM_mail(rs.getString("m_mail"));
						dto.setM_img(rs.getString("m_img"));			
						sublist.add(dto);
					} while (rs.next());
				}
			} catch (Exception e) {
				System.out.println("pay 목록 실패" + e);
			} finally {
				DBClose.close(con, pstmt, rs);
			}
			return sublist;
		}
	 public ClassDTO subdiv(String m_code,String g_code) {		
		 ClassDTO dto = null;
			try {
				con = dbOpen.getConnection();
				sql = new StringBuilder();
				
				sql.append("select p_code, p_div from ts_pay where g_code = ? and m_code = ? and TO_CHAR(SYSDATE, 'MM/dd') >= TO_CHAR(p_date, 'MM/dd')");
				pstmt = con.prepareStatement(sql.toString());
				pstmt.setString(1, g_code);
				pstmt.setString(2, m_code);
				rs = pstmt.executeQuery();
				if (rs.next()) {
					dto = new ClassDTO();					
					dto.setP_code(rs.getString("p_code"));					
					dto.setP_div(rs.getString("p_div"));					
				}
			} catch (Exception e) {
				System.out.println("상세보기 실패" + e);
			} finally {
				DBClose.close(con, pstmt, rs);
			}
			return dto;
		}
		public ClassDTO nickread(String m_nick) {
			ClassDTO dto = null;
			try {
				con = dbOpen.getConnection();
				sql = new StringBuilder();
				sql.append(" SELECT m_code");
				sql.append(" FROM ts_member ");
				sql.append(" WHERE m_nick = ? ");
				pstmt=con.prepareStatement(sql.toString());
				pstmt.setString(1, m_nick);
				rs = pstmt.executeQuery();
				if(rs.next()) {
					dto = new ClassDTO();
					dto.setM_code(rs.getString("m_code"));
					System.out.println(rs.getString("m_code"));
				}//if end
				
			}catch(Exception e){
				System.out.println("회원정보보기 실패 : " + e);
			}finally {
				DBClose.close(con, pstmt, rs);
			}//end
			return dto;	
		}//read() end
	 public int insertsubscribe(ClassDTO dto,String g_code, String m_code) {		
			int cnt=0;
			try {			
				con = dbOpen.getConnection();
				sql=new StringBuilder();
				System.out.println(dto.getP_code());	
				if (dto.getP_code()=="p_code1") {
					sql.append("insert into ts_pay(p_code, g_code, m_code, p_price, p_count,p_date, p_div) values ('p_code1' , ?, ?, ?, ?, ADD_MONTHS(sysdate,?),'Y')");
				}else {
					sql.append("insert into ts_pay(p_code, g_code, m_code, p_price, p_count,p_date, p_div) values ((select CONCAT('p_code',(SELECT nvl(max(SUBSTR(p_code,7)),0)+1 from ts_pay))from ts_pay where rownum=1) , ?, ?, ?, ?, ADD_MONTHS(sysdate,?),'Y')");	
				}
				

				pstmt=con.prepareStatement(sql.toString());				
				pstmt.setString(1, g_code);
				pstmt.setString(2, m_code);
				pstmt.setInt(3, dto.getP_price());
				pstmt.setInt(4, dto.getP_count());
				pstmt.setInt(5, dto.getP_count());
				
							
				cnt=pstmt.executeUpdate();			
			}catch (Exception e) {		
				System.out.println("pay insert등록 실패"+e);
			} finally {
				DBClose.close(con, pstmt);
			}
			return cnt;
		}
	 public int updatesubscribe(ClassDTO dto,String g_code, String m_code) {		
			int cnt=0;
			try {			
				con = dbOpen.getConnection();
				sql=new StringBuilder();
								
				
				
				sql.append("UPDATE ts_pay SET p_date = ADD_MONTHS(p_date,?), p_count = p_count+?, p_price= p_price+5000*? where g_code=? and m_code=?");
				

				pstmt=con.prepareStatement(sql.toString());				
				pstmt.setInt(1, dto.getP_count());
				pstmt.setInt(2, dto.getP_count());
				pstmt.setInt(3, dto.getP_count());
				pstmt.setString(4, g_code);
				pstmt.setString(5, m_code);
				
				
				
							
				cnt=pstmt.executeUpdate();			
			}catch (Exception e) {		
				System.out.println("pay update등록 실패"+e);
			} finally {
				DBClose.close(con, pstmt);
			}
			return cnt;
		}
	 public String pcode() {		
			String pcode=null;
			try {			
				con = dbOpen.getConnection();
				sql=new StringBuilder();
				
				sql.append("select CONCAT('p_code',(SELECT nvl(max(SUBSTR(p_code,7)),0)+1 from ts_pay)) as p_code from ts_pay where rownum=1");
				

				pstmt=con.prepareStatement(sql.toString());				
				rs = pstmt.executeQuery();
				
				
					if (!rs.next()) {						
						pcode="p_code1";						
					}					
				
			}catch (Exception e) {		
				System.out.println("pcode등록 실패"+e);
			} finally {
				DBClose.close(con, pstmt);
			}
			return pcode;
		}
	 public String lcode() {		
			String lcode=null;
			try {			
				con = dbOpen.getConnection();
				sql=new StringBuilder();
				
				sql.append("select CONCAT('l_code',(SELECT nvl(max(SUBSTR(l_code,7)),0)+1 from ts_lecture)) as l_code from ts_pay where rownum=1");
				

				pstmt=con.prepareStatement(sql.toString());				
				rs = pstmt.executeQuery();			
				
					if (!rs.next()) {						
						lcode="l_code1";						
					}					
				
			}catch (Exception e) {		
				System.out.println("pcode등록 실패"+e);
			} finally {
				DBClose.close(con, pstmt);
			}
			return lcode;
		}
	 
}

