class Solution {
    public boolean isPowerOfTwo(int n) {
        return sol_1(n);
    }

    private boolean sol_1(int n) {
        if(n <= 0) {
            return false;
        }

        while(n % 2 == 0) {
            n = n / 2;
        }

        return (n == 1);
    }
}