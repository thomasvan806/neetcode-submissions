class Solution {
    public int lengthOfLongestSubstring(String s) {
        int left = 0;
        int right = 0;
        int max = 0;
        Map<Character, Integer> indices = new HashMap<>();

        for (int i = 0; i < s.length(); i ++) {
            char currChar = s.charAt(i);
            if (indices.containsKey(currChar) && indices.get(currChar) >= left) {
                left = indices.get(currChar) + 1;
                indices.put(currChar, i);
            } else {
                indices.put(currChar, i);
            }
            right ++;
            if ((right - left) > max) max = (right - left);
        }

        return max;
    }
}
