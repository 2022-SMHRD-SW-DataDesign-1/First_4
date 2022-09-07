package model;

		// DTO : Data Transfer Object
		// Member Table data�� �ְ� �޴� �뵵! - ��ü, Ŭ����
public class MemberDTO {
	// main X 
	
	// �ʵ� �ʿ�(�Ӽ�)
	private String id;
	private String pw;
	private String nickname;
	
	// ������, getter �޼ҵ�
	
	// ���ǹ��� �޼ҵ�� �ƴϰ� �̷��� ����� �����ϱ� ���ؼ� �ʿ��� ��, �׻� ���°� �����ϱ� ������ ���� �ᵵ ������ ����Ű��õ
	// ������ ����� : ��Ŭ�� -> source -> generate constructor using fields
	// ȸ�������� ���� dto
	public MemberDTO(String id, String pw, String nickname) {
		this.id = id;
		this.pw = pw;
		this.nickname = nickname;
	}
	   
	// ȸ������ ������ ���� dto
	public MemberDTO(String id, String pw) {
		this.id = id;
		this.pw = pw;
	}

	// ��Ŭ��  -> source -> generate getters and setters
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
