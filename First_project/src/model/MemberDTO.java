package model;

		// DTO : Data Transfer Object
		// Member Table data를 주고 받는 용도! - 객체, 클래스
public class MemberDTO {
	// main X 
	
	// 필드 필요(속성)
	private String id;
	private String pw;
	private String nickname;
	
	// 생성자, getter 메소드
	
	// 유의미한 메소드는 아니고 이러한 기능을 수행하기 위해서 필요한 것, 항상 형태가 동일하기 때문에 직접 써도 되지만 단축키추천
	// 생성자 만들기 : 우클릭 -> source -> generate constructor using fields
	// 회원가입을 위한 dto
	public MemberDTO(String id, String pw, String nickname) {
		this.id = id;
		this.pw = pw;
		this.nickname = nickname;
	}
	   
	// 회원정보 수정을 위한 dto
	public MemberDTO(String id, String pw) {
		this.id = id;
		this.pw = pw;
	}

	// 우클릭  -> source -> generate getters and setters
	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getPw() {
		return pw;
	}

	public void setPw(String pw) {
		this.pw = pw;
	}

	public String getNickname() {
		return nickname;
	}

	public void setNickname(String nickname) {
		this.nickname = nickname;
	}

	
}
