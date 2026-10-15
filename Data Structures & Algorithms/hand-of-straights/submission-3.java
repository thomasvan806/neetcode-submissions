class Solution {
    public boolean isNStraightHand(int[] hand, int groupSize) {
        if ((hand.length % groupSize) != 0) return false;
        
        Arrays.sort(hand);

        Map<Integer, Integer> counts = new HashMap<>();
        for (int i : hand) {
            if (!counts.containsKey(i)) {
                counts.put(i, 1);
            } else {
                counts.put(i, counts.get(i) + 1);
            }
        }

        // [1,2,3,6,2,3,4,7,8]
        // 1, 2, 2, 3, 3, 4, 6, 7, 8
        //       
        //       s
        // c = 3
        for (int curr : hand) {
            if (!counts.containsKey(curr)) {
                continue;
            } else {
                for (int i = 0; i < groupSize; i ++) {
                    if (!counts.containsKey(curr + i)) return false;

                    if (counts.get(curr + i) == 1) {
                        counts.remove(curr + i);
                    } else {
                        counts.put(curr + i, counts.get(curr + i) - 1);
                    }
                }
            }
        }
        return true;

        // use map

        // 



        // 1, 2, 2, 3, 3, 4, 4, 5
        // 1, 2, 3
        // 2, 3


    }
}
