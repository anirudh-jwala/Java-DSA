package package1;

import package2.Class2;

//public class Class1 {
//	public static void main(String[] args) {
//		// as class is public we are able to use it here - we import it on top
//		Class2 obj = new Class2();
//
//		// able to access public methods with object
//		obj.method2();
//
//		// internally it is calling private method3()
//		obj.check();
//		// obj.method3(); NOT POSSIBLE as it is private
//
//		// obj.method4(); NOT POSSIBLE as it is default, it can be called under same
//		// package only
//	}
//
//	void method1() {
//
//	}
//}

public class Class1 extends Class2 {
	public static void main(String[] args) {
		Class1 obj = new Class1();
		// obj.method4(); can't access default method outside package

		obj.method5(); // since we extended Class2 that has method5() protected we are able to access
	}
}
