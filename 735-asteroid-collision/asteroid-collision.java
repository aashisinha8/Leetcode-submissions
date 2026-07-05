class Solution {
    public int[] asteroidCollision(int[] asteroids) {
        Stack<Integer>stack=new Stack<>();
       for (int num : asteroids) {

    boolean destroyed = false;

    while (!stack.isEmpty() &&
           stack.peek() > 0 &&
           num < 0) {

        if (stack.peek() < -num) {

            stack.pop();

        } else if (stack.peek() == -num) {

            stack.pop();
            destroyed = true;
            break;

        } else {

            destroyed = true;
            break;
        }
    }

    if (!destroyed)
        stack.push(num);
}
    int[] result=new int[stack.size()];
    for(int i=result.length-1;i>=0;i--){
        result[i]=stack.pop();
    }
        return result;
    }
}