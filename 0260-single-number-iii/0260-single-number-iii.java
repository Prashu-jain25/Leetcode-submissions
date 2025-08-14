class Solution {
    public int[] singleNumber(int[] nums) {
        int n = nums.length;
        int[] ans = new int[2];
        HashMap<Integer, Integer> mpp = new HashMap<>();

        for(int i = 0; i < n; i++) {
            mpp.put(nums[i], mpp.getOrDefault(nums[i], 0) + 1);
        }

        int i = 0;
        for(HashMap.Entry<Integer, Integer> x : mpp.entrySet()) {
            if(x.getValue() == 1) {
                ans[i++] = x.getKey();
            }
        }

        return ans;
    }
}