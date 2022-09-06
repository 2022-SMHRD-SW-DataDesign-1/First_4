 package view;

import java.util.Scanner;

import controller.LoginManagement;
import model.MemberDAO;
import model.MemberDTO;

public class Main {

	public static void main(String[] args) {
		// ��� ��ɿ��� ����� �� �ֵ��� �������� dao, dto ����
		MemberDAO dao = new MemberDAO();  // ���߿� �ø���
		MemberDTO dto = null;
		
		// controller�� ������ �� �ִ� ��ü ����
		LoginManagement lm = new LoginManagement();
		
		Scanner sc = new Scanner(System.in);
		
		// � ���·� ȭ�� ������ �� ���̳�?
		System.out.println("====bigdata====");
		
		while(true) {
			// ���м�
			System.out.println("=========================");
			// �޴� ���
			System.out.println("�޴��� �Է��ϼ���");
			System.out.print("[1]�α���  [2]ȸ������  [3]��������  [4]��ȸ  [5]ȸ��Ż��  [6]���� >> ");
			int menu = sc.nextInt();
			
			if(menu == 1) {
				//�α��� ���(DB ����)
				
				System.out.print("���̵� : ");
				String id = sc.next();
				System.out.print("��й�ȣ : ");
				String pw = sc.next();
				
				// Controller�� ���� DAO�� login()����
				//lm.LoginCon(id, pw);
				
				boolean result = dao.login(id, pw);
				
				if(result) 
				{
					System.out.println("�α��� ����");
					// ���� ����
				}
				else
					System.out.println("�α��� ����");
//				
//				// �α��� ����� ���� ������ �ִ� member ���̺� 
//				// id, pw�� �����ϰ� �� �ִ� ������ �ִ��� ������ Ȯ�� ��
//				// ����� ��ȯ
//				if(result) { // cnt�ε� �ٲ㺸��
//					System.out.println("�α��� ����");
//				}else {
//					System.out.println("�α��� ����");
//				}
				
			}else if(menu == 2) {
				// ȸ������ ��� (DB ����)
				
				// �޼ҵ� ȣ���ϱ����� ��ü ����
				
				System.out.print("���̵� �Է� : ");
				String id = sc.next();
				System.out.print("��й�ȣ �Է� : ");
				String pw = sc.next();
				System.out.print("�̸� �Է� : ");  
				String name = sc.next();
				System.out.print("���� �Է� : ");
				int age = sc.nextInt();
				
				// 1 - MemberDAO dao = new MemberDAO();
				//	   MemberDTO dto = new MemberDTO(id, pw, name, age);
				// int cnt = dao.insert(dto);
				// if(cnt > 0){ ~
				
				
				lm.InsertCon(id, pw, name, age);
				
//				dto = new MemberDTO(id, pw, name, age); // ������ �޼ҵ�
//				
//				int cnt = dao.insert(dto); // sql�����
//				
//				if(cnt > 0) {
//					System.out.println("ȸ������ ����");
//				}else {
//					System.out.println("ȸ������ ����");
//				}
				
			}else if(menu == 3) {
				// �������� ���
				System.out.print("���̵� �Է� : ");
				String id = sc.next();
				System.out.print("��й�ȣ ���� : ");
				String pw = sc.next();
				
				lm.UpdateCon(id, pw);
				
//				dto = new MemberDTO(id, pw); // 2
//				int cnt = dao.update(dto); // 1
//				
//				if(cnt > 0) {
//					System.out.println("ȸ������ �����Ϸ�");
//				}else { 
//					System.out.println("ȸ������ ��������");
//				}
				
			}else if(menu == 4){
				// ������ȸ ���
				
					// Ư�� ȸ���� ���Ͽ� ��ȸ �����ϱ�
					// ��ȸ�� ���̵� �Է¹ޱ�
					System.out.print("��ȸ�� ���̵� : ");
					String id = sc.next();
					
					lm.SelectCon(id);  // ����Ʈ �ΰ� �����
//					dao.select(id);					
				
			}else if(menu == 5) {
				// ȸ��Ż�� ���
				System.out.print("Ż���� ���̵� : ");
				String id = sc.next();
				
				lm.DeleteCon(id);
				
			}else if(menu == 6) {
				// ������
				System.out.println("���α׷� ����");
				break;
			}else {
				System.out.println("�߸��Է��ϼ̽��ϴ�.");
			}
		}
		System.out.println("���α׷��� ����Ǿ����ϴ�."); // 2. model(memberDTO)
		
		sc.close();
	}

}
