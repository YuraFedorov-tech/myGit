package e055;

import java.math.BigInteger;

public class e055_2 {
	private static BigInteger a;
	private static BigInteger b;
	private static boolean find;

	public e055_2(BigInteger b2) {
		a = BigInteger.ZERO;
		b = b2;
		find = false;
	}

	public void job() {
		for (int i = 0; i < 50; i++) {
			a = turn(b.toString());
			b = b.add(a);
			if (Chek(b.toString())) {
				find = true;
				return;
			}
		}
	}

	private boolean Chek(String s) {
		int j = s.length() - 1;
		for (int i = 0; i < s.length(); i++, j--) {
			if (s.charAt(i) != s.charAt(j))
				return false;
			if (j <= i)
				break;
		}
		return true;
	}

	private BigInteger turn(String s) {
		String z = "";
		for (int i = s.length() - 1; i >= 0; i--)
			z += s.charAt(i);
		return new BigInteger(z);
	}

	public static boolean FindAnswear() {
		return find;
	}
}
