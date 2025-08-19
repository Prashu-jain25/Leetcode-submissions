class Solution {
    public long zeroFilledSubarray(int[] nums) {
        long cnt = 0, streak = 0;

        for(int x : nums) {
            if(x == 0) {
                streak++;
            }
            else {
                streak = 0;
            }
            
            cnt += streak;
        }

        return cnt;
    }
}