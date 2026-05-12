class Solution {
    public String makeGood(String s) {
        Stack<Character> stack=new Stack<>();
        char[] arr=s.toCharArray();
        for(int i=0;i<arr.length;i++){
            if(!stack.isEmpty() && Math.abs(stack.peek() - arr[i]) == 32){
                stack.pop();
            }
            
        else{
            stack.push(arr[i]);

            }

        }
        char[]  result=new char[stack.size()];
        for(int i=result.length-1;i>=0;i--){
            result[i]=stack.pop();
        }
        return new String(result);
    }
}