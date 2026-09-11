class Solution {
    public List<String> generateParenthesis(int n) {
        List<Set<String>> generated = new ArrayList<>();
        Set<String> one = new HashSet<>();
        one.add("()");
        generated.add(one);
        for (int i = 2; i <= n; i ++) {
            Set<String> curr = new HashSet<>();
            generated.add(curr);
            int first = 1;
            int second = i - first;
            while (first <= i / 2) {
                for (String s : generated.get(second - 1)) {
                    for (String t : generated.get(first - 1)) {
                        curr.add(t + s);
                        curr.add(t.substring(0, t.length() / 2) + s + t.substring(t.length() / 2));
                        curr.add(s + t);
                    }
                }
                first ++;
                second --;
            }
        }
        List<String> result = new ArrayList<>();
        for (String s : generated.get(generated.size() - 1)) {
            result.add(s);
        }
        return result;
    }
}
