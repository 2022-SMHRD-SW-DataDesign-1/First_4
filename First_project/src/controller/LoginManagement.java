package controller;

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
	
	// ���μ��� DAO�� ����ڸ� �������ֱ� ���ؼ��� �޼ҵ�� �����ؾ���
	public void LoginCon(String id, String pw) {
		// DAO�� �ִ� login()
		boolean result = dao.login(id, pw);
		
		// �α��� ����� ���� ������ �ִ� member ���̺� 
		// id, pw�� �����ϰ� �� �ִ� ������ �ִ��� ������ Ȯ�� ��
		// ����� ��ȯ
		if(result) { // cnt�ε� �ٲ㺸��
			System.out.println("�α��� ����");
			
			tug_of_war tow = new tug_of_war();
			DalgonaGame dal = new DalgonaGame();
			BridgeGame brg = new BridgeGame();
			MugunghwaGame mgh = new MugunghwaGame();
			
			//mgh.run_MugunghwaGame();
			//dal.run_DalgonaGame();
			//tow.run_tug_of_war();
			brg.run_bridgeGame();
		}else {
			System.out.println("�α��� ����");
		}
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
	
	public void DeleteCon(String id) {
		int cnt = dao.delete(id);
		if(cnt > 0) {
			System.out.println("Ż�� ����");
		}else {
			System.out.println("Ż�� ����");
		}
	}
	
}
