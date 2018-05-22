package com.poker.util;

import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.List;
import java.util.Scanner;
import com.poker.model.Card;
import com.poker.model.Player;

public class CreatePlayer {
	Scanner scanner;

	public CreatePlayer() {
		scanner = new Scanner(System.in);
	}

	public List<Player> createPlayer() {
		List<Player> players = new ArrayList<Player>();
		String Name;
		int Id;
		for (int i = 0; i < 2; i++) {
			List<Card> handCards = new ArrayList<Card>();
			System.out.println("请输入第" + (i + 1) + "位玩家的ID和姓名：");
			System.out.println("输入ID：");
			while (true) {
				Id = 0;
				try {
					Id = scanner.nextInt();
					break;
				} catch (InputMismatchException e) {
					// TODO Auto-generated catch block
					// 参考某例子，吞掉输入流的错误数据，否则会无限循环
					scanner.next();
					System.out.println("请输入整型ID：");
					continue;
				}
			}
			System.out.println("输入姓名：");
			Name = scanner.next();
			players.add(new Player(Id, Name, handCards));
			System.out.println("创建的玩家ID为" + players.get(i).getId() + "姓名为" + players.get(i).getName());
		}
		return players;
	}
}