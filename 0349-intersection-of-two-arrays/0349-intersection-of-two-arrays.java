class Solution {
    public int[] intersection(int[] nums1, int[] nums2) {
        int n1 = nums1.length;
        int n2 = nums2.length;
        HashSet<Integer> set = new HashSet<>();
        
        for(int i = 0; i < n1; i++) {
            for(int j = 0; j < n2; j++) {
                if(nums1[i] == nums2[j]) {
                    set.add(nums1[i]);
                    break;
                }
            }
        }

        int n = set.size();

        int[] ans = new int[n];
        int k = 0;

        for(int x : set) {
            ans[k++] = x;
        }

        return ans;
    }
}