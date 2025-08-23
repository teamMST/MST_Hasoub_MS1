package singleton;

public class Main {

	public static void main(String[] args) {

		Superman s = Superman.getInstance();
		s.fly();
		s.liftBuilding();
		s.reverseTime();
		s.stopBullets();
		s2 = Superman.getInstance();
		System.out.println("s1 = " + s);
		System.out.println("s2 = " + s2);
		if (s == s2) {
			System.out.println("SAME!");
		}

	}

}
