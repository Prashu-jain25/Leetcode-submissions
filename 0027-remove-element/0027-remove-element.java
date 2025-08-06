class Solution {
    public int removeElement(int[] nums, int val) {
        int k = 0; // Count of elements not equal to val

        for (int i = 0; i < nums.length; i++) {
            if (nums[i] != val) {
                nums[k] = nums[i]; // Overwrite the value at index k
                k++;
            }
        }

        return k; // First k elements in nums are the result

       
    }
}