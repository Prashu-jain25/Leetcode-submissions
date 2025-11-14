  class Pair{
        int r;
        int c;
        int tm;

        public Pair(int r, int c, int tm) {
            this.r = r;
            this.c = c;
            this.tm = tm;
        }

    }



class Solution {
    public int orangesRotting(int[][] grid) {
        int row = grid.length;
        int col = grid[0].length;

        Queue<Pair> q = new LinkedList<>();
        int[][] vis = new int[row][col];
        int cntFresh = 0;

        for(int i = 0; i < row; i++) {
            for(int j = 0; j < col; j++) {
                if(grid[i][j] == 2){
                    q.add(new Pair(i, j, 0));
                    vis[i][j] = 2;
                }
                else{
                    vis[i][j] = 0;
                }

                if(grid[i][j] == 1) {
                    cntFresh++;
                }
            }
        }

        int tm = 0;  // to keep track of time
        int cnt = 0; // count of fresh oranges that became rotten
        int[] dr = {-1, 0, 1, 0};
        int[] dc = {0, 1, 0, -1};

        while(!q.isEmpty()) {
            Pair p = q.poll();
            int r = p.r;
            int c = p.c;
            int t = p.tm;

            tm = Math.max(tm, t);

            for (int i = 0; i < 4; i++) {
                int nr = r + dr[i];
                int nc = c + dc[i];

                if (nr >= 0 && nr < row && nc >= 0 && nc < col
                        && vis[nr][nc] == 0 && grid[nr][nc] == 1) {

                    q.add(new Pair(nr, nc, t + 1));
                    vis[nr][nc] = 2; 
                    cnt++;            
                }
            }
        }

        if (cnt == cntFresh){
            return tm;
        } 

        return -1;

    }
}