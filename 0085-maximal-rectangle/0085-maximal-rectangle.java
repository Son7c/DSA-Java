class Solution {
    public int largestRectangle(int[] arr){
        int n=arr.length;
        int[] nse=new int[n];
        int[] pse=new int[n];
        Stack<Integer> st=new Stack<>();
        for(int i=n-1;i>=0;i--){
            while(!st.isEmpty()&&arr[st.peek()]>=arr[i]) st.pop();
            if(st.isEmpty()) nse[i]=n;
            else nse[i]=st.peek();
            st.push(i);
        }
        st.clear();
        for(int i=0;i<n;i++){
            while(!st.isEmpty()&&arr[st.peek()]>=arr[i]) st.pop();
            if(st.isEmpty()) pse[i]=-1;
            else pse[i]=st.peek();
            st.push(i);
        }
        int ans=0;
        for(int i=0;i<n;i++){
            ans=Math.max(ans,(nse[i]-pse[i]-1)*arr[i]);
        }
        return ans;
    }
    public int maximalRectangle(char[][] matrix) {
        int m=matrix.length,n=matrix[0].length;
        int[] arr=new int[n];
        int ans=0;
        for(int i=0;i<m;i++){
            for(int j=0;j<n;j++){
                if(matrix[i][j]=='1') arr[j]++;
                else arr[j]=0;
            }
            int area=largestRectangle(arr);
            ans=Math.max(ans,area);
        }
        return ans;
    }
}