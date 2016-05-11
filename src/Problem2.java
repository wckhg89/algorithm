import java.util.Scanner;

/**
 * Created by kanghonggu on 2016-05-11.
 */
public class Problem2 {


    public static final int INF = 9999;
    public static int testCase;
    public static int[][] button = new int[10][];

    public static void initButton() {
        button[0] = new int[]{0, 1, 2};
        button[1] = new int[]{3, 7, 9, 11};
        button[2] = new int[]{4, 10, 14, 15};
        button[3] = new int[]{0, 4, 5, 6, 7};
        button[4] = new int[]{6, 7, 8, 10, 12};
        button[5] = new int[]{0, 2, 14, 15};
        button[6] = new int[]{3, 14, 15};
        button[7] = new int[]{4, 5, 7, 14, 15};
        button[8] = new int[]{1, 2, 3, 4, 5};
        button[9] = new int[]{3, 4, 5, 9, 13};
    }

    public static void clickButton(int[] clocks, int btnNum) {
        for (int i = 0; i < button[btnNum].length; i++) {
            if (clocks[button[btnNum][i]] == 12) {
                clocks[button[btnNum][i]] = 3;
            } else {
                clocks[button[btnNum][i]] += 3;
            }
        }
    }

    public static boolean checkClocks(int[] clocks) {
        for (int i = 0; i < 16; i++) {
            if (clocks[i] != 12) {
                return false;
            }
        }
        return true;
    }

    public static int dfs(int[] clocks, int btnNum) {
        if (btnNum == 10) {
            if (checkClocks(clocks)) {
                return 0;
            } else {
                return INF;
            }
        }

        int result = INF;
        for (int i = 0; i < 4; i++) {
            result = Math.min(result, (i + dfs(clocks, btnNum + 1)));

            clickButton(clocks, btnNum);
        }

        return result;
    }

    public static void main(String[] args) {
        initButton();

        int[] clocks = new int[16];
        Scanner sc = new Scanner(System.in);
        testCase = sc.nextInt();

        for (int i = 0; i < testCase; i++) {
            for (int j = 0; j < 16; j++) {
                clocks[j] = sc.nextInt();
            }
        }

        int result = dfs(clocks, 0);

        System.out.println(result);


    }

}
