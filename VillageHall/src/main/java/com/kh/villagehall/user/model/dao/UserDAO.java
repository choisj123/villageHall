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

	/** 회원가입 DAO
	 * @param conn
	 * @param user
	 * @return result
	 * @throws Exception
	 */
	public int signUp(Connection conn, User user) throws Exception {
	
		
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
	
	

	public int myInfoCheckPw(Connection conn, int userNo, String inputPw) throws Exception{
		
		int result = 0;
		
		try {
			String sql = prop.getProperty("myInfoCheckPw");
			pstmt = conn.prepareStatement(sql);
			
			pstmt.setInt(1, userNo);
			pstmt.setString(2, inputPw);
			
			result = pstmt.executeUpdate();
			
		}finally {
			close(pstmt);
		}
		
		return result;
	}



	/** 인증번호, 발급일 수정DAO
	 * @param conn
	 * @param inputEmail
	 * @param cNumber
	 * @return
	 * @throws Exception
	 */
	public int updateCertification(Connection conn, String inputEmail, String cNumber)throws Exception {
		
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

	/** 인증번호 생성 DAO
	 * @param conn
	 * @param inputEmail
	 * @param cNumber
	 * @return
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
	
	

}
