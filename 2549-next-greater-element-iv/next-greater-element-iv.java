class Solution {
    public int[] secondGreaterElement(int[] nums) {

        int n = nums.length;
        int[] res = new int[n];
        Arrays.fill(res, -1);

        Stack<Integer> s1 = new Stack<>(); // waiting for first greater
        Stack<Integer> s2 = new Stack<>(); // waiting for second greater

        for (int i = 0; i < n; i++) {

            // resolve second greater
            while (!s2.isEmpty() && nums[i] > nums[s2.peek()]) {
                res[s2.pop()] = nums[i];
            }

            // move from s1 → s2 (found first greater)
            Stack<Integer> temp = new Stack<>();
            while (!s1.isEmpty() && nums[i] > nums[s1.peek()]) {
                temp.push(s1.pop());
            }

            while (!temp.isEmpty()) {
                s2.push(temp.pop());
            }

            // push current index
            s1.push(i);
        }

        return res;
    }
}