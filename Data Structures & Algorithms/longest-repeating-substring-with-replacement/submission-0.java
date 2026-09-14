class Solution {
    public int characterReplacement(String s, int k) {
        Map<Character, Integer> counts = new HashMap<>();
        int l = 0;
        int max = 0;
        int res = 0;
        for (int r = 0; r < s.length(); r ++) {
            int count;
            char currChar = s.charAt(r);
            if (!counts.containsKey(currChar)) {
                count = 1;
                counts.put(currChar, count);
            } else {
                count = counts.get(currChar) + 1;
                counts.put(currChar, count);
            }
            if (count > max) max = count;

            if ((r + 1 - l) - max > k) {
                counts.put(s.charAt(l), counts.get(s.charAt(l)) - 1);
                l ++;
            }

            if ((r + 1 - l) > res) res = r + 1 - l;
        }
        return res;
    }
}
