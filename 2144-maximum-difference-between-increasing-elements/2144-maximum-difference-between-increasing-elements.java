class Solution {
    public int maximumDifference(int[] nums) {
       // return bruteForce(nums);
       return optimal(nums);
    }

    private int bruteForce(int[] nums) {
        int n = nums.length;
        int maxDiff = -1;

        for(int i = 0; i < n; i++) {
            for(int j = i + 1; j < n; j++) {
                if(nums[i] < nums[j]) {
                    int currDiff = nums[j] - nums[i];
                    maxDiff = Math.max(maxDiff, currDiff);
                }
            }
        }

        return maxDiff;
    }

    private int optimal(int[] nums) {
        int n = nums.length;
        int maxDiff = -1;
        int i = nums[0];
        int currDiff = 0;

        for(int j = 1; j < n; j++) {
            if(nums[j] > i) {
                currDiff = nums[j] - i;
                maxDiff = Math.max(maxDiff, currDiff);
            }
            else {
                i = nums[j];
            }
        }

        return maxDiff;

    }
}