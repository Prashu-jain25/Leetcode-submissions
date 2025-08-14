class Solution {
    public boolean containsDuplicate(int[] nums) {
        // return sol_1(nums);
        // return sol_2(nums);
        return sol_3(nums);
    }

    private boolean sol_3(int[] nums) {
        HashSet<Integer> set = new HashSet<>();

        for(int x : nums) {
            if(set.contains(x)) {
                return true;
            }

            set.add(x);
        }

        return false;
    }

    private boolean sol_2(int[] nums) {
        int n = nums.length;

        if(n == 1) {
            return false;
        }

        HashMap<Integer, Integer> mpp = new HashMap<>();

        for(int i = 0; i < n; i++) {
            mpp.put(nums[i], mpp.getOrDefault(nums[i], 0) + 1);
        }

        for(int x : mpp.values()) {
            if(x >= 2) {
                return true;
            }
        }

        return false;

    }

    private boolean sol_1(int[] nums) {
        Arrays.sort(nums);
        int n = nums.length;

        if(n == 1) {
            return false;
        }

        for(int i = 0; i < n - 1; i++) {
            if(nums[i] == nums[i + 1]) {
                return true;
            }
        }

        return false;
    }
}