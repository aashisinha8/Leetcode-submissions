import java.util.*;

public class Solution {

    public int maximalRectangle(char[][] matrix) {
        if (matrix.length == 0) return 0;

        int n = matrix.length;
        int m = matrix[0].length;

        int[] height = new int[m];
        int maxArea = 0;

        for (int i = 0; i < n; i++) {

            // Build histogram
            for (int j = 0; j < m; j++) {
                if (matrix[i][j] == '1') {
                    height[j] += 1;
                } else {
                    height[j] = 0;
                }
            }

            // Apply NSL + NSR
            maxArea = Math.max(maxArea, largestRectangle(height));
        }

        return maxArea;
    }

    private int largestRectangle(int[] heights) {
        int n = heights.length;

        int[] left = new int[n];   // NSL
        int[] right = new int[n];  // NSR

        Stack<Integer> st = new Stack<>();

        // NSL
        for (int i = 0; i < n; i++) {
            while (!st.isEmpty() && heights[st.peek()] >= heights[i]) {
                st.pop();
            }
            left[i] = st.isEmpty() ? -1 : st.peek();
            st.push(i);
        }

        st.clear();

        // NSR
        for (int i = n - 1; i >= 0; i--) {
            while (!st.isEmpty() && heights[st.peek()] >= heights[i]) {
                st.pop();
            }
            right[i] = st.isEmpty() ? n : st.peek();
            st.push(i);
        }

        // Compute max area
        int maxArea = 0;

        for (int i = 0; i < n; i++) {
            int width = right[i] - left[i] - 1;
            int area = heights[i] * width;
            maxArea = Math.max(maxArea, area);
        }

        return maxArea;
    }
}