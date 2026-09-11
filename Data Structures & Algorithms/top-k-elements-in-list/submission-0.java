class Solution {
    public int[] topKFrequent(int[] nums, int k) {
        Map<Integer, Integer> counts = new HashMap<>();
        List<List<Integer>> lists = new ArrayList<>();
        for (int i = 0; i < nums.length; i ++) {
            if (!counts.containsKey(nums[i])) {
                counts.put(nums[i], 1);
                setLists(lists, 1, nums[i]);
            } else {
                int count = counts.get(nums[i]);
                counts.put(nums[i], count + 1);
                setLists(lists, count + 1, nums[i]);
            }
        }
        int[] result = new int[k];
        int added = 0;
        for (int i = lists.size() - 1; i >= 0; i --) {
            if (lists.get(i) != null) {
                for (Integer num : lists.get(i)) {
                    result[added] = num;
                    added ++;
                    if (added == k) return result;
                }
            }
        }
        return result;
    }

    private void setLists(List<List<Integer>> lists, int index, int value) {
        if ((index - 1) >= lists.size()) {
            List<Integer> list = new ArrayList<>();
            list.add(value);
            lists.add(list);
        } else {
            lists.get(index - 1).add(value);
        }
    }
}
