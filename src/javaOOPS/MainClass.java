package javaOOPS;

class Animal {

	// properties
	int legs;
	String name;

	// void -> no return value
	void walk() {
		System.out.println(name + " is walking");
	}

	// These both methods are different, even if the return type is changed
	// int walk() {}

	// we can't have same method name reused
	// void walk() {}

	// But we can do a small modification with the parameter list
	void walk(int steps) {
		// Why did this work?

		// SAME SIGNATURE can't be repeated, so we made small modification

		// METHOD OVERLOADING - is the concept used here

		System.out.println("Animal walked " + steps + " steps.");
	}

	// Default Constructor - used to create an object of class
	public Animal() {
		// This method is called when you say "new Animal();"
		System.out.println("Calling the animal constructor");
	}

	// Constructor overloading
	public Animal(String newName) {
		System.out.println(newName + " was passed while creating");
	}

}

class Person {
	String name;
	int age;

	static int count;

	Person() {
		count++;
		System.out.println("person is being created");
	}

	Person(String newName, int newAge) {
		this(); // calling current class default constructor

		/**
		 * this() should always be the first statement when you are using
		 */

		this.name = newName;
		this.age = newAge;

		talking(this);
	}

	void talking(Person obj) {
		System.out.println(name + " is talking on the phone");
		age += 10;
		System.out.println(name + " new age - " + age);
	}
}

public class MainClass {

	public static void main(String[] args) {
		Animal a1 = new Animal();
		Animal a2 = new Animal("Bob");

		a1.name = "Simba";
		a1.legs = 4;

		a2.name = "Bob";
		a2.legs = 2;

		System.out.println(a1.name + " " + a1.legs);

		a2.walk();

		// method overloading
		a1.walk(10);

		// Before creating any object
		System.out.println("Before: " + Person.count);

		Person p1 = new Person();
		Person p2 = new Person("Raj", 23);

		System.out.println("After: " + Person.count);
		System.out.println("p1 count " + p1.count);

		System.out.println("Person 2 :: " + p2.name + " - " + p2.age);
	}

}
