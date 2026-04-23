class Solution {
    public int sumSubarrayMins(int[] arr) {
        int n=arr.length;
        int[]nse=new int[n];
        int[]pse=new int[n];
        nse[n-1]=n;
        Stack<Integer> st=new Stack<>();
        st.push(n-1);
        for(int i=n-2;i>=0;i--){
            if(arr[st.peek()]<arr[i]){
                nse[i]=st.peek();
            }else{
                while(!st.isEmpty()&&arr[st.peek()]>arr[i]){
                    st.pop();
                }
                if(st.isEmpty()) nse[i]=n;
                else nse[i]=st.peek();
            }
            st.push(i);
        }
        pse[0]=-1;
        st.clear();
        st.push(0);
        for(int i=1;i<n;i++){
            if(arr[st.peek()]<arr[i]){
                pse[i]=st.peek();
            }else{
                while(!st.isEmpty()&&arr[st.peek()]>=arr[i]){
                    st.pop();
                }
                if(st.isEmpty()) pse[i]=-1;
                else pse[i]=st.peek();
            }
            st.push(i);
        }
        long sum=0;
        int mod=(int)1e9+7;
        for(int i=0;i<n;i++){
            int left=i-pse[i];
            int right=nse[i]-i;
            sum = (sum + (long) left * right * arr[i]) % mod;
        }
        return (int)sum;
    }
}