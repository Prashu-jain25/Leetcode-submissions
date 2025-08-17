class Solution {
    public List<Integer> findDisappearedNumbers(int[] nums) {
        // return sol1(nums);
        return sol2(nums);
    }

    private List<Integer> sol2(int[] nums) {
        int n = nums.length;
        List<Integer> ans = new ArrayList<>();
        
        for(int i = 0; i < n; i++) {
            int index = Math.abs(nums[i]) - 1;
            if(nums[index] > 0) {
                nums[index] = - nums[index];
            }
        }

        for(int i = 0; i < n; i++) {
            if(nums[i] > 0) {
                ans.add(i + 1);
            }
        }

        return ans;
    }

    private List<Integer> sol1(int[] nums) {
        int n = nums.length;
        List<Integer> ans = new ArrayList<>();
        HashSet<Integer> set = new HashSet<>();

        for(int i = 0; i < n; i++) {
            set.add(nums[i]);
        }

        for(int i = 1; i <= n; i++) {
            if(!set.contains(i)) {
                ans.add(i);
            }
        }

        return ans;
    }
}