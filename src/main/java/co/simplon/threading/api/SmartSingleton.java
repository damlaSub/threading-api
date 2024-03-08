package co.simplon.threading.api;

public class SmartSingleton {

	final static SmartSingleton instance = new SmartSingleton();
	
	private SmartSingleton() {
		System.out.println("Instantiating a naive singleton");
	}
	
	String whoAmI() {
		return "I'm a naive singleton";
	}
}
