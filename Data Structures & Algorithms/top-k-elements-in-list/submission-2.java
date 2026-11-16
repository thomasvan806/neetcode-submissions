class Solution {
    public int[] topKFrequent(int[] nums, int k) {
        Map<Integer, Integer> counts = new HashMap<>();

        for (int num : nums) {
            if (!counts.containsKey(num)) {
                counts.put(num, 0);
            }

            counts.put(num, counts.get(num) + 1);
        }

        List<List<Integer>> lists = new ArrayList<>();
        for (int i = 0; i <= nums.length; i ++) {
            lists.add(new ArrayList<>());
        }

        for (int key : counts.keySet()) {
            lists.get(counts.get(key)).add(key);
        }

        int[] result = new int[k];

        int resultIndex = 0;
        int listIndex = lists.size() - 1;
        
        while (resultIndex < k && listIndex >= 0) {
            for (int candidate : lists.get(listIndex)) {
                result[resultIndex] = candidate;
                resultIndex ++;
                if (resultIndex >= k) return result;
            }
            listIndex --;
        }

        return result;
    }
}
