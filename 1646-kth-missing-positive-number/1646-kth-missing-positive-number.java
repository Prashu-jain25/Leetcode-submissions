class Solution {
    public int findKthPositive(int[] arr, int k) {
        return brute_force(arr, k);
    }

    private int brute_force(int[] arr, int k) {
        int n = arr.length;
        
        for(int i = 0; i < n; i++) {
            if(arr[i] <= k) {
                k++;
            }
            else {
                break;
            }
        }

        return k;
    }
}