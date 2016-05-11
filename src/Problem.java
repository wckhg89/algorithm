import java.util.Scanner;

/**
 * Created by kanghonggu on 2016-05-11.
 */
public class Problem {
    public static int testNum;
    public static int cityNum;

    public static boolean[] visit;
    public static int[][] map;

    public static int min = Integer.MAX_VALUE;

    public static void dfs(int v, int sum, int width) {

        if(width == cityNum-1) {
            if(min > sum + map[v][0]) {
                min = sum+ map[v][0];
                return;
            }
        }

        for (int i = 1; i < cityNum; i++) {
            // 만일 이동 가능한 길이 라면
            if (map[v][i] > 0 && visit[i] == false) {
                // v 도시에서 i 도시로 이동한다.
                visit[i] = true;
                dfs(i, sum + map[v][i], width + 1);
                visit[i] = false;
            }
        }

    }

    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        testNum = scan.nextInt();

        for (int k = 0; k < testNum; k++) {
            cityNum = scan.nextInt();

            visit = new boolean[cityNum];
            map = new int[cityNum][cityNum ];

            for (int j = 0; j < cityNum; j++) {
                for (int i = 0; i < cityNum; i++) {
                    map[j][i] = scan.nextInt();
                    if (j == 0) {
                        visit[i] = false;
                    }
                }
            }

            dfs(0, 0, 0);

            System.out.println(min);
        }


    }
}
