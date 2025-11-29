class Solution {
    public int orangesRotting(int[][] grid) {
        int row = grid.length;
        int col = grid[0].length;
        int freshCnt = 0;
        Queue<Pair> q = new LinkedList<>();

        // Add all rotten oranges to queue + count fresh ones
        for(int i = 0; i < row; i++) {
            for(int j = 0; j < col; j++) {
                if(grid[i][j] == 2) {
                    q.add(new Pair(i, j));
                }

                if(grid[i][j] == 1) {
                    freshCnt++;
                }
            }
        }

        // no fresh element
        if(freshCnt == 0) {
            return 0; // 0 minutes taken to rott them
        }

        int minutes = -1; // taki jb loop chle to count 0 se start ho
        int[][] dir = {{1, 0}, {-1, 0}, {0, -1}, {0, 1}};

        // go BFS
        while(!q.isEmpty()) {
            int size = q.size();
            minutes++;
            
            // process all rotten oranges in current minute
            for(int i = 0; i < size; i++) {
                Pair curr = q.poll();
                int currR = curr.r;
                int currC = curr.c;

                for(int[] d : dir) {
                    int nr = currR + d[0];
                    int nc = currC + d[1];

                    // valid fresh orange
                    if(nr >= 0 && nc >= 0 && nr < row && nc < col && grid[nr][nc] == 1) {
                        grid[nr][nc] = 2; // rot it
                        freshCnt--; // decrease fresh count
                        q.add(new Pair(nr, nc));
                    }
                }
            }
        }

        // // If some oranges never rotted
        if(freshCnt != 0) {
            return -1;// impossible to rott
        } 

        return minutes;
    }

    class Pair {
        int r; 
        int c;
        public Pair(int r, int c) {
            this.r = r;
            this.c = c;
        }
    }
}