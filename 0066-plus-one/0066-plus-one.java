class Solution {
    public int[] plusOne(int[] digits) {
        int n = digits.length;

        for (int i = n - 1; i >= 0; i--) {
            // If current digit is less than 9, just add 1 and return
            if (digits[i] < 9) {
                digits[i]++;
                return digits;
            }
            // If current digit is 9, it becomes 0 and carry continues
            digits[i] = 0;
        }

        // If all digits were 9 (e.g., [9,9,9]), we need one more digit
        int[] result = new int[n + 1];
        result[0] = 1; // e.g., [1,0,0,0]
        return result;
    }
    
}