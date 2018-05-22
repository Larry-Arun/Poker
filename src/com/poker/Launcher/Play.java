package com.poker.Launcher;

import java.util.ArrayList;
import java.util.List;
import com.poker.model.Card;
import com.poker.model.Player;
import com.poker.util.CompareHandCards;
import com.poker.util.CreateCardList;
import com.poker.util.CreatePlayer;
import com.poker.util.Shuffle;

public class Play {
	public static void main(String[] args) {
		System.out.println("**************创建扑克牌**************");
		// 创建扑克牌集合
		CreateCardList createCardList = new CreateCardList();
		List<Card> cardList = new ArrayList<Card>();
		cardList = createCardList.createCardList();
		// 输出扑克牌集合
		System.out.println("扑克牌创建成功：");
		System.out.print("[ ");
		for (Card cl : cardList) {
			System.out.print(cl.getSuit() + cl.getFigure() + " ");
		}
		System.out.print("]\n");
		System.out.println("***************开始洗牌***************");
		// 开始洗牌
		Shuffle shuffleCard = new Shuffle();
		List<Card> newCardList = new ArrayList<Card>();
		newCardList = shuffleCard.shufferCardList(cardList);
		// 测试打印洗牌后的顺序
		System.out.print("[ ");
		for (Card ncl : newCardList) {
			System.out.print(ncl.getSuit() + ncl.getFigure() + " ");
		}
		System.out.print("]\n");
		System.out.println("***************洗牌结束***************");
		System.out.println("***************创建玩家***************");
		// 创建玩家开始
		CreatePlayer createPlayer = new CreatePlayer();
		List<Player> players = new ArrayList<Player>();
		players = createPlayer.createPlayer();
		// 创建玩家完成，输出玩家姓名
		for (Player player : players) {
			System.out.println("***************欢迎玩家" + player.getName() + "***************");
		}
		int cardListIndex = 0;
		for (int i = 0; i < 2; i++) {
			/*
			 * 普通遍历 for(int j=0;j<2;j++) {
			 * System.out.println("***************玩家"+players.get(j).getName()+
			 * "取牌***************");
			 * players.get(j).getHandCards().add(newCardList.get(cardListIndex))
			 * ;
			 * System.out.println("取牌"+newCardList.get(cardListIndex).getSuit()+
			 * newCardList.get(cardListIndex).getFigure()); cardListIndex++; }
			 */
			// foreach遍历
			for (Player player : players) {
				System.out.println("***************玩家" + player.getName() + "取牌***************");
				player.getHandCards().add(newCardList.get(cardListIndex));
				System.out.println(
						"取牌" + newCardList.get(cardListIndex).getSuit() + newCardList.get(cardListIndex).getFigure());
				cardListIndex++;
			}
		}
		System.out.println("***************发牌结束***************");
		System.out.println("***************开始游戏 ***************");
		// 开始对比手牌
		CompareHandCards chc = new CompareHandCards();
		Player winner = chc.compareHandCards(players);
		System.out.println(winner.getName() + "获胜");
		// 输出手牌结果
		System.out.println("玩家各自手牌时为：");
		for (int i = 0; i < 2; i++) {
			System.out.print(players.get(i).getName() + "：[");
			for (int j = 0; j < players.get(i).getHandCards().size(); j++) {
				System.out.print(players.get(i).getHandCards().get(j).getSuit()
						+ players.get(i).getHandCards().get(j).getFigure() + " ");
			}
			System.out.print("]\n");
		}
	}
}