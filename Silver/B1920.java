package Silver;

import java.util.Scanner;
import java.util.Arrays;

public class B1920 {
    public static void main(String args[]) throws Exception {
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();
        int a[] = new int[n];

        for(int i = 0; i<n; i++ ) {
            a[i] = sc.nextInt();
        }

        Arrays.sort(a);

        int m = sc.nextInt();
        int b[] = new int[m];

        for (int i = 0; i<m; i++) {
            b[i] = sc.nextInt();
            System.out.println(binarySearch(a, b[i]));
        }
        sc.close();
    }
    
    private static int binarySearch(int[] a, int n) {
        int first = 0;
        int last = a.length -1;
        int mid = 0;

        while (first <= last) {
            mid = (first + last) /2;

            if (n == a[mid]) return 1;
            else {
                if (n < a[mid]) last = mid -1;
                else first = mid + 1;
            } 
        }
        return 0;
    }
}
