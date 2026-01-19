/*
    R6: 9/1/25, couldn't think the genius soln very clearly
    marked ptal-impl since this is a very common pattern

    R5: 10/13/24, could do the genius soln, even cleaner!
    Note: with the same steps as in // A, but in reverse, we can get
    it back to original array, so no need ever to create extra space !!!
    // B - genius and so clean!
*/
/***
IMP !!! main trick used here saves space and obviates need to create the
(m+1)*(n+1) array. this should be useful in all matrix prefix sum questions.

ALSO, i wasn't sure if i did O(mn) time before, but thinking about it more
it is O(mn). no need to do binary search since we always incr maxSide.
*/

/***
R1: 8/26. Should revise, lots of neat tricks
EPIC - PREFIX SUM
LOTS OF TRICKS
DID IT WITHOUT EXTRA SPACE
T: O(m*n) // 
S: O(1) - no extra space, otherwise could be O(m*n)
*/

class Solution {
    public int maxSideLength(int[][] mat, int threshold) {
        int rows = mat.length, cols = mat[0].length;

        // A: transform it into a prefix sum arr
        for (int i = 0 ; i < rows ; i++) {
            for (int j = 1 ; j < cols ; j++) {
                mat[i][j] += mat[i][j-1];
            }
        }
        for (int i = 1 ; i < rows ; i++) {
            for (int j = 0 ; j < cols ; j++) {
                mat[i][j] += mat[i-1][j];
            }
        }
        
        int maxDiagLen = 0;
        for (int i = 0 ; i < rows ; i++) {
            for (int j = 0 ; j < cols ; j++) {
                for (int diagLen = maxDiagLen + 1 ; i + 1 - diagLen >= 0 && j + 1 - diagLen >= 0 ; diagLen++) {
                    // B
                    int iPrev = i - diagLen, jPrev = j - diagLen;

                    // B
                    int topLeft = iPrev >= 0 && jPrev >= 0 ? mat[iPrev][jPrev] : 0;
                    int left = jPrev >= 0 ? mat[i][jPrev] : 0;
                    int top = iPrev >= 0 ? mat[iPrev][j] : 0;

                    int sum = mat[i][j] + topLeft - top - left;
                    if (sum <= threshold) {
                        maxDiagLen = diagLen;
                    } else {
                        break;
                    }
                }
            }
        }
        
        return maxDiagLen;
    }
}


/*
1 2 3
4 5 6
    
1 3 6
4 9 15

1 3  6
5 12 21


1 1 3
1 1 3
1 1 3

1 2 5
1 2 5
1 2 5

1 2 5
2 4 10
3 6 15


1 2 5
1 2 5
1 2 5

    0 1 2
0    1 2 5
1    2 4 10
2    3 6 15
*/