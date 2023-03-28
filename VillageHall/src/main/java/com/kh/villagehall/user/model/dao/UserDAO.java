package com.kh.villagehall.user.model.dao;

import java.io.FileInputStream;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.Properties;

import com.kh.villagehall.user.model.vo.User;

import static com.kh.villagehall.common.JDBCTemplate.*;

public class UserDAO {
	
	private Statement stmt;
	private PreparedStatement pstmt;
	private ResultSet rs;
	private Properties prop;
	
	
	public UserDAO() {
		try {
			prop = new Properties();
			
			String filePath = UserDAO.class.getResource("/com/kh/community/sql/member-sql.xml").getPath();  
			
			prop.loadFromXML(new FileInputStream(filePath));
			
			
		}catch (Exception e) {
			e.printStackTrace();
		}
		
	}


	public User login(Connection conn, User user) {
		// TODO Auto-generated method stub
		return null;
	}


	public int signUp(Connection conn, User user) {
		// TODO Auto-generated method stub
		return 0;
	}


	public int updateUser(Connection conn, User user) {
		// TODO Auto-generated method stub
		return 0;
	}


	public int changePw(Connection conn, String currentPw, String newPw, int userNo) {
		// TODO Auto-generated method stub
		return 0;
	}


	public int deleteFG(Connection conn, int userNo, String userPw) {
		// TODO Auto-generated method stub
		return 0;
	}


	public int emailDupCheck(Connection conn, String userEmail) {
		// TODO Auto-generated method stub
		return 0;
	}


	public int nicknameDupCheck(Connection conn, String userNickname) {
		// TODO Auto-generated method stub
		return 0;
	}


	public int updateProfileImage(Connection conn, int userNo, String profileImage) {
		// TODO Auto-generated method stub
		return 0;
	}


	public int updateCertification(Connection conn, String inputEmail, String cNumber) {
		// TODO Auto-generated method stub
		return 0;
	}


	public int insertCertification(Connection conn, String inputEmail, String cNumber) {
		// TODO Auto-generated method stub
		return 0;
	}


	public int checkNumber(Connection conn, String inputEmail, String cNumber) {
		// TODO Auto-generated method stub
		return 0;
	}
	
	
}
