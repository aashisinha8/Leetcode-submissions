import java.util.*;

public class Solution {
    public int[] nextGreaterElement(int[] nums1, int[] nums2) {

        Stack<Integer> st = new Stack<>();
        Map<Integer, Integer> map = new HashMap<>();

        // Step 1: process nums2
        for (int num : nums2) {

            while (!st.isEmpty() && st.peek() < num) {
                map.put(st.pop(), num);
            }

            st.push(num);
        }

        // Step 2: remaining elements → no greater
        while (!st.isEmpty()) {
            map.put(st.pop(), -1);
        }

        // Step 3: build result for nums1
        int[] result = new int[nums1.length];

        for (int i = 0; i < nums1.length; i++) {
            result[i] = map.get(nums1[i]);
        }

        return result;
    }
}