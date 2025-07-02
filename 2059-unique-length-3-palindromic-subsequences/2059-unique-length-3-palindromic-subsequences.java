class Solution {
    public int countPalindromicSubsequence(String s) {
        int[] first = new int[26];
        int[] last = new int[26];
        for (int i = 0; i < 26; i++) {
            first[i] = -1;
            last[i] = -1;
        }
        for (int i = 0; i < s.length(); i++) {
            int index = s.charAt(i) - 'a';
            if (first[index] == -1) {
                first[index] = i;
            }
            last[index] = i;
        }
        Set<String> uniquePalindromes = new HashSet<>();
        for (int i = 0; i < 26; i++) {
            if (first[i] != -1 && last[i] - first[i] > 1) {
                Set<Character> middleCharacters = new HashSet<>();
                for (int j = first[i] + 1; j < last[i]; j++) {
                    middleCharacters.add(s.charAt(j));
                }
                for (char middle : middleCharacters) {
                    uniquePalindromes.add("" + (char) (i + 'a') + middle + (char) (i + 'a'));
                }
            }
        }

        return uniquePalindromes.size();
    }
}