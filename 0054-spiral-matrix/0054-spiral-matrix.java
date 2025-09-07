class Solution {
    public List<Integer> spiralOrder(int[][] matrix) {
        int m = matrix.length;
        int n = matrix[0].length;
        int leftCol = 0, rightCol = n - 1;
        int upRow = 0, downRow = m - 1;
        List<Integer> list = new ArrayList<>();
        while (leftCol <= rightCol && upRow <= downRow) {
            if (leftCol <= rightCol) {
                for (int i = leftCol; i <= rightCol; i++) {
                    list.add(matrix[upRow][i]);
                }
                upRow++;
            }
            if (upRow <= downRow) {
                for (int i = upRow; i <= downRow; i++) {
                    list.add(matrix[i][rightCol]);
                }
                rightCol--;
            }
            if (upRow <= downRow) {
                for (int i = rightCol; i >= leftCol; i--) {
                    list.add(matrix[downRow][i]);
                }
                downRow--;
            }
            if (leftCol <= rightCol) {
                for (int i = downRow; i >= upRow; i--) {
                    list.add(matrix[i][leftCol]);
                }
                leftCol++;
            }

        }
        return list;
    }
}