class Solution {

    public String getPermutation(int n, int k) {

        List<Integer> nums = new ArrayList<>();

        int fact = 1;
// factorila for (n-1): (n-1)!
        for(int i=1; i<n; i++){
            fact *= i;
        }
//addall digits to list
        for(int i=1; i<=n; i++){
            nums.add(i);
        }

        k--; // convert to 0-based index

        StringBuilder ans = new StringBuilder();

        while(true){

            int index = k / fact;    

            ans.append(nums.get(index));

            nums.remove(index);

            if(nums.size() == 0)
                break;

            k = k % fact;

            fact = fact / nums.size();
        }

        return ans.toString();
    }
}