class Solution {

    public ArrayList<Integer> rotate(ArrayList<Integer> list, int k) {

        for (int i = 0; i < k; i++) {
            list.add(list.remove(0));
        }

        return list;
    }

    public int[][] rotateGrid(int[][] grid, int k) {

        int m = grid.length;
        int n = grid[0].length;

        int layers = Math.min(m, n) / 2;

        for (int layer = 0; layer < layers; layer++) {

            int rowStart = layer;
            int rowEnd = m - layer - 1;

            int colStart = layer;
            int colEnd = n - layer - 1;

            ArrayList<Integer> list = new ArrayList<>();

            for (int col = colStart; col <= colEnd; col++) {
                list.add(grid[rowStart][col]);
            }

            for (int row = rowStart + 1; row <= rowEnd; row++) {
                list.add(grid[row][colEnd]);
            }

            for (int col = colEnd - 1; col >= colStart; col--) {
                list.add(grid[rowEnd][col]);
            }

            for (int row = rowEnd - 1; row > rowStart; row--) {
                list.add(grid[row][colStart]);
            }

            int rotateBy = k % list.size();

            list = rotate(list, rotateBy);

            int idx = 0;


            for (int col = colStart; col <= colEnd; col++) {
                grid[rowStart][col] = list.get(idx++);
            }

            for (int row = rowStart + 1; row <= rowEnd; row++) {
                grid[row][colEnd] = list.get(idx++);
            }

            for (int col = colEnd - 1; col >= colStart; col--) {
                grid[rowEnd][col] = list.get(idx++);
            }

            for (int row = rowEnd - 1; row > rowStart; row--) {
                grid[row][colStart] = list.get(idx++);
            }
        }

        return grid;
    }
}