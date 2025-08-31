class Solution {
    public int distributeCandies(int[] candyType) {
        int n = candyType.length;
        int maxi = n / 2;
        HashSet<Integer> set = new HashSet<>();
        
        for(int x : candyType) {
            set.add(x);
        }

        int cnt = set.size();
        return Math.min(maxi, cnt);
    }
}