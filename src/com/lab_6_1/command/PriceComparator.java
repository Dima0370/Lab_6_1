package com.lab_6_1.command;

import java.util.Comparator;

import com.lab_6_1.gameroom.GameRoom;

public class PriceComparator implements Comparator<GameRoom> {

	@Override
	public int compare(GameRoom o1, GameRoom o2) {
		return o1.getPrice() - o2.getPrice();
	}

}
