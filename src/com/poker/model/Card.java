package com.poker.model;

public class Card implements Comparable<Card> {
	private String Suit;
	private String Figure;

	public String getSuit() {
		return Suit;
	}

	public void setSuit(String suit) {
		Suit = suit;
	}

	public String getFigure() {
		return Figure;
	}

	public void setFigure(String figure) {
		Figure = figure;
	}

	public Card() {

	}

	public Card(String Suit, String Figure) {
		this.setSuit(Suit);
		this.setFigure(Figure);
	}

	@Override
	/*
	 * 通过对比字符串下标数值来判断大小 
	 * 重写compareTo方法 
	 * 分别建立花色字符串数组suitList 和 点数字符串数组
	 * figureList,顺序由小到大建立。 
	 * 对比当前对象和参数对象的点数和花色得出return
	 */
	
	public int compareTo(Card c) {
		String[] suitList = new String[] { "方块", "梅花", "红桃", "黑桃" };
		String[] figureList = new String[] { "2", "3", "4", "5", "6", "7", "8", "9", "10", "J", "Q", "K", "A" };
		// TODO Auto-generated method stub
		Card cm = new Card();
		// 获得当前对象和参数对象的点数下标
		int comp1 = cm.indexOfArray(this.getFigure(), figureList);
		int comp2 = cm.indexOfArray(c.getFigure(), figureList);
		// 获得当前对象和参数对象的花色下标
		int comp3 = cm.indexOfArray(this.getSuit(), suitList);
		int comp4 = cm.indexOfArray(c.getSuit(), suitList);
		// 判断当点数下标一样时对比花色下标
		if (comp1 == comp2) {
			if (comp3 > comp4) {
				return 1;
			} else {
				return -1;
			}
		} else if (comp1 > comp2) {
			return 1;
		} else if (comp1 < comp2) {
			return -1;
		}
		return 0;
	}

	// 建立获取下标的方法
	public int indexOfArray(String str, String[] strArray) {
		for (int i = 0; i < strArray.length; i++) {
			if (strArray[i].equals(str)) {
				return i;
			}
		}
		return -1;
	}
}