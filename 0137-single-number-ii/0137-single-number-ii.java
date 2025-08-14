class Solution {
    public int singleNumber(int[] nums) {
        int n = nums.length;
        HashMap<Integer, Integer> mpp = new HashMap<>();

        for(int i = 0; i < n; i++) {
            mpp.put(nums[i], mpp.getOrDefault(nums[i], 0) + 1);
        }

        for(HashMap.Entry<Integer, Integer> x : mpp.entrySet()) {
            int val = x.getKey();
            int frequency = x.getValue();
            if(frequency == 1) {
                return val;
            }
        }

        return -1;
    }
}