class Solution {
    public boolean isPalindrome(int x) {

        if (x < 0) return false;
        int duplicate = x;
        int rev = 0;

        while(x != 0) {
            int ld = x % 10; // find last digit
            rev = (rev * 10) + ld; // reverse num
            x = x / 10; // remove last digit
        }

        return (duplicate == rev);
    }
}