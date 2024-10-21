import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

/**
 * @description:
 *
 * 给定一组 n 人（编号为 1, 2, ..., n）， 我们想把每个人分进任意大小的两组。每个人都可能不喜欢其他人，那么他们不应该属于同一组。
 *
 * 给定整数 n 和数组 dislikes ，其中 dislikes[i] = [ai, bi] ，表示不允许将编号为 ai 和  bi的人归入同一组。当可以用这种方法将所有人分进两组时，返回 true；否则返回 false。
 *
 *
 *
 * 示例 1：
 *
 * 输入：n = 4, dislikes = [[1,2],[1,3],[2,4]]
 * 输出：true
 * 解释：group1 [1,4], group2 [2,3]
 * 示例 2：
 *
 * 输入：n = 3, dislikes = [[1,2],[1,3],[2,3]]
 * 输出：false
 * 示例 3：
 *
 * 输入：n = 5, dislikes = [[1,2],[2,3],[3,4],[4,5],[1,5]]
 * 输出：false
 *
 *
 * 提示：
 *
 * 1 <= n <= 2000
 * 0 <= dislikes.length <= 104
 * dislikes[i].length == 2
 * 1 <= dislikes[i][j] <= n
 * ai < bi
 * dislikes 中每一组都 不同
 *
 */
class Solution9 {

    public boolean possibleBipartition(int n, int[][] dislikes) {
        int[] fa = new int[n + 1];
        Arrays.fill(fa, -1);
        List<Integer>[] g = new List[n + 1];
        for (int i = 1; i <= n; ++i) {
            g[i] = new ArrayList<>();
        }
        for (int[] p : dislikes){
            g[p[0]].add(p[1]);
            g[p[1]].add(p[0]);
        }
        for (int i = 1; i <= n; ++i) {
            if (g[i].isEmpty()){
                continue;
            }
            for (int j = 1; j < g[i].size(); ++j) {
                unit(g[i].get(0), g[i].get(j), fa);
                if (isConnected(i, g[i].get(j), fa)) {
                    return false;
                }
            }
        }
        return true;
    }

    public void unit(int x, int y, int[] fa) {
        x = findFa(x, fa);
        y = findFa(y, fa);
        if (x != y) {
            fa[y] = x ;
        }

    }

    public boolean isConnected(int x, int y, int[] fa) {
        return findFa(x, fa) == findFa(y, fa);
    }

    public int findFa(int x, int[] fa) {
       if (fa[x] < 0) {
            return x;
       }
        return fa[x] = findFa(fa[x], fa);
    }
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Solution9 solution = new Solution9();
        System.out.println("请输入人数 n：");
        int n = scanner.nextInt();
        scanner.nextLine(); 
        List<int[]> dislikesList = new ArrayList<>();
        System.out.println("请输入每对不喜欢的人的编号 (ai bi)：");
        while (true) {
            String line = scanner.nextLine().trim();
            if (line.isEmpty()) {
                break;  // 空行结束输入
            }
            String[] parts = line.split("\\s+");  // 以空格分隔
            int a = Integer.parseInt(parts[0]);
            int b = Integer.parseInt(parts[1]);
            dislikesList.add(new int[]{a, b});
        }
        int[][] dislikes = dislikesList.toArray(new int[dislikesList.size()][]);
        boolean result = solution.possibleBipartition(n, dislikes);
        System.out.println("是否可以分成两组：" + result);

        scanner.close();
    }
}