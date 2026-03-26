class Solution {
    public int minDeletions(String s) {
        int arr[] = new int[26];
        for(char c : s.toCharArray()) arr[c-'a']++;

        int count = 0;
        List<Integer> li = new ArrayList<>();
        for(int i=25; i>=0; i--){
            while(li.contains(arr[i]) && arr[i] > 0){
                arr[i]--;
                count++;
            }
            li.add(arr[i]);
        }
        return count;
    }
}