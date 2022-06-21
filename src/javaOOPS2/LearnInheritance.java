package javaOOPS2;

public class LearnInheritance {

	public static void main(String[] args) {
		Samsung s10 = new Samsung();
		s10.os = "Android";
		s10.playGames();

		Apple a1 = new Apple();
		a1.playGames();
	}

}

class MobilePhone {
	int price;
	int dimensions;
	String os;
	boolean hasHeadphoneJack;

	void playGames() {
		System.out.println("Mobile phone playing game");
	}

	// Method overloading - compile time
	void playGames(int x) {
		for (int i = 0; i < x; i++) {
			System.out.println("Playing games");
		}
	}
}

class Samsung extends MobilePhone {
	// Method overriding - run time
	void playGames() {
		System.out.println("Samsung playing game");
	}
}

class Apple extends MobilePhone {

}
