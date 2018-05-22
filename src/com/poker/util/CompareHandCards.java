package com.poker.util;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import com.poker.model.Card;
import com.poker.model.Player;

public class CompareHandCards {
	/**
	 * 调用Card重写的compareTo方法重新排列手牌集合 
	 * 首先将各自手牌进行排序; 
	 * 得出最后一张卡牌为当前手牌最大卡牌player.getHandCards().get(size-1); 
	 * 将各个玩家各自最大的卡牌重新组合一个新的集合compareList;
	 * 再次将新得出的集合排序获得最后一个元素为所有手牌中最大的卡牌; 
	 * 查看哪个玩家手上含有最大手牌;
	 */
	public Player compareHandCards(List<Player> players) {
		// 先自行对比输出各自最大手牌
		List<Card> compareList = new ArrayList<Card>();
		for (Player player : players) {
			// 调用Card重写的compare方法重新排列手牌集合
			Collections.sort(player.getHandCards());
			int size = player.getHandCards().size();
			System.out.println(player.getName() + "最大的手牌为" + player.getHandCards().get(size - 1).getSuit()
					+ player.getHandCards().get(size - 1).getFigure());
			// 将当前玩家的最大手牌放入新的集合中
			compareList.add(player.getHandCards().get(size - 1));
		}
		// 进行第二次排序，得出所有手牌中最大的卡牌
		Collections.sort(compareList);
		int maxIndex = compareList.size() - 1;
		Card maxCard = compareList.get(maxIndex);
		//System.out.println(maxCard.getSuit() + maxCard.getFigure());
		// 查看哪个玩家手牌上包含这个最大卡牌，输出最终获胜玩家
		if (players.get(0).getHandCards().contains(maxCard)) {
			return players.get(0);
		} else {
			return players.get(1);
		}
	}
}