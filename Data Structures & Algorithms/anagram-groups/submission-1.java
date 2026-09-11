class Solution {
    public List<List<String>> groupAnagrams(String[] strs) {
        Map<String, List<String>> anagrams = new HashMap<>();
        for (int i = 0; i < strs.length; i ++) {
            int[] counts = countChars(strs[i]);
            String key = Arrays.toString(counts);
            if (!anagrams.containsKey(key)) {
                List<String> list = new ArrayList<>();
                list.add(strs[i]);
                anagrams.put(key, list);
            } else {
                List<String> list = anagrams.get(key);
                list.add(strs[i]);
            }
        }
        List<List<String>> result = new ArrayList<>();
        for (List<String> list : anagrams.values()) {
            result.add(list);
        }
        return result;
    }

    private int[] countChars(String str) {
        int[] result = new int[26];
        for (int i = 0; i < str.length(); i ++) {
            result[((int) str.charAt(i)) - 97] ++;
        }
        return result;
    }
}
