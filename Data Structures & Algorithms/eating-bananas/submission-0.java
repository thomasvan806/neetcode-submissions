class Solution {
    public int minEatingSpeed(int[] piles, int h) {
        int k = 0;

        int left = 1;
        int right = Arrays.stream(piles).max().getAsInt();
        int mid = (right + left) / 2;

        while (left <= right) {
            int hours = 0;
            int i = 0;
            while (hours < h && i < piles.length) {
                hours += (int) Math.ceil((double) piles[i] / mid);
                if (hours <= h) i ++;
            }

            if (i == piles.length) {
                k = mid;
                right = mid - 1;
            } else {
                left = mid + 1;
            }
            mid = (right + left) / 2;
        }
        
        return k;
    }
}
