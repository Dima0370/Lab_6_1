package com.lab_6_1.menu;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import com.lab_6_1.command.*;
import com.lab_6_1.gameroom.*;

public class Menu {

	public void startMenu() {

		Scanner sc = new Scanner(System.in);

		ArrayList<GameRoom> gameRoom = new ArrayList<>();

		Commands commandsExecutor = new Commands();

		while (true) {

			displayMenu();

			switch (sc.next()) {

			case "1": {
				commandsExecutor.executeCommands(new AllocateMoneyBudget(gameRoom));
				break;
			}

			case "2": {
				commandsExecutor.executeCommands(new BuyToyStuff(gameRoom));
				break;
			}

			case "3": {
				printToyList(gameRoom);
				break;
			}

			case "4": {
				commandsExecutor.executeCommands(new SortByPrice(gameRoom));
				break;
			}

			case "5": {
				commandsExecutor.executeCommands(new FindByPrice(gameRoom));
				break;
			}

			case "6": {
				System.exit(0);
				break;
			}

			default: {
				System.out.println("\nНевiрна команда, спробуйте ще раз\n");
			}

			}

		}

	}

	public void displayMenu() {

		System.out.println("Введiть одну з команд: \n");
		System.out.println("1 - Видiлити бюджет для iгрової кiмнати");
		System.out.println("2 - Купити iграшки для iгрової кiмнати");
		System.out.println("3 - Вивести список куплених iграшок");
		System.out.println("4 - Вiдсортувати iграшки за цiною");
		System.out.println("5 - Знайти iграшки в дiапазонi цiн");
		System.out.println("6 - Вийти з програми\n");
	}

	public void printToyList(List<GameRoom> gameRoom) {

		if (gameRoom.size() > 0) {

			System.out.println();

			for (GameRoom toys : gameRoom) {

				if (toys.equals(toys)) {
					System.out.println(toys);
				}

			}

			System.out.println();

		}

		else {
			System.out.println("\nСписок iграшок для iгрової кiмнати пустий\n");
		}

	}
}
