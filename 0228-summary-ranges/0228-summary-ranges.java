class Solution {
    public List<String> summaryRanges(int[] arr) {
        List<String> li = new ArrayList<>();
        int n = arr.length;
        if( n == 0 ) return li;

        int i = 0;
        while (i < n) {
            int start = arr[i];
            int j = i;
            while (j + 1 < n && arr[j + 1] == arr[j] + 1) j++;
            if (arr[j] == start) li.add(String.valueOf(start));
            else li.add(start + "->" + arr[j]);
            i = j + 1;
        }
        return li;
    }
}