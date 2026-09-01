class Solution {
    public int maxDepth(String s) {
        int n=0;
        ArrayList<Integer> num = new ArrayList<> ();
        for(char ch: s.toCharArray()){
            if(ch == '('){
                n = n +1;
                num.add(n);
            }
            else if(ch == ')'){
                n = n-1;
                num.add(n);
            }
        }
        if (!num.isEmpty()) {
        int max = Collections.max(num);
        return max;
        }
        return 0;
    }
}