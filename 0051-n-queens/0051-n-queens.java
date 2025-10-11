class Solution {

    public List<List<String>> answer = new ArrayList<>();
    
    public boolean isSafe(char[][] board, int row, int col){
       
        for(int i=row; i>=0; i--){
            if(board[i][col] == 'Q'){
                return false;
            }
        }
        
        for(int i = row-1, j = col-1; i>=0 && j>=0; i-- , j--){
            if(board[i][j] == 'Q'){
                return false;
            }
        }
        
        for(int i=row-1, j=col+1; i>=0 && j<board.length; i--, j++){
            if(board[i][j] == 'Q'){
                return false;
            }
        }

        return true;
    }

    public void addInList(char[][] board){
        List<String> str = new ArrayList<>();
               
        for(char[] row:board){
            str.add(new String(row));
        }

        answer.add(str); 
    }

    public void nQueens(char[][] board, int row ){

        if(row == board.length){
            addInList(board);
            return;
        }

        for(int i=0; i < board.length; i++){
            if(isSafe(board, row, i)){
                board[row][i] = 'Q'; 
                nQueens(board, row+1);
                board[row][i] = '.'; 
            }
        }

    }

    public List<List<String>> solveNQueens(int n) {
        char[][] board = new char[n][n];
        for(char [] row: board){
            Arrays.fill(row, '.');
        }
        nQueens(board, 0);
        return answer;
    }
}