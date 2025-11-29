class Solution {
    public int minEatingSpeed(int[] piles, int h) {
        int n = piles.length;
        int maxPile = maxInArr(piles);
        int low = 1, high = maxPile;
        int ans = maxPile;

        while(low <= high) {
            int mid = low +(high - low) / 2;

            // If possible, try smaller speed
            if(canEat(piles, h, mid)) {
                ans = mid;
                high = mid - 1;
            }
            else {
                low = mid + 1;
            }
        }

        return ans;
    }

    public boolean canEat(int[] arr, int maxLimit, int banana) {
        int currH = 0;

        for(int x : arr) {
            currH += Math.ceil((double) x / banana);
        }

        return currH <= maxLimit;
    }

    public int maxInArr(int[] piles) {
        int maxi = Integer.MIN_VALUE;

        for(int x : piles) {
            maxi = Math.max(maxi, x);
        }

        return maxi;
    }
}

