class Solution {
    public boolean isValid(String s) {
        Deque<Character> st = new ArrayDeque<>();
        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) == ']') {
                if (!st.isEmpty() && st.peek() == '[') {
                    st.pop();
                } else {
                    return false;
                }
            } else if (s.charAt(i) == '}') {
                if (!st.isEmpty() && st.peek() == '{') {
                    st.pop();
                } else {
                    return false;
                }
            } else if (s.charAt(i) == ')') {
                if (!st.isEmpty() && st.peek() == '(') {
                    st.pop();
                } else {
                    return false;
                }
            } else {
                st.push(s.charAt(i));
            }
        }
        return st.size() == 0;
    }
}
