class Solution {
    public int maximumGain(String s, int x, int y) {
        if (x > y) {
            return remove(s, "ab", x, "ba", y);
        } else {
            return remove(s, "ba", y, "ab", x);
        }
    }

    private int remove(String s, String firstPair, int firstScore, String secondPair, int secondScore) {
        Stack<Character> stack = new Stack<>();
        int score = 0;

        // Remove first type (higher score)
        for (char c : s.toCharArray()) {
            if (!stack.isEmpty() && stack.peek() == firstPair.charAt(0) && c == firstPair.charAt(1)) {
                stack.pop();
                score += firstScore;
            } else {
                stack.push(c);
            }
        }

        // Build remaining string from stack
        StringBuilder remaining = new StringBuilder();
        while (!stack.isEmpty()) {
            remaining.append(stack.pop());
        }
        s = remaining.reverse().toString();

        // Remove second type (lower score)
        stack.clear();
        for (char c : s.toCharArray()) {
            if (!stack.isEmpty() && stack.peek() == secondPair.charAt(0) && c == secondPair.charAt(1)) {
                stack.pop();
                score += secondScore;
            } else {
                stack.push(c);
            }
        }

        return score;
    }
}
