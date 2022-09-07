package controller;

import asciiArtSet.asciiArtSet_public;
import games.BridgeGame;
import games.DalgonaGame;
import games.MugunghwaGame;
import games.tug_of_war;
// Controller�� ����
import model.MemberDAO;
import model.MemberDTO;

// ����ڰ� ��û�� ���� ������ controller���� DAO�� ����
// ���ݴ� view�� �����ϰ� , ����ڰ� view���� �� �Է°� ��������� ���̰� �ϴ� �� 
// Main�� ���� �� ��������
public class LoginManagement {
	
	// DAO�� ������ �� �ִ� ��ü ����
	MemberDAO dao = new MemberDAO();
	
	// DTO�� ������ �� �ִ� ��ü ����
	MemberDTO dto; // = new MemberDTO(id, pw); // ������ �޼ҵ����� -> �����ؾ��� , ��ü���� �Ű������� ������ ��ɿ� ���� �ٸ��� �ְٴ�
	
	// Main �޼ҵ忡�� �α����� ���� ��
	// ���̵�� ��й�ȣ�� �޾ƿ� DAO �� �������ִ� �޼ҵ� ����
	tug_of_war tow = new tug_of_war();
	DalgonaGame dal = new DalgonaGame();
	BridgeGame brg = new BridgeGame();
	MugunghwaGame mgh = new MugunghwaGame();
	
	// ���μ��� DAO�� ����ڸ� �������ֱ� ���ؼ��� �޼ҵ�� �����ؾ���
	public void LoginCon(String id, String pw) {
		// DAO�� �ִ� login()
		boolean result = dao.login(id, pw);
		
		// �α��� ����� ���� ������ �ִ� member ���̺� 
		// id, pw�� �����ϰ� �� �ִ� ������ �ִ��� ������ Ȯ�� ��
		// ����� ��ȯ
		if(result) { // cnt�ε� �ٲ㺸��
			System.out.println("�α��� ����");
			
			dto = new MemberDTO(id, pw);
			
			title_ani();
			
			RunGames(dto);
			
			InsertRankCon(dto);
				
		}else {
			System.out.println("�α��� ����");
		}
	}
	
	public void title_ani() 
	{
		asciiArtSet_public ascpub = new asciiArtSet_public();
		
		for (int i = 0; i < ascpub.title_animation.length; i++) {
			System.out.println(ascpub.title_animation[i]); 
			ascpub.Sleep(400);
		}
		
		System.out.println(ascpub.gameTitle);
		ascpub.Sleep(2000);
	}
	
	public void RunGames(MemberDTO dto) 
	{
		dto.setScore(mgh.run_MugunghwaGame(dto.getScore(), dto));
		
		if(dto.getLife() != 0)
			dto.setScore(dal.run_DalgonaGame(dto.getScore(), dto));
		
		if(dto.getLife() != 0)
			dto.setScore(tow.run_tug_of_war(dto.getScore(), dto));
		
		if(dto.getLife() != 0)
			dto.setScore(brg.run_bridgeGame(dto.getScore(), dto));
	}
	
	public void InsertRankCon(MemberDTO dto) 
	{
		int cnt = dao.insertRank(dto);
		if(cnt > 0)
			System.out.println("rank��� ����");
		else
			System.out.println("rank��� ����");
	}
	
	public void InsertCon(String id, String pw, String nickname) {
		dto = new MemberDTO(id, pw, nickname); // ������ �޼ҵ�
		
		int cnt = dao.insert(dto); // sql�����
		
		if(cnt > 0) {
			System.out.println("ȸ������ ����");
		}else {
			System.out.println("ȸ������ ����");
		}
	}

	public void UpdateCon(String id, String pw) {
		
		dto = new MemberDTO(id, pw); // 2
		int cnt = dao.update(dto); // 1
		
		if(cnt > 0) {
			System.out.println("ȸ������ �����Ϸ�");
		}else {
			System.out.println("ȸ������ ��������");
		}		
	}

	public void SelectCon(String id) {
		dao.select(id);	
	}
	public void SelectRankCon() {
		dao.rownumRankAll();
	}
	
	public void DeleteCon(String id) {
		int cnt = dao.delete(id);
		if(cnt > 0) {
			System.out.println("Ż�� ����");
		}else {
			System.out.println("Ż�� ����");
		}
	}
	
}
