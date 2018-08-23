package net.euler;

public class _31_CoinSum {

	static int[] S = {1, 2, 5, 10, 20, 50, 100, 200};
	
	public static void main(String[] args) {
		
		System.out.println(C(200, S.length - 1));
	}
	
	private static int C(int N, int m) {
		
		if (N == 0) {
			return 1;
		}
		if (N < 0) {
			return 0;
		}
		if ((N >= 1) && (m < 0)) {
			return 0;
		}
		return C(N, m - 1) + C(N - S[m], m);
	}

}
