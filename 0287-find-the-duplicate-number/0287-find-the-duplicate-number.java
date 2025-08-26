class Solution {
    public int findDuplicate(int[] nums) {
        int slow = nums[0];
        int fast = nums[0];

        // find intersection point
        do {
            slow = nums[slow];  // move 1 step
            fast = nums[nums[fast]];  // move 2 step
        } while(slow != fast); // loop until they meet

        slow = nums[0]; // Reset one pointer to start

        while(slow != fast) {
            // Move both one step at a time
            slow = nums[slow];
            fast = nums[fast];
        }

        return slow; // or fast (same value here)
    }

}