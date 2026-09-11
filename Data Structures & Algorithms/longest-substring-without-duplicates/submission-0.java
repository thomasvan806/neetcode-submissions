class Solution {
    public int lengthOfLongestSubstring(String s) {
    Map<String, Integer> indices = new HashMap<>();
        int result = 0;
        int curr = 0;
        int dupeIndex = 0;
        for (int i = 0; i < s.length(); i ++) {
            String currChar = s.charAt(i) + "";
            if (indices.containsKey(currChar)) {
                int index = indices.get(currChar);
                if (index >= dupeIndex) {
                    curr = i - index;
                    dupeIndex = index;
                } else {
                    curr ++;
                }
            } else {
                curr ++;
            }
            if (curr > result) result = curr;
            indices.put(currChar, i);
        }
        return result;
    }
}
