package com.kh.villagehall.board.model.vo;

public class Board {
	private int boardNo;
	private String boardTitle;
	private String boardContent;
	private String boardCreateDate;
	private String boardUpdateDate;
	private int readCount;
	private int latitude;
	private int longtitude;
	private String boardDeleteFG;
	private int categoryNo;
	private int userNo;
	
	private int likeCount;	
	private String userNickname;
	
	public Board() {}
	
	public Board(int boardNo, String boardTitle, String boardContent, String boardCreateDate, String boardUpdateDate,
			int readCount, int latitude, int longtitude, String boardDeleteFG, int categoryNo, int userNo) 
		{
		super();
		this.boardNo = boardNo;
		this.boardTitle = boardTitle;
		this.boardContent = boardContent;
		this.boardCreateDate = boardCreateDate;
		this.boardUpdateDate = boardUpdateDate;
		this.readCount = readCount;
		this.latitude = latitude;
		this.longtitude = longtitude;
		this.boardDeleteFG = boardDeleteFG;
		this.categoryNo = categoryNo;
		this.userNo = userNo;
	}

	public String getUserNickname() {
		return userNickname;
	}


	public void setUserNickname(String userNickname) {
		this.userNickname = userNickname;
	}


	public int getLikeCount() {
		return likeCount;
	}


	public void setLikeCount(int likeCount) {
		this.likeCount = likeCount;
	}




	public int getBoardNo() {
		return boardNo;
	}


	public void setBoardNo(int boardNo) {
		this.boardNo = boardNo;
	}


	public String getBoardTitle() {
		return boardTitle;
	}


	public void setBoardTitle(String boardTitle) {
		this.boardTitle = boardTitle;
	}


	public String getBoardContent() {
		return boardContent;
	}


	public void setBoardContent(String boardContent) {
		this.boardContent = boardContent;
	}


	public String getBoardCreateDate() {
		return boardCreateDate;
	}


	public void setBoardCreateDate(String boardCreateDate) {
		this.boardCreateDate = boardCreateDate;
	}


	public String getBoardUpdateDate() {
		return boardUpdateDate;
	}


	public void setBoardUpdateDate(String boardUpdateDate) {
		this.boardUpdateDate = boardUpdateDate;
	}


	public int getReadCount() {
		return readCount;
	}


	public void setReadCount(int readCount) {
		this.readCount = readCount;
	}


	public int getLatitude() {
		return latitude;
	}


	public void setLatitude(int latitude) {
		this.latitude = latitude;
	}


	public int getLongtitude() {
		return longtitude;
	}


	public void setLongtitude(int longtitude) {
		this.longtitude = longtitude;
	}


	public String getBoardDeleteFG() {
		return boardDeleteFG;
	}


	public void setBoardDeleteFG(String boardDeleteFG) {
		this.boardDeleteFG = boardDeleteFG;
	}


	public int getCategoryNo() {
		return categoryNo;
	}


	public void setCategoryNo(int categoryNo) {
		this.categoryNo = categoryNo;
	}


	public int getUserNo() {
		return userNo;
	}


	public void setUserNo(int userNo) {
		this.userNo = userNo;
	}


	@Override
	public String toString() {
		return "Board [boardNo=" + boardNo + ", boardTitle=" + boardTitle + ", boardContent=" + boardContent
				+ ", boardCreateDate=" + boardCreateDate + ", boardUpdateDate=" + boardUpdateDate + ", readCount="
				+ readCount + ", latitude=" + latitude + ", longtitude=" + longtitude + ", boardDeleteFG="
				+ boardDeleteFG + ", categoryNo=" + categoryNo + ", userNo=" + userNo + "]";
	}
	
	
	
}