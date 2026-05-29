class Solution {
    private String[] map={"","","abc","def","ghi","jkl","mno","pqrs","tuv","wxyz"};
    public List<String> letterCombinations(String digits) {
        List<String> result=new ArrayList<>();
        //edge case
        if (digits == null || digits.length() == 0) {
            return result;
        }
        StringBuilder sb=new StringBuilder();
        backtrack(0,digits,sb,result);
        return result;
    }
    private void backtrack(int index,String digits,StringBuilder sb,List<String> result){
        //base case
        if(index==digits.length()){
            result.add(sb.toString());
            return;
        }
           String letters =
            map[digits.charAt(index) - '0'];

        for (char ch : letters.toCharArray()) {

            sb.append(ch);

            backtrack(index + 1,
                      digits,
                      sb,
                      result);

            sb.deleteCharAt(sb.length() - 1);
        }
    }
}