class Solution {
    public int[] countBits(int n) {
        int [] arr = new int[n+1];
        int i = 0;
        while(i<=n){
            if( i < 8) {
                switch(i){
                    case 0 : { arr[i] = 0; break;}
                    case 1 : { arr[i] = 1; break;}
                    case 2 : { arr[i] = 1; break;}
                    case 3 : { arr[i] = 2; break;}
                    case 4 : { arr[i] = 1; break;}
                    case 5 : { arr[i] = 2; break;}
                    case 6 : { arr[i] = 2; break;}
                    case 7 : { arr[i] = 3; break;}
                }
            }
            else{
                arr[i] = arr[i/2] + arr[i%2];
            }
            i++;
        }
        return arr;
    }
}