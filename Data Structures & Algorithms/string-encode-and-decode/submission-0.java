class Solution {
    public String encode(List<String> strs) {
        String result = "";
        String PREFIX_END = "!";
        for (String string : strs) {
            result += string.length() + PREFIX_END + string;
        }
        return result;
    }

    public List<String> decode(String str) {
        List<String> result = new ArrayList<>();
        int i = 0;
        boolean readingPrefix = true;
        String prefix = "";
        String curr = "";
        int charsToRead = 0;
        int charsRead = 0;
        while (i < str.length()) {
            if (readingPrefix) {
                if (str.charAt(i) == '!') {
                    readingPrefix = false;
                    charsToRead = Integer.parseInt(prefix);
                } else {
                    prefix += str.charAt(i);
                }
            } else {
                if (charsRead < charsToRead) {
                    curr += str.charAt(i);
                    charsRead ++;
                } else {
                    result.add(curr);
                    readingPrefix = true;
                    prefix = "" + str.charAt(i);
                    curr = "";
                    charsRead = 0;
                }
            }
            i ++;
        }
        result.add(curr);
        return result;
    }
}
