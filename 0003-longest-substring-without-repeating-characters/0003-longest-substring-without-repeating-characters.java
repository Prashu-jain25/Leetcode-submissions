class Solution {
    public int lengthOfLongestSubstring(String s) {
        int len = s.length();

        int start = 0, end = 0;
        int maxi = 0;

        HashMap<Character, Integer> mpp = new HashMap<>();

        while(end < len) {
            char ch = s.charAt(end);

            if(mpp.containsKey(ch)) {
                start = Math.max(start, mpp.get(ch) + 1) ;
            }

            mpp.put(ch, end);
            maxi = Math.max(maxi, end - start + 1);
            end++;
        }

        return maxi;
    }
}