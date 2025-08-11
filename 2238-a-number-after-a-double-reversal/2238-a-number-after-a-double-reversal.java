class Solution {
    public boolean isSameAfterReversals(int num) {
        int curr = num;
        int rev1 = reverse(curr);
        int rev2 = reverse(rev1);

        return rev2 == num;
    }

    private int reverse(int num) {
        int rev = 0;

        while(num > 0) {
            int ld = num % 10;
            rev = rev * 10 + ld;
            num = num / 10;
        }

        return rev;
    }
}