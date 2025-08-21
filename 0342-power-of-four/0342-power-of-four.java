class Solution {
    public boolean isPowerOfFour(int n) {
        return sol_1(n);
    }

    private boolean sol_1(int n) {
        if(n <= 0) {
            return false;
        }
        while( n % 4 == 0) {
            n = n / 4;
        }
        return n == 1;
    }
}