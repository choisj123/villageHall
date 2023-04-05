package com.kh.villagehall.user.model.dao;


import static com.kh.villagehall.common.JDBCTemplate.*;

import java.io.FileInputStream;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.Properties;

import com.kh.villagehall.user.model.vo.User;

public class UserDAO { 
	
	private Statement stmt;
	private PreparedStatement pstmt;
	private ResultSet rs;
	
	private Properties prop;
	
	
	// 기본 생성자
	public UserDAO() {
		try {
			prop = new Properties();
			
			String filePath = UserDAO.class.getResource("/com/kh/villagehall/sql/user-sql.xml").getPath();  
			
			prop.loadFromXML(new FileInputStream(filePath));
		} catch(Exception e) {
			e.printStackTrace();
		}
	}

	/** 로그인 DAO
	 * @param conn
	 * @param user
	 * @return loginUser
	 * @throws Exception
	 */
	public User login(Connection conn, User user) throws Exception{
		
		
		User loginUser = null; // 결과 저장용 변수
		
		try {
			String sql = prop.getProperty("login");
			
			pstmt = conn.prepareStatement(sql);
			
			pstmt.setString(1, user.getUserEmail());
			pstmt.setString(2, user.getUserPw());
			
			rs = pstmt.executeQuery();
			
			if(rs.next()) {
				
				loginUser = new User();
				
				loginUser.setUserNo(rs.getInt("USER_NO"));
				loginUser.setUserEmail(rs.getString("USER_EMAIL"));
				loginUser.setUserNickname(rs.getString("USER_NICKNAME"));
				loginUser.setUserTel(rs.getString("USER_TEL"));
				loginUser.setEnrollDate(rs.getString("ENROLL_DATE"));
				loginUser.setProfileImg(rs.getString("PROFILE_IMG"));
				
				
				
			}
		} finally {
			close(rs);
			close(pstmt);
		}

		return loginUser;
	}

	

	   /**회원가입 DAO
	    * @param conn
	    * @param user
	    * @return result
	    */
	   public int signUp(Connection conn, User user) throws Exception  {
	      
	      int result = 0; // 결과 저장용 변수
	      
	      try {
	         String sql = prop.getProperty("signUp");
	         
	         pstmt = conn.prepareStatement(sql);
	         
	         pstmt.setString(1, user.getUserEmail());
	         pstmt.setString(2, user.getUserPw());
	         pstmt.setString(3, user.getUserNickname());         
	         pstmt.setString(4, user.getUserTel());
	      
	         
	         result = pstmt.executeUpdate();
	         
	      }finally {
	         close(pstmt);
	      }
	      
	      
	      // 결과 반환
	      return result;
	   }

	   /** 인증번호 생성 DAO
	    * @param conn
	    * @param inputEmail
	    * @param cNumber
	    * @return result
	    * @throws Exception
	    */
	   public int insertCertification(Connection conn, String inputEmail, String cNumber) throws Exception {

	      int result = 0;
	      
	      try {
	         
	         String sql = prop.getProperty("insertCertification");
	         
	         pstmt = conn.prepareStatement(sql);
	         
	         pstmt.setString(1, inputEmail);
	         pstmt.setString(2, cNumber);
	         
	         result = pstmt.executeUpdate();
	         
	      }finally {
	         close(pstmt);
	      }
	      
	      return result;
	   }

	   /** 인증번호, 발급일 수정 DAO
	    * @param conn
	    * @param inputEmail
	    * @param cNumber
	    * @return result
	    * @throws Exception
	    */
	   public int updateCertification(Connection conn, String inputEmail, String cNumber) throws Exception {
	      
	      int result = 0;
	      
	      try {
	         
	         String sql = prop.getProperty("updateCertification");
	         
	         pstmt = conn.prepareStatement(sql);
	         
	         pstmt.setString(1, cNumber);
	         pstmt.setString(2, inputEmail);
	         
	         result = pstmt.executeUpdate();
	         
	      }finally {
	         close(pstmt);
	      }
	      
	      return result;
	   }


	   /** 인증번호 확인 DAO
	    * @param conn
	    * @param inputEmail
	    * @param cNumber
	    * @return result
	    * @throws Exception
	    */
	   public int checkNumber(Connection conn, String inputEmail, String cNumber) throws Exception{
	      int result = 0;
	      
	      try {
	         
	         String sql = prop.getProperty("checkNumber");
	         
	         pstmt = conn.prepareStatement(sql);
	         
	         pstmt.setString(1, inputEmail);
	         pstmt.setString(2, cNumber);
	         pstmt.setString(3, inputEmail);
	         
	         rs = pstmt.executeQuery();
	         
	         if(rs.next()) {
	            result = rs.getInt(1);
	         }
	         
	         
	      }finally {
	         close(pstmt);
	      }
	      
	      return result;
	   }

	   
	/** 이메일 중복 검사 DAO
	 * @param conn
	 * @param userEmail
	 * @return result
	 * @throws Exception
	 */
	public int emailDupCheck(Connection conn, String userEmail) throws Exception{
	      
	      int result = 0; // 결과 저장용 변수
	      
	      try {
	         // SQL 얻어오기
	         String sql = prop.getProperty("emailDupCheck");
	         
	         // pstmt 생성
	         pstmt = conn.prepareStatement(sql);
	         
	         // 위치홀더에 알맞은 값 세팅
	         pstmt.setString(1, userEmail);
	         
	         // SQL(SELECT) 수행 후 결과 반환 받기
	         rs = pstmt.executeQuery();
	         
	         // rs.next() 로 조회결과를 확인
	         if( rs.next() ) {
	        	 
	            result = rs.getInt(1); // 1번 컬럼 결과를 result에 대입
	         }
	         
	         
	      }finally {
	    	  
	         close(rs);
	         close(pstmt);
	      }
	      
	      return result;
	   }
	
	

	/** 닉네임 중복 검사
	 * @param conn
	 * @param userNickname
	 * @return result
	 * @throws Exception
	 */
	public int nicknameDupCheck(Connection conn, String userNickname) throws Exception {
		int result = 0;
		
		try {
			String sql = prop.getProperty("userNickname");
			
			pstmt = conn.prepareStatement(sql);
			
			pstmt.setString(1, userNickname);
			
			rs = pstmt.executeQuery();
			
			if(rs.next()) {
				result = rs.getInt(1);
			}
			
			
		}finally {
			close(rs);
			close(pstmt);
		}
		
		return result;
	}


	
	
	
	
	/** 마이페이지 비밀번호 일치 검사 DAO
	 * @param conn
	 * @param userNo
	 * @param inputPw
	 * @return result
	 * @throws Exception
	 */
	public int myInfoCheckPw(Connection conn, int userNo, String inputPw) throws Exception{
		
		int result = 0; 
		
		try {
			String sql = prop.getProperty("myInfoCheckPw");
			pstmt = conn.prepareStatement(sql);
			
			pstmt.setInt(1, userNo);
			pstmt.setString(2, inputPw);
			
			rs = pstmt.executeQuery();
			
			if(rs.next()) {
				result = rs.getInt(1);
			}
			
			System.out.println("DAO result" + result);
			
		}finally {
			close(pstmt);
		}
		
		return result;
	}
	

	/** 프로필 이미지 변경 DAO
	 * @param conn
	 * @param userNo
	 * @param profileImg
	 * @return result
	 * @throws Exception
	 */
	public int updateProfileImage(Connection conn, int userNo, String profileImg) throws Exception{
		int result = 0;
		
		try {
			String sql = prop.getProperty("updateProfileImage");
			
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, profileImg);
			pstmt.setInt(2, userNo);

			result = pstmt.executeUpdate();
			
		}finally {
			close(pstmt);
		}
		
		return result;
	}

	/** 마이페이지 회원정보 수정
	 * @param conn
	 * @param user
	 * @return result
	 * @throws Exception
	 */
	public int updateUser(Connection conn, User user) throws Exception{
		int result = 0;
		
		try {
			String sql = prop.getProperty("updateUser");
			
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, user.getUserNickname());
			pstmt.setString(2, user.getUserTel());
			pstmt.setInt(3, user.getUserNo());
			
			result = pstmt.executeUpdate();
			
		}finally {
			close(pstmt);
		}
		
		return result;
	}

	/** 마이페이지 비밀번호 변경 DAO
	 * @param conn
	 * @param newPw
	 * @param userNo
	 * @return
	 * @throws Exception
	 */
	public int changePw(Connection conn, String newPw, int userNo) throws Exception{
		int result = 0;
		
		try {
			
			String sql = prop.getProperty("changePw");
			
			pstmt = conn.prepareStatement(sql);
			
			pstmt.setString(1, newPw);
			pstmt.setInt(2, userNo);
			
			result = pstmt.executeUpdate();
			
			System.out.println("DAO result :" + result);
			
		}finally {
			close(pstmt);
		}
		
		return result;
	}
	
	
}
