class Solution {
    public int longestConsecutive(int[] nums) {
        Set<Integer> s = new HashSet<>();
        int res = 0;

        for (int i = 0; i < nums.length; i ++) {
            s.add(nums[i]);
        }

        for (int i : s) {
            if (!s.contains(i - 1)) {
                int curr = 1;
                int next = i + 1;
                while (s.contains(next)) {
                    curr ++;
                    next ++;
                }

                if (curr > res) res = curr;
            }
        }
        return res;
    }
}
