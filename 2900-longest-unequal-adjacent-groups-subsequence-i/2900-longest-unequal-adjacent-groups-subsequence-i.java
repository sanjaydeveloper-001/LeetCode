class Solution {
    public List<String> getLongestSubsequence(String[] words, int[] groups) {
        List<String> result = new ArrayList<>();
        int lastGroup = -1;
        for(int i = 0; i < groups.length; ++i) {
            if(lastGroup != groups[i]) {
                result.add(words[i]);
                lastGroup = groups[i];
            }
        }
        return result;
    }

    // public List<String> getLongestSubsequence(String[] words, int[] groups) {
    //     int n = words.length;
    //     int[] length = new int[n];
    //     int[] prev = new int[n];
        
    //     for (int i = 0; i < n; i++) {
    //         length[i] = 1;  // каждый элемент сам по себе
    //         prev[i] = -1;
    //     }
        
    //     for (int i = 0; i < n; i++) {
    //         for (int j = 0; j < i; j++) {
    //             if (groups[i] != groups[j] && length[j] + 1 > length[i]) {
    //                 length[i] = length[j] + 1;
    //                 prev[i] = j;
    //             }
    //         }
    //     }
        
    //     int maxIndex = 0;
    //     for (int i = 1; i < n; i++) {
    //         if (length[i] > length[maxIndex]) {
    //             maxIndex = i;
    //         }
    //     }
        
    //     List<String> result = new ArrayList<>();
    //     int current = maxIndex;
    //     Stack<String> stack = new Stack<>();
        
    //     while (current != -1) {
    //         stack.push(words[current]);
    //         current = prev[current];
    //     }
        
    //     while (!stack.isEmpty()) {
    //         result.add(stack.pop());
    //     }        
    //     return result;
    // }
}