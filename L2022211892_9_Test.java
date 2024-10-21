import static org.junit.Assert.*;
import org.junit.Test;

/**
 * @description:
 * 测试类的总体设计原则：
 * 1. 使用等价类划分：将输入的 n 和 dislikes 根据可能的组合划分为几类，包括正向分组可能成功的场景、负向不可能分组的场景、空输入的场景等。
 * 2. 测试用例覆盖：确保覆盖所有的边界条件、典型输入情况和特殊情况。
 */

public class L2022211892_9_Test {

    /**
     * 测试目的：验证在有可能分成两组的情况下，算法返回 true。
     * 测试用例：n = 4, dislikes = {{1, 2}, {1, 3}, {2, 4}}
     */
    @Test
    public void testPossibleBipartition_TrueCase() {
        Solution9 solution = new Solution9();
        int n = 4;
        int[][] dislikes = {{1, 2}, {1, 3}, {2, 4}};
        assertTrue(solution.possibleBipartition(n, dislikes));
    }

    /**
     * 测试目的：验证在不能分成两组的情况下，算法返回 false。
     * 测试用例：n = 3, dislikes = {{1, 2}, {1, 3}, {2, 3}}
     */
    @Test
    public void testPossibleBipartition_FalseCase() {
        Solution9 solution = new Solution9();
        int n = 3;
        int[][] dislikes = {{1, 2}, {1, 3}, {2, 3}};
        assertFalse(solution.possibleBipartition(n, dislikes));
    }

    /**
     * 测试目的：验证当 dislikes 为空时，算法能正确返回 true。
     * 测试用例：n = 5, dislikes = {}
     */
    @Test
    public void testPossibleBipartition_EmptyDislikes() {
        Solution9 solution = new Solution9();
        int n = 5;
        int[][] dislikes = {};
        assertTrue(solution.possibleBipartition(n, dislikes));
    }

    /**
     * 测试目的：验证复杂情况下算法返回正确结果。
     * 测试用例：n = 5, dislikes = {{1, 2}, {2, 3}, {3, 4}, {4, 5}, {1, 5}}
     */
    @Test
    public void testPossibleBipartition_ComplexCase() {
        Solution9 solution = new Solution9();
        int n = 5;
        int[][] dislikes = {{1, 2}, {2, 3}, {3, 4}, {4, 5}, {1, 5}};
        assertFalse(solution.possibleBipartition(n, dislikes));
    }
}

