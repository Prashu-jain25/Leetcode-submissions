class Solution {
    public List<Integer> addToArrayForm(int[] num, int k) {
        LinkedList<Integer> ans = new LinkedList<>();
        int sum = k;
        int i = num.length - 1;

        while(i >= 0 || sum > 0) {
            if(i >= 0) {
                sum += num[i];
                i--;
            }
            ans.addFirst(sum % 10);
            sum = sum / 10;
        }

        return ans;
    }


/* My Brute force = not worked for large cases

 LinkedList<Integer> ans = new LinkedList<>();
        int n = num.length;
        int temp = 1;
        int val = 0;

        // converting array into number
        for(int i = n - 1; i >= 0; i--) {
            val = num[i] * temp + val;
            temp *= 10;
        }

        val = val + k; // add k

        // preparing ans
        while(val > 0) {
            int ld = val % 10;
            ans.addFirst(ld);
            val = val / 10;
        }

        return ans;

*/

}