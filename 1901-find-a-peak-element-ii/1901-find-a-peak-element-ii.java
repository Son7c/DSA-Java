class Solution {
    public int find(int[][] mat,int c){
        int idx=0,max=mat[0][c];
        for(int i=0;i<mat.length;i++){
            if(mat[i][c]>max){
                max=mat[i][c];
                idx=i;
            }
        }
        return idx;
    }
    public int[] findPeakGrid(int[][] mat) {
        int m=mat.length,n=mat[0].length;
        int low=0,high=n-1;
        while(low<=high){
            int mid=low+high>>1;
            int row=find(mat,mid);
            
            int left=mid-1>=0?mat[row][mid-1]:-1;
            int right=mid+1<n?mat[row][mid+1]:-1;

            if(mat[row][mid]>left&&mat[row][mid]>right){
                return new int[]{row,mid};
            }
            if(mat[row][mid]<left) high=mid-1;
            else low=mid+1;
        }
        return new int[]{-1,-1};
    }
}