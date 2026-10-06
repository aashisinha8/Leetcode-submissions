class Solution {
    public int[] separateDigits(int[] nums) {

        List<Integer> result = new ArrayList<>();

        for (int num : nums) {

            List<Integer> digits = new ArrayList<>();

            if(num==0){

                result.add(0); 
                continue;

            }
            
            while (num > 0) {
                digits.add(num % 10);
                num /= 10;
            }

            for (int i = digits.size() - 1; i >= 0; i--) {
                result.add(digits.get(i));
            }
        }

        int[] ans = new int[result.size()];

        for (int i = 0; i < ans.length; i++) {
            ans[i] = result.get(i);
        }

        return ans;
    }
}