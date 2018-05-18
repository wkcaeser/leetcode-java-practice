import java.util.ArrayList;
import java.util.HashMap;
import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		int N, n, m, p;
		Scanner scanner = new Scanner(System.in);
		N = scanner.nextInt();
		n = scanner.nextInt();
		m = scanner.nextInt();
		p = scanner.nextInt();
		ArrayList<Integer> list = new ArrayList<>(N+5);
//		HashMap<NumObj, Integer> gcdMap = new HashMap<>(10000);
		list.add(p);
		for (int i=1; i<N; i++){
			list.add((list.get(i-1) + 153)%p);
		}
		int ans = 0;

		if (m>n){
			int tmp = m;
			m = n;
			n = tmp;
		}


		for (int i=1; i<=m; i++) {
			ans += list.get(gcd(i, i)-1);
		}
		for (int i=1; i<=m; i++){
			for (int j=i+1; j<=m; j++){
				ans += list.get(gcd(i, j)-1)*2;
//				System.out.println("(" + i + " : " + j + ")  --- *2");
			}
		}

		for (int i=m+1; i<=n; i++){
			for (int j=1; j<=m; j++){
				ans += list.get(gcd(i, j)-1);
//				System.out.println("(" + i + " : " + j + ")");
			}
		}

//		for (int i=0; i<n; i++){
//			for (int j=0; j<m; j++){
//				if (gcdMap.containsKey(new NumObj(i+1, j+1))){
//					ans += list.get(gcdMap.get(new NumObj(i+1, j+1)) - 1);
//				}else if (gcdMap.containsKey(new NumObj(j+1, i+1))){
//					ans += list.get(gcdMap.get(new NumObj(j+1, i+1)) - 1);
//				}else {
//					int newGcd = gcd(i + 1, j + 1);
//					ans += list.get(newGcd - 1);
//					gcdMap.put(new NumObj(i+1, j+1), newGcd);
//				}
//			}
//		}
		System.out.println(ans);
	}

	private static int gcd(int m, int n){
		return m%n==0?n:gcd(n, m%n);
	}

//	public static class NumObj{
//		int a;
//		int b;
//
//		public NumObj(int a, int b) {
//			this.a = a;
//			this.b = b;
//		}
//
//		@Override
//		public boolean equals(Object o) {
//			if (this == o) return true;
//			if (o == null || getClass() != o.getClass()) return false;
//
//			NumObj numObj = (NumObj) o;
//
//			if (a != numObj.a) return false;
//			return b == numObj.b;
//		}
//
//		@Override
//		public int hashCode() {
//			int result = a;
//			result = 31 * result + b;
//			return result;
//		}
//	}
}
