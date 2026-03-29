class Solution {
    public static boolean isValidSudoku(char[][] board) {
        Set<Character>rows=new HashSet<>();
        Set<Character>cols=new HashSet<>();
        Set<Character>squares=new HashSet<>();
        for(int i =0;i<board.length;i++){
            for(int j =0;j<board.length;j++){
                if(board[i][j]!='.'){
                    if(!rows.contains(board[i][j])){
                        rows.add(board[i][j]);
                    }else {
                        //System.out.println("1 "+i+" "+j);
                        return false;
                    }
                }
                if(board[j][i]!='.'){
                    if(!cols.contains(board[j][i])){
                        cols.add(board[j][i]);
                    }else {
                        //System.out.println("2 "+i+" "+j);
                        return false;
                    }
                }
                if(i%3==0&&j%3==0){
                    for(int a = 0;a<3;a++){
                        for(int b =0;b<3;b++){
                            if(board[i+a][j+b]!='.') {
                                if (!squares.contains(board[i + a][j + b])) {
                                    squares.add(board[i + a][j + b]);
                                } else {
                                    //System.out.println("3 " + i + a + " " + j + b);
                                    return false;
                                }
                            }
                        }
                    }
                    squares.clear();
                }
            }
            rows.clear();
            cols.clear();
        }
        return true;
    }
}