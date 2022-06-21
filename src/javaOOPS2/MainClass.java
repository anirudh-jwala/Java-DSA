package javaOOPS2;

public class MainClass {

	public static void main(String[] args) {
		Alien obj = new Alien();
		obj.legs = 3;

		Alien.isMemberOfEarth = true; // changed at class level

		add(3, 4); // can call only static methods

		Alien.speak(); // no need to create an object to call speak()

		// but non-static method can't be called directly with class name we need an
		// object creation to call sayHello() as it is non-static
		obj.sayHello();
	}

	static int add(int a, int b) {
		return a + b;
	}

}

class Alien {
	// We want some property by default
	static boolean isMemberOfEarth = false;

	int legs;

	static void speak() {
		System.out.println("Alien speaks");
	}

	void sayHello() {
		System.out.println("Alien say hello");
	}
}
