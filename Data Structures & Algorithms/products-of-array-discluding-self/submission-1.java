class Solution {
    public int[] productExceptSelf(int[] nums) {
        int[] firstPass = new int[nums.length];
        int[] secondPass = new int[nums.length];
        firstPass[0] = 1;
        secondPass[secondPass.length - 1] = 1;

        for (int i = 1; i < firstPass.length; i ++) {
            firstPass[i] = firstPass[i - 1] * nums[i - 1];
        }

        for (int i = secondPass.length - 2; i >= 0; i --) {
            secondPass[i] = secondPass[i + 1] * nums[i + 1];
            firstPass[i] *= secondPass[i];
        }

        firstPass[firstPass.length - 1] *= secondPass[secondPass.length - 1];
        return firstPass;
    }
}  
