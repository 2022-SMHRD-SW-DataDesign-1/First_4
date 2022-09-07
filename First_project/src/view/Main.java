 package view;

import java.util.Scanner;

import controller.LoginManagement;
//import model.MemberDAO;
//import model.MemberDTO;

public class Main {

	public static void main(String[] args) {
		// 모든 기능에서 사용할 수 있도록 전역변수 dao, dto 생성
//		MemberDAO dao = new MemberDAO();  // 나중에 올리기
//		MemberDTO dto = null;
		
		// controller에 접근할 수 있는 객체 생성
		LoginManagement lm = new LoginManagement();
		
		Scanner sc = new Scanner(System.in);
		
		// 어떤 형태로 화면 구성을 할 것이냐?
		System.out.println("====bigdata====");
		
		while(true) {
			// 구분선
			System.out.println("=========================");
			// 메뉴 출력
			System.out.println("메뉴를 입력하세요");
			System.out.print("[1]로그인  [2]회원가입  [3]정보수정  [4]조회  [5]회원탈퇴  [6]종료 >> ");
			int menu = sc.nextInt();
			
			if(menu == 1) {
				//로그인 기능(DB 연결)
				
				System.out.print("아이디 : ");
				String id = sc.next();
				System.out.print("비밀번호 : ");
				String pw = sc.next();
				
				// Controller를 통해 DAO의 login()연결
				lm.LoginCon(id, pw); // 게임실행 메소드
//				
//				// 로그인 기능은 현재 가지고 있는 member 테이블에 
//				// id, pw와 동일하게 들어가 있는 내용이 있는지 없는지 확인 후
//				// 결과값 반환
//				if(result) { // cnt로도 바꿔보기
//					System.out.println("로그인 성공");
//				}else {
//					System.out.println("로그인 실패");
//				}
				
			}else if(menu == 2) {
				// 회원가입 기능 (DB 연결)
				
				// 메소드 호출하기위해 객체 생성
				
				System.out.print("아이디 입력 : ");
				String id = sc.next();
				System.out.print("비밀번호 입력 : ");
				String pw = sc.next();
				System.out.print("닉네임 입력 : ");  
				String nickname = sc.next();
				
				// 1 - MemberDAO dao = new MemberDAO();
				//	   MemberDTO dto = new MemberDTO(id, pw, name, age);
				// int cnt = dao.insert(dto);
				// if(cnt > 0){ ~
				
				
				lm.InsertCon(id, pw, nickname);
				
//				dto = new MemberDTO(id, pw, name, age); // 생성자 메소드
//				
//				int cnt = dao.insert(dto); // sql만들기
//				
//				if(cnt > 0) {
//					System.out.println("회원가입 성공");
//				}else {
//					System.out.println("회원가입 실패");
//				}
				
			}else if(menu == 3) {
				// 정보수정 기능
				System.out.print("아이디 입력 : ");
				String id = sc.next();
				System.out.print("비밀번호 수정 : ");
				String pw = sc.next();
				
				lm.UpdateCon(id, pw);
				
//				dto = new MemberDTO(id, pw); // 2
//				int cnt = dao.update(dto); // 1
//				
//				if(cnt > 0) {
//					System.out.println("회원정보 수정완료");
//				}else { 
//					System.out.println("회원정보 수정실패");
//				}
				
			}else if(menu == 4){
				// 정보조회 기능
				
					// 특정 회원에 대하여 조회 진행하기
					// 조회할 아이디 입력받기
					System.out.print("조회할 아이디 : ");
					String id = sc.next();
					
					lm.SelectCon(id);  // 임포트 두개 지우기
//					dao.select(id);					
				
			}else if(menu == 5) {
				// 회원탈퇴 기능
				System.out.print("탈퇴할 아이디 : ");
				String id = sc.next();
				
				lm.DeleteCon(id);
				
			}else if(menu == 6) {
				// 종료기능
				System.out.println("프로그램 종료");
				break;
			}else {
				System.out.println("잘못입력하셨습니다.");
			}
		}
		System.out.println("프로그램이 종료되었습니다."); // 2. model(memberDTO)
		
		sc.close();
	}

}
