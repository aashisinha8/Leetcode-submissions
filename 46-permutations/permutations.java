class Solution {

    public List<List<Integer>> permute(int[] nums) {

        List<List<Integer>> result = new ArrayList<>();
        List<Integer>curr=new ArrayList<>();
        backtrack(nums, curr, result);

        return result;
    }

    private void backtrack(int[] nums,
                           List<Integer> curr,
                           List<List<Integer>> result) {

        if(curr.size() == nums.length) {
            result.add(new ArrayList<>(curr));
            return;
        }

        for(int num : nums) {

            if(curr.contains(num))
                continue;

            curr.add(num);

            backtrack(nums, curr, result);
           //backtracking
            curr.remove(curr.size() - 1);
        }
    }
}