package javaOOPS2;

public class LearnEncapsulation {

	public static void main(String[] args) {
		Secret obj = new Secret();
	}

}

/**
 * class Secret { int data; }
 * 
 * in main() obj.data = 4; we are able to change the data that is secret
 */

class Secret {
	private int data;

	public void setData(int data) {
		// Now directly we can't set any data it should be more than 100 only
		if (data > 100)
			this.data = data;
	}

	public int getData() {
		return data;
	}
}