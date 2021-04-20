package Silver;
import java.util.*;
import java.io.*;

public class B10816 {
    public static void main(String args[]) throws Exception {
        BufferedReader rd = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(rd.readLine());
        String[] prea = rd.readLine().split(" ");

        int m = Integer.parseInt(rd.readLine());
        String[] preb = rd.readLine().split(" ");

        int a[] = new int[n];
        int b[] = new int[m];

        for(int i=0; i<prea.length;i++) a[i] = Integer.parseInt(prea[i]);
        for(int i=0; i<preb.length;i++) b[i] = Integer.parseInt(preb[i]);
        
        Arrays.sort(a);
        StringBuilder sb = new StringBuilder();
		for (int num : b) {
			sb.append(find(a, num, n)).append(" ");
		}
		System.out.println(sb.toString());
    }

    private static int find(int[] a, int n, int length) {
        int left = findLeft(a, 0, length, n);
        int right = findRight(a, 0, length, n);
        return right - left;
    }

    private static int findLeft(int[] a, int left, int right, int num) {
        int index = (left + right) / 2;
        if(left >= right) {
            return index;
        }
        if(a[index] >= num) {
            return findLeft(a, left, index, num);
        }else {
            return findLeft(a, index+1, right, num);
        }
    }

    private static int findRight(int[] a, int left, int right, int num) {
        int index = (left + right) / 2;
        if(left >= right) {
            return index;
        }
        if(a[index] <= num) {
            return findRight(a, index+1, right, num);
        }else {
            return findRight(a, left, index, num);
        }
    }
}
