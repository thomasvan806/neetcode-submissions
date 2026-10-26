class Solution {
    public boolean mergeTriplets(int[][] triplets, int[] target) {
        // only max of all, not just individual number
        // consider current triplet relative to target
        // for candidate triplet, one index must be equal to target, while other indices are less than or equal to their respective number in triplets
        // for each triplet,
        // for each num, if equal to target, set num to true
        // if larger than target, set triplet to false
        // if less than target, do nothing
        // if triplet is true, set global nums equal to local nums
        // check for all nums true, return true

        boolean num1 = false;
        boolean num2 = false;
        boolean num3 = false;

        for (int[] triplet : triplets) {
            if (num1 && num2 && num3) return true;

            if (triplet[0] > target[0] || triplet[1] > target[1] || triplet[2] > target[2]) {
                continue;
            } else {
                num1 = num1 || (triplet[0] == target[0]);
                num2 = num2 || (triplet[1] == target[1]);
                num3 = num3 || (triplet[2] == target[2]);
            }
        }

        return num1 && num2 && num3;
    }
}
