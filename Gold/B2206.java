package Gold;

import java.util.Scanner;
import java.util.LinkedList;
import java.util.Queue;

public class B2206 {
    static int n, m;
    static char[][] map;

    static int result;

    static int dx[] = { -1, 1, 0, 0 };
    static int dy[] = { 0, 0, 1, -1 };

    public static void main(String[] args) throws Exception {
        Scanner sc = new Scanner(System.in);

        n = sc.nextInt();
        m = sc.nextInt();

        map = new char[n][m];

        for(int i = 0; i<n; i++) {
            String arr = sc.next();
            for (int j = 0; j<m; j++) {
                map[i][j] = arr.charAt(j);
            }
        } //배열 생성

        result = -1;
        bfs();
        System.out.println(result);
        sc.close();
    }

    static void bfs() {
        boolean visit[][][] = new boolean[2][n][m];

        Queue<int[]> q = new LinkedList<>();
        q.offer(new int[] { 0,0,0,1 });
        visit[0][0][0] = true;

        while (!q.isEmpty()) {
            int[] now = q.poll();

            if (now[0] == n-1 && now[1] == m-1) {
                result = now[3];
                break;
            }

            for (int i = 0; i<4; i++) {
                int x = now[0] + dx[i];
                int y = now[1] + dy[i];

                if(0 <= x && x < n && 0 <= y && y < m && !visit[now[2]][x][y]) {
                    if(map[x][y] == '0') {
                        visit[now[2]][x][y] = true;
                        q.offer(new int[] { x, y, now[2], now[3] + 1});
                    }
                    else if (now[2] == 0) {
                        visit[1][x][y] = true;
                        q.offer(new int[] {x, y, 1, now[3] + 1});
                    }
                }
            }

        }

    }
}
