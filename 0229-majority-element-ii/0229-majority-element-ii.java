class Solution {
    public List<Integer> majorityElement(int[] nums) {
        return brute(nums);
    }

    private List<Integer> brute(int[] nums) {
        int n = nums.length;
        List<Integer> res = new ArrayList<>();

        for(int i = 0; i < n; i++) {
            if(res.contains(nums[i])) {
                continue;
            }

            int cnt = 0;

            for(int j = 0; j < n; j++) {
                if(nums[j] == nums[i]) {
                    cnt++;
                }

                if(cnt > n / 3) {
                    res.add(nums[i]);
                    break;
                }
            }
        }

        return res;
    }
}