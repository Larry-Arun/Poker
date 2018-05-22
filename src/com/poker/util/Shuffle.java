package com.poker.util;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import com.poker.model.Card;

/** 
 * 输入集合cardList 
 * 通过更改下标打乱顺序后输出新的数列 
 * @author Administrator 
 * 
 */
public class Shuffle {
	public List<Card> shufferCardList(List<Card> cardList) {
		// 获取cardList 扑克牌的数量
		int cardListLen = cardList.size();
		// 创建一个整数包装类集合
		List<Integer> randomList = new ArrayList<Integer>();
		// 存放随机数
		Integer randomNum;
		// 创建循环为集合randomList赋值
		for (int i = 0; i < cardListLen; i++) {
			// 生成一个范围在0-cardList-1 以内的不重复随机数
			do {
				Random random = new Random();
				randomNum = random.nextInt(cardListLen);
			} while (randomList.contains(randomNum));
			randomList.add(randomNum);
		}
		// 创建更改完顺序新集合返回
		List<Card> newCardList = new ArrayList<Card>();
		// 根据生成的随机数集合内的数字改变原扑克牌集合的下标，从而打乱顺序
		for (int k = 0; k < cardListLen; k++) {
			newCardList.add(k, cardList.get(randomList.get(k).intValue()));
		}
		// 返回
		return newCardList;
	}
}