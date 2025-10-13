class Solution {
    public int lengthOfLongestSubstring(String s) {
        int len = s.length();

        int start = 0, end = 0;
        int maxi = 0;

        HashMap<Character, Integer> mpp = new HashMap<>();

        while(end < len) {
            char ch = s.charAt(end);

            // counting frequency of each character
            mpp.put(ch, mpp.getOrDefault(ch, 0) + 1);

            // if frequency > 1
            if(mpp.get(ch) > 1) {

                // shrink window size
                while(mpp.get(ch) > 1) {
                    char startChar = s.charAt(start);
                    mpp.put(startChar, mpp.get(startChar) - 1);
                    start++;
                }
            }

            maxi = Math.max(maxi, end - start + 1);
            end++;
        }

        return maxi;
    }
}