class Solution {
    public int minEatingSpeed(int[] piles, int h) {
        int n = piles.length;
        int low = 1, high = maxInArr(piles);

        while(low <= high) {
            int mid = low +(high - low) / 2;

            if(canEat(piles, h, mid)) {
                high = mid - 1;
            }
            else {
                low = mid + 1;
            }
        }

        return low;
    }

    public boolean canEat(int[] arr, int maxLimit, int banana) {
        int currH = 0;

        for(int x : arr) {
            currH += Math.ceil((double) x / (double) banana);
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

/*
arr = [3,6,7,11]
h = 8

banana = [1, 11]

mid = 6 banana
cnt = 1 + 1 + 2 + 2 => 6hr

banana = [1, 6]

mid = 3
cnt = 1 + 2 + 3 + 4 = 10hr

range = [4, 6]
mid = 5
cnt = 1 + 2 + 2 + 3 = 8hr

range = [4, 5]
mid = 4
cnt = 1 + 2 + 2 + 3 = 8hr

range = [4, 4]
mid = 4



*/
