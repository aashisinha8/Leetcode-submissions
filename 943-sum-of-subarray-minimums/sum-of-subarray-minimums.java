class Solution {
    public int sumSubarrayMins(int[] arr) {
        int n = arr.length;
        long mod = 1_000_000_007;

        int[] left = new int[n];
        int[] right = new int[n];

        Stack<Integer> st = new Stack<>();

        // Previous Smaller (strictly smaller)
        for (int i = 0; i < n; i++) {
            while (!st.isEmpty() && arr[st.peek()] > arr[i]) {
                st.pop();
            }
            left[i] = st.isEmpty() ? -1 : st.peek();
            st.push(i);
        }

        st.clear();

        //  Next Smaller (smaller or equal)
        for (int i = n - 1; i >= 0; i--) {
            while (!st.isEmpty() && arr[st.peek()] >= arr[i]) {
                st.pop();
            }
            right[i] = st.isEmpty() ? n : st.peek();
            st.push(i);
        }

        long result = 0;

        for (int i = 0; i < n; i++) {
            long count = (long)(i - left[i]) * (right[i] - i);
            result = (result + arr[i] * count) % mod;
        }

        return (int) result;
    }
}