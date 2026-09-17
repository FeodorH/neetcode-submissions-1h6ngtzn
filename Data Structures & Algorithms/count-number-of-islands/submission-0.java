class Solution {
    public int numIslands(char[][] grid) {
        int c = 0;
        for(int i = 0;i<grid.length;i++){
            for(int j =0;j<grid[i].length;j++){
                if(grid[i][j]=='0'||grid[i][j]=='2'){
                    continue;
                }
                islandReq(grid,i,j);
                c++;
            }
        }
        return c;
    }
    private void islandReq(char[][]grid,int i, int j){
        if(grid[i][j]=='0'||grid[i][j]=='2'){
            return;
        }
        grid[i][j]='2';
        if(i>0)islandReq(grid,i-1,j);
        if(j>0)islandReq(grid,i,j-1);
        if(i<grid.length-1)islandReq(grid,i+1,j);
        if(j<grid[i].length-1)islandReq(grid,i,j+1);
    }
}
