class Solution {
    public List<List<String>> groupAnagrams(String[] strs) {
        Map<Map<Character, Integer>, List<String>> anagrams = new HashMap<>();
        for (int i = 0; i < strs.length; i ++) {
            Map<Character, Integer> counts = countChars(strs[i]);
            if (!anagrams.containsKey(counts)) {
                List<String> list = new ArrayList<>();
                list.add(strs[i]);
                anagrams.put(counts, list);
            } else {
                List<String> list = anagrams.get(counts);
                list.add(strs[i]);
            }
        }
        List<List<String>> result = new ArrayList<>();
        for (List<String> list : anagrams.values()) {
            result.add(list);
        }
        return result;
    }

    private Map<Character, Integer> countChars(String str) {
        Map<Character, Integer> result = new HashMap<>();
        for (int i = 0; i < str.length(); i ++) {
            char currChar = str.charAt(i);
            if (!result.containsKey(currChar)) {
                result.put(currChar, 1);
            } else {
                result.put(currChar, result.get(currChar) + 1);
            }
        }
        return result;
    }
}
