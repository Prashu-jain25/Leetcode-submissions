class Solution {
    public List<List<String>> groupAnagrams(String[] strs) {
        int n = strs.length;
        
        HashMap<String, List<String>> mpp = new HashMap<>();

        for(String word : strs) {
            char[] ch = word.toCharArray();
            Arrays.sort(ch);
            String key = new String(ch);

            if(!mpp.containsKey(key)) {
                List<String> newList = new ArrayList<>();
                newList.add(word);
                mpp.put(key, newList);
            }
            else {
                mpp.get(key).add(word);
            }

            
        }

        List<List<String>> result = new ArrayList<>(mpp.values());

        return result;
    }
}