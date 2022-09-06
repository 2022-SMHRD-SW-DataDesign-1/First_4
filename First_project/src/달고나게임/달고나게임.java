package �ް�����;

import java.util.Scanner;

public class �ް����� {

	public static void main(String[] args) {
		// �ް� ��ü�� ���
		Scanner sc = new Scanner(System.in);
		System.out.println("�ۡ��ۡ�� �ް� �ۡ��ۡ�� ");
		System.out.println("�ް������� �����ϰٽ��ϴ� \r\n" + "�ް� ������ ���ѽð����� ���Ͻô� ����� ����Ű�Է��� �����ȷ�Ʈ�� �̵��� �Ͽ��� �����ϴ� �����Դϴ�\r\n"
				+ "����Ű �Է��� �����ȷ�Ʈ�� �������� ���ϸ� ���и� �ϴ� ������ ����ֽñ� �ٶ��ϴ� ");

		int dalgo[][] = new int[10][10];
		int dalgo1[][] = { { 0, 0, 0, 0, 0, 0, 0, 0, 0, 0 },
						  { 0, 1, 1, 1, 1, 1, 1, 1, 1, 0 },
						  { 0, 1, 0, 0, 0, 0, 0, 0, 1, 0 },
						  { 0, 1, 0, 0, 0, 0, 0, 0, 1, 0 },
						  { 0, 1, 0, 0, 0, 0, 0, 0, 1, 0 },
						  { 0, 1, 0, 0, 0, 0, 0, 0, 1, 0 },
						  { 0, 1, 0, 0, 0, 0, 0, 0, 1, 0 },
						  { 0, 1, 0, 0, 0, 0, 0, 0, 1, 0 },
						  { 0, 1, 1, 1, 1, 1, 1, 1, 1, 0 },
						  { 0, 0, 0, 0, 0, 0, 0, 0, 0, 0 } };
		int dalgo2[][] = { { 0, 0, 0, 0, 0, 0, 0, 0, 0, 0 },
				           { 0, 0, 0, 0, 0, 0, 0, 0, 0, 0 },
				           { 0, 1, 1, 1, 0, 0, 1, 1, 1, 0 },
				           { 0, 1, 0, 1, 1, 1, 1, 0, 1, 0 },
				           { 0, 1, 0, 0, 0, 0, 0, 0, 1, 0 },
				           { 0, 1, 0, 0, 0, 0, 0, 0, 1, 0 },
				           { 0, 1, 1, 0, 0, 0, 0, 1, 1, 0 },
				           { 0, 0, 1, 1, 0, 0, 1, 1, 0, 0 },
				           { 0, 0, 0, 1, 1, 1, 1, 0, 0, 0 },
				           { 0, 0, 0, 0, 1, 1, 0, 0, 0, 0 } };

		int dalgo3[][] = { { 0, 0, 0, 0, 1, 1, 0, 0, 0, 0 },
						   { 0, 0, 0, 1, 1, 1, 1, 0, 0, 0 },
						   { 0, 0, 1, 1, 0, 0, 1, 1, 0, 0 },
						   { 0, 1, 1, 0, 0, 0, 0, 1, 1, 0 },
						   { 1, 1, 0, 0, 0, 0, 0, 0, 1, 1 },
						   { 1, 1, 0, 0, 0, 0, 0, 0, 1, 1 },
						   { 0, 1, 1, 0, 0, 0, 0, 1, 1, 0 },
						   { 0, 0, 1, 1, 0, 0, 1, 1, 0, 0 },
						   { 0, 0, 0, 1, 1, 1, 1, 0, 0, 0 },
						   { 0, 0, 0, 0, 1, 1, 0, 0, 0, 0 } };


		String[] shape = { "��", "��", "��" };
		
		int user_x = 1;
		int user_y = 1;
		int time = 0;
		int life = 2;


		System.out.println("�ް��̱� ���Ͻô� ����� �����ϼ���");
		System.out.print("[1] �� (���̵� : ��)  [2] �� (���̵� : ��)  [3] �� (���̵� : ��) >>");
		int shapes = sc.nextInt();
		for (int i = 0; i < dalgo.length; i++) {
			for (int j = 0; j < dalgo[i].length; j++) {
				if (shapes == 1) {
					dalgo[i][j] = dalgo1[i][j];
					time = 15000;

				} else if (shapes == 2) {
					dalgo[i][j] = dalgo2[i][j];
					user_x = 1;
					user_y = 2;
					time = 20000;

				} else if (shapes == 3) {
					dalgo[i][j] = dalgo3[i][j];
					user_x = 4;
					user_y = 0;
					time = 25000;

				}
			}
		}
		
		dalgo[user_y][user_x] = 2;

		// user�� �����̴� ��ǥ

		long before = System.currentTimeMillis();
		while (true) {
			for (int i = 0; i < dalgo.length; i++) {
				for (int j = 0; j < dalgo[i].length; j++) {
					if (dalgo[i][j] == 0)
						System.out.print(shape[0] + " ");
					else if (dalgo[i][j] == 1)
						System.out.print(shape[1] + " ");
					else if (dalgo[i][j] == 2)
						System.out.print(shape[2] + " ");
				}
				System.out.println();
			}
			System.out.print("��ǥ�� �����̽ÿ�>>");
			String move = sc.next();
			long now = System.currentTimeMillis();
			if (now - before > time)
				break;
			switch (move) {
			case "a": // left
				user_x--;
				if (dalgo[user_y][user_x] == 0) {
					life--;}
				dalgo[user_y][user_x] = 2;
				break;
			case "d": // right
				user_x++;
				if (dalgo[user_y][user_x] == 0) {
					life--;}
				dalgo[user_y][user_x] = 2;
				if (user_x >= 10)
					user_x = 10 - 1;
				break;
			case "w": // up
				user_y--;
				if (dalgo[user_y][user_x] == 0) {
					life--;}
				dalgo[user_y][user_x] = 2;
				if (user_y < 0)
					user_y = 0;
				break;
			case "s": // down
				user_y++;
				if (dalgo[user_y][user_x] == 0) {
					life--;}
				dalgo[user_y][user_x] = 2;
				if (user_y >= 10) {
					user_y = 10 - 1;}
				
				break;
			}
			if(life == 0) {
				System.out.println("life�� ��� �Һ�Ǿ� �������̽��ϴ�!");
				break;
			}
		}

		boolean dalgoSuccess = true;
		for (int i = 0; i < dalgo.length; i++) {
			for (int j = 0; j < dalgo[i].length; j++) {
				if (dalgo[i][j] == 1) {
					dalgoSuccess = false;
					break;
				}
			}
		}
		if (dalgoSuccess) {
			System.out.println("�ް�����!");
			System.out.println("�����ϼ̽��ϴ� ���� �������� �Ѿ�ڽ��ϴ�");
		} else {
			System.out.println("���� ����");
		}

	}

}

