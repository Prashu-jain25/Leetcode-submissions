class Solution {
    public boolean isValid(String s) {
        Stack<Character> st = new Stack<>();

        for(int i = 0; i < s.length(); i++) {
            char ch = s.charAt(i);

            // push all open brackets into stack
            if(ch == '(' || ch == '[' || ch == '{') {
                st.push(ch);
            }
            else {
                 // not an open bracket and stack don't have any relevent pair 
                if(st.isEmpty()) {
                    return false;
                }
                
                char top = st.pop();

                // stack don't have any relevent pair 
                if((ch == ')' && top != '(') || 
                (ch == ']' && top != '[') || 
                (ch == '}' && top != '{')) {
                    return false;
                }
            }
        }

        return st.isEmpty();
    }
}