import java.io.*;
import java.util.*;

public class B11650 {
    public static void main(String args[]) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());

        int loc[][] = new int[n][2];

        StringTokenizer st;

        //입력 값 이중배열에 넣기
        for(int i = 0; i<n; i++) {
            st = new StringTokenizer(br.readLine());
            loc[i][0] = Integer.parseInt(st.nextToken());
            loc[i][1] = Integer.parseInt(st.nextToken());
        }

        Arrays.sort(loc, new Comparator<int[]>() {
            @Override
            public int compare(int[] num1, int[] num2) {
                //x가 같으면 y 비교
                if(num1[0] == num2[0]) return num1[1] - num2[1];
                else return num1[0] - num2[0];
            }
        });

        for(int i=0; i<n; i++) {
            System.out.println(loc[i][0] + " " + loc[i][1]);
        }

    }
}
