class Solution {
    public int lengthOfLongestSubstring(String s) {
   
            // int n = s.length();
            // int i = 0, j = 0, maxLen = 0;
            // HashMap<Character, Integer> mpp = new HashMap<>();

            // while(j < n) {
            //     char ch = s.charAt(j);
            //     mpp.put(ch, mpp.getOrDefault(ch, 0) + 1);

            //     if(mpp.get(ch) == 1) {
            //         maxLen = Math.max(maxLen, j - i + 1);
            //     }
            //     else if(mpp.get(ch) > 1) {
            //         while(mpp.get(ch) > 1) {
            //             char del = s.charAt(i);
            //             mpp.put(del, mpp.get(del) - 1);

            //             if(mpp.get(del) == 0) {
            //                 mpp.remove(del);
            //             }

            //             i++;
            //         }
            //     }

            //     j++;
            // }

            // return maxLen;

            // return brute(s);
            return optimal(s);
        
    }

    private int optimal(String s) {
        int n = s.length();
        int left = 0, right = 0, maxi = 0;
        HashSet<Character> set = new HashSet<>();

        while(right < n) {
            char ch = s.charAt(right);
            if(!set.contains(ch)) {
                set.add(ch);
                maxi = Math.max(maxi, right - left + 1);
                right++;
            }
            else{
                set.remove(s.charAt(left));
                left++;
            }
        }

        return maxi;
    }


    private int brute(String s) {
        int n = s.length();
        int maxi = 0;

        for(int i = 0; i < n; i++) {
            for(int j = i; j < n; j++) {
                if(allUnique(s, i, j)) {
                    maxi = Math.max(maxi, j - i + 1);
                }
            }
        }

        return maxi;
    }

    private boolean allUnique(String s, int i, int j) {
        HashSet<Character> set = new HashSet<>();

        for(int k = i; k <= j; k++) {
            char ch = s.charAt(k);

            if(set.contains(ch)) {
                return false;
            }

            set.add(ch);
        }

        return true;
    }
}