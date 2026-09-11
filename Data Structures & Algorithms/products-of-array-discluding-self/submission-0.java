class Solution {
    public int[] productExceptSelf(int[] nums) {
        int[] firstPass = new int[nums.length];
        int[] secondPass = new int[nums.length];
        int[] result = new int[nums.length];
        firstPass[0] = 1;
        secondPass[secondPass.length - 1] = 1;

        for (int i = 1; i < firstPass.length; i ++) {
            firstPass[i] = firstPass[i - 1] * nums[i - 1];
        }

        for (int i = secondPass.length - 2; i >= 0; i --) {
            secondPass[i] = secondPass[i + 1] * nums[i + 1];
            result[i] = firstPass[i] * secondPass[i];
        }

        result[0] = firstPass[0] * secondPass[0];
        result[result.length - 1] = firstPass[result.length - 1] * secondPass[result.length - 1];
        return result;
        // 1 1 2 8
        // 48 24 6 1

        // 1 -1 0 0 0
        // 0 6 6 3 1
    }
}  
