class Solution {
    public boolean checkInclusion(String s1, String s2) {
        if (s1.length() > s2.length())
            return false;

        int remaining = s1.length();
        Map<Character, Integer> s1Counts = new HashMap<>();
        Map<Character, Integer> windowCounts = new HashMap<>();

        int left = 0;
        int right = 0;

        for (int i = 0; i < s1.length(); i++) {
            char s1CurrChar = s1.charAt(i);
            if (!s1Counts.containsKey(s1CurrChar)) {
                s1Counts.put(s1CurrChar, 1);
            } else {
                s1Counts.put(s1CurrChar, s1Counts.get(s1CurrChar) + 1);
            }
        }

        while (right < s2.length()) {
            if (remaining == 0)
                return true;
            if ((right - left + 1) > s1.length()) {
                char leftChar = s2.charAt(left);
                if (s1Counts.containsKey(leftChar)) {
                    windowCounts.put(leftChar, windowCounts.get(leftChar) - 1);
                    if (windowCounts.get(leftChar) < s1Counts.get(leftChar)) remaining ++;
                }
                left++;
            }
            char currChar = s2.charAt(right);
            if (s1Counts.containsKey(currChar)) {
                if (!windowCounts.containsKey(currChar)) {
                    windowCounts.put(currChar, 1);
                    remaining--;
                } else {
                    windowCounts.put(currChar, windowCounts.get(currChar) + 1);
                    if (windowCounts.get(currChar) <= s1Counts.get(currChar)) remaining--;
                }
            }
            right++;
        }

        return remaining == 0;
    }
}
