package com.poker.model;

import java.util.List;

public class Player {
	private int Id;
	private String Name;
	private List<Card> handCards;

	public int getId() {
		return Id;
	}

	public void setId(int id) {
		Id = id;
	}

	public String getName() {
		return Name;
	}

	public void setName(String name) {
		Name = name;
	}

	public List<Card> getHandCards() {
		return handCards;
	}

	public void setHandCards(List<Card> handCards) {
		this.handCards = handCards;
	}

	public Player() {

	}

	public Player(int id, String name, List<Card> handCards) {
		this.setId(id);
		this.setName(name);
		this.setHandCards(handCards);
	}
}