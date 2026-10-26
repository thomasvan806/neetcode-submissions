class Solution {
    public List<Integer> partitionLabels(String s) {
        // initial pass to count number of each char
        // when a character is included in a substring, all instances of that character now must be
        // in that substring keep char counts in curr substring
        Map<Character, Integer> counts = new HashMap<>();
        for (int i = 0; i < s.length(); i++) {
            char currChar = s.charAt(i);
            if (!counts.containsKey(currChar)) {
                counts.put(currChar, 0);
            }
            counts.put(currChar, counts.get(currChar) + 1);
        }

        List<Integer> result = new ArrayList<>();

        int length = 0;
        int total = 0;
        Set<Character> currSubstring = new HashSet<>();
        for (int i = 0; i < s.length(); i++) {
            char currChar = s.charAt(i);
            length++;
            if (!currSubstring.contains(currChar)) {
                currSubstring.add(currChar);
                total += counts.get(currChar) - 1;
            } else {
                counts.put(currChar, counts.get(currChar) - 1);
                total--;
            }
            if (total == 0) {
                result.add(length);
                length = 0;
                total = 0;
                currSubstring.clear();
            }
        }

        return result;
    }
}
