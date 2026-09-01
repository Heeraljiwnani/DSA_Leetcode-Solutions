class Solution {
    public String frequencySort(String s) {
        HashMap<Character, Integer> frequency = new HashMap<Character, Integer>();
        for (char ch : s.toCharArray()) {
            if (frequency.containsKey(ch)) {
                frequency.put(ch, frequency.get(ch) + 1);
            } else {
                frequency.put(ch, 1);
            }
        }
        frequency.keySet();
        ArrayList<Character> chars = new ArrayList<> (frequency.keySet());
        chars.sort((a,b)-> frequency.get(b)-frequency.get(a));
        StringBuilder ans = new StringBuilder();
        for (char ch : chars) {
    for (int i = 0; i < frequency.get(ch); i++) {
        ans.append(ch);
    }
}
        return ans.toString();
    }
}