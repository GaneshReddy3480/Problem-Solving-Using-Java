class Solution {
    public int[] sortedSquares(int[] nums) {
        int i, l, r;

        int[] res = new int[nums.length];

        i = res.length - 1;
        l = 0;
        r = nums.length - 1;

        while (l <= r) {
            if (Math.abs(nums[l]) >= Math.abs(nums[r])) {
                res[i] = nums[l] * nums[l];
                l++;
            } else {
                res[i] = nums[r] * nums[r];
                r--;
            }
            i--;
        }

        return res;
    }
}