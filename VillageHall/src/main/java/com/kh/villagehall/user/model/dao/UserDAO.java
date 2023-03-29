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
	 * @return
	 */
	public int signUp(Connection conn, User user) throws Exception{
		// TODO Auto-generated method stub
		return 0;
	}

	/** 회원 정보 수정 DAO
	 * @param conn
	 * @param user
	 * @return
	 */
	public int updateUser(Connection conn, User user) throws Exception{
		// TODO Auto-generated method stub
		return 0;
	}

	/** 비밀번호 변경 DAO
	 * @param conn
	 * @param currentPw
	 * @param newPw
	 * @param userNo
	 * @return
	 */
	public int changePw(Connection conn, String currentPw, String newPw, int userNo) throws Exception{
		// TODO Auto-generated method stub
		return 0;
	}

	/** 회원 탈퇴 DAO
	 * @param conn
	 * @param userNo
	 * @param userPw
	 * @return
	 */
	public int deleteFG(Connection conn, int userNo, String userPw) throws Exception{
		// TODO Auto-generated method stub
		return 0;
	}

	/** 이메일 중복 검사 DAO
	 * @param conn
	 * @param userEmail
	 * @return
	 */
	public int emailDupCheck(Connection conn, String userEmail) throws Exception{
		// TODO Auto-generated method stub
		return 0;
	}

	/** 닉네임 중복 검사 DAO 
	 * @param conn
	 * @param userNickname
	 * @return
	 */
	public int nicknameDupCheck(Connection conn, String userNickname) throws Exception{
		// TODO Auto-generated method stub
		return 0;
	}

	public int updateCertification(Connection conn, String inputEmail, String cNumber) throws Exception{
		// TODO Auto-generated method stub
		return 0;
	}
	
	public int updateProfileImage(Connection conn, int userNo, String profileImage) throws Exception{
		// TODO Auto-generated method stub
		return 0;
	}

	public int insertCertification(Connection conn, String inputEmail, String cNumber) throws Exception{
		// TODO Auto-generated method stub
		return 0;
	}

	public int checkNumber(Connection conn, String inputEmail, String cNumber) throws Exception{
		// TODO Auto-generated method stub
		return 0;
	}

	
	
}
