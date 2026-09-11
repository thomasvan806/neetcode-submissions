class Solution {
    public int numDecodings(String s) {
       if (s.charAt(0) == '0') return 0;
        int b1 = 1;
        int b2 = 1;
        int total = 1;
        for (int i = 1; i < s.length(); i ++) {
            total = 0;
            // decode len 1
            if (s.charAt(i) != '0') {
                total += b1;
            }
            // decode len 2
            if (s.charAt(i - 1) != '0' &&
                Integer.parseInt(s.substring(i - 1, i + 1)) <= 26) {
                total += b2;
            }
            b2 = b1;
            b1 = total;
        }
        return total; 
    }
}
