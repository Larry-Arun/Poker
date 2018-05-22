package com.poker.util;

import java.util.ArrayList;
import java.util.List;
import com.poker.model.Card;

public class CreateCardList {
	String[] SuitList = new String[] { "黑桃", "红桃", "梅花", "方块" };
	String[] FigureList = new String[] { "2", "3", "4", "5", "6", "7", "8", "9", "10", "J", "Q", "K", "A" };

	/** 
	 * 循环两个字符串数组内的元素，创建新的扑克集合
	 * @return 
	 */
	public List<Card> createCardList() {
		List<Card> cardList = new ArrayList<Card>();
		for (int i = 0; i < SuitList.length; i++) {
			for (int j = 0; j < FigureList.length; j++) {
				cardList.add(new Card(SuitList[i], FigureList[j]));
			}
		}
		return cardList;
	}
}