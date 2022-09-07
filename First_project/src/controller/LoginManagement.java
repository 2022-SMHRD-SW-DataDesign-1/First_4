package controller;

import asciiArtSet.asciiArtSet_public;
import games.BridgeGame;
import games.DalgonaGame;
import games.MugunghwaGame;
import games.tug_of_war;
import javazoom.jl.player.MP3Player;
// Controller의 역할
import model.MemberDAO;
import model.MemberDTO;
import musicPlayer.musicCon;

// 사용자가 요청한 값이 있으면 controller에서 DAO로 연결
// 조금더 view를 간단하게 , 사용자가 view에서 딱 입력과 결과값만을 보이게 하는 것 
// Main이 조금 더 가벼워짐
public class LoginManagement {
	
	// DAO에 접근할 수 있는 객체 생성
	MemberDAO dao = new MemberDAO();
	
	// DTO에 접근할 수 있는 객체 생성
	MemberDTO dto; // = new MemberDTO(id, pw); // 여러게 메소드있음 -> 선택해야함 , 구체적인 매개변수의 개수는 기능에 따라 다르게 주겟다
	
	musicCon mc = new musicCon();
	
	// Main 메소드에서 로그인을 실행 시
	// 아이디와 비밀번호를 받아와 DAO 로 연결해주는 메소드 생성
	
	// 서로서로 DAO와 사용자를 연결해주기 위해서는 메소드로 접근해야함
	public void LoginCon(String id, String pw) {
		// DAO에 있는 login()
		boolean result = dao.login(id, pw);
		
		// 로그인 기능은 현재 가지고 있는 member 테이블에 
		// id, pw와 동일하게 들어가 있는 내용이 있는지 없는지 확인 후
		// 결과값 반환
		if(result) { // cnt로도 바꿔보기
			System.out.println("로그인 성공");
			
			dto = new MemberDTO(id, pw);
			dto.setScore(0);
			dto.setLife(1);
			
			MP3Player player = new MP3Player();
			if(player.isPlaying()) 
			{
				player.stop();
				mc.playMusic(player, 1);
			}
			//title_ani();
			
			RunGames(dto, player);
			
			InsertRankCon(dto);
				
		}else {
			System.out.println("로그인 실패");
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
	
	public void RunGames(MemberDTO dto, MP3Player mp3) 
	{
		tug_of_war tow = new tug_of_war();
		DalgonaGame dal = new DalgonaGame();
		BridgeGame brg = new BridgeGame();
		MugunghwaGame mgh = new MugunghwaGame();
		
		/* 줄거리 설명 추가
		 * 줄거리 설명할때 bgm추가 해야함
		 */
		
		dto.setScore(mgh.run_MugunghwaGame(dto.getScore(), dto, mp3));
		
		if(dto.getLife() != 0)
			dto.setScore(dal.run_DalgonaGame(dto.getScore(), dto, mp3));
		
		if(dto.getLife() != 0)
			dto.setScore(tow.run_tug_of_war(dto.getScore(), dto, mp3));
		
		if(dto.getLife() != 0)
			dto.setScore(brg.run_bridgeGame(dto.getScore(), dto, mp3));
	}
	
	public void InsertRankCon(MemberDTO dto) 
	{
		int cnt = dao.insertRank(dto);
		if(cnt > 0)
			System.out.println("rank등록 성공");
		else
			System.out.println("rank등록 실패");
	}
	
	public void InsertCon(String id, String pw, String nickname) {
		dto = new MemberDTO(id, pw, nickname); // 생성자 메소드
		
		int cnt = dao.insert(dto); // sql만들기
		
		if(cnt > 0) {
			System.out.println("회원가입 성공");
		}else {
			System.out.println("회원가입 실패");
		}
	}

	public void UpdateCon(String id, String pw) {
		
		dto = new MemberDTO(id, pw); // 2
		int cnt = dao.update(dto); // 1
		
		if(cnt > 0) {
			System.out.println("회원정보 수정완료");
		}else {
			System.out.println("회원정보 수정실패");
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
			System.out.println("탈퇴 성공");
		}else {
			System.out.println("탈퇴 실패");
		}
	}
	
}
