package com.lab_6_1.command;

import java.util.List;
import java.util.Scanner;

import com.lab_6_1.gameroom.*;

public class BuyToyStuff extends GameRoom implements Command {

	private List<GameRoom> gameRoom;
	private Ball ball = new Ball();
	private Cube cube = new Cube();
	private Doll doll = new Doll();
	private SmallCar smallCar = new SmallCar();
	private MediumCar mediumCar = new MediumCar();
	private LargeCar largeCar = new LargeCar();

	public BuyToyStuff(List<GameRoom> gameRoom) {

		this.gameRoom = gameRoom;
	}

	public void buyToyStuff() {

		Scanner sc = new Scanner(System.in);

		buyMenu();

		switch (sc.next()) {

		case "1": {

			buyToys(ball);

			break;

		}

		case "2": {

			buyToys(cube);

			break;

		}

		case "3": {

			buyToys(doll);

			break;

		}

		case "4": {

			buyToys(smallCar);

			break;

		}

		case "5": {

			buyToys(mediumCar);

			break;

		}

		case "6": {

			buyToys(largeCar);

			break;

		}

		case "7": {

			System.out.println();
			break;

		}

		default: {
			System.out.println("\nВведено неправильну команду, спробуйте ще раз");
			break;
		}
		}

	}

	private void buyToys(GameRoom toy) {

		Scanner sc = new Scanner(System.in);

		if (GameRoom.getMoneyBudget() > 0) {

			int count1;
			int count2 = 0;

			System.out.print("\nВведiть кiлькiсть, яку треба придбати: ");

			count1 = sc.nextInt();

			if (GameRoom.getMoneyBudget() - (toy.getPrice() * count1) > 0) {

				int remainder;

				for (int i = 0; i < count1; i++) {
					count2++;
					gameRoom.add(toy);
					remainder = GameRoom.getMoneyBudget() - (toy.getPrice());
					setMoneyBudget(remainder);

					if (remainder < toy.getPrice()) {
						ball.setCount(count2);
						System.out.println("\nЧерез нестачу грошей було куплено всього " + toy.getCount() + " штук");
						break;
					}

					toy.setCount(count1);

				}

				System.out.println("\nКуплено " + toy.getCount() + " штук");

				System.out.println("\nЗалишилося грошей: " + GameRoom.getMoneyBudget() + " грн\n");
			}

			else {
				System.out.println("\nНе вистачає грошей\n");
			}
		}

		else {
			System.out.println("\nНемає грошей\n");
		}
	}

	public void buyMenu() {

		System.out.println("\nВведiть, який тип iграшки потрiбно придбати: ");
		System.out.println("\n1. М'яч");
		System.out.println("2. Кубик");
		System.out.println("3. Лялька");
		System.out.println("4. Маленька машина");
		System.out.println("5. Середня машина");
		System.out.println("6. Велика машина");
		System.out.println("7. Повернутися до головного меню\n");
	}

	@Override
	public void execute() {

		buyToyStuff();
	}

}
