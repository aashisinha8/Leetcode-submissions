class Solution {
    public int[] finalPrices(int[] prices) {
        //next smalle number
        Stack<Integer> stack=new Stack<>();
        int[] result=new int[prices.length];
        for(int i=prices.length-1;i>=0;i--){
            while(!stack.isEmpty() && stack.peek()>prices[i]){
                stack.pop();
            }
            result[i]=stack.isEmpty()?prices[i]:prices[i]-stack.peek();
            stack.push(prices[i]);

        }
        return result;
    }
}