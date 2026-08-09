class Solution {
    public int sumSubarrayMins(int[] arr) {
        int mod=(int) 1e9+7;
        int n=arr.length;
        Stack <Integer> st=new Stack<>();
        int[] nse=new int[n];
        int[] pse=new int[n];

        //nse
        st.push(n-1);
        nse[n-1]=n;
        for(int i=n-2;i>=0;i--){
            while(!st.isEmpty()&&arr[st.peek()]>=arr[i]) st.pop();
            if(st.isEmpty()){
                nse[i]=n;
            }else{
                nse[i]=st.peek();
            }
            st.push(i);
        }
        st.clear();

        //pse
        st.push(0);
        pse[0]=-1;
        for(int i=1;i<n;i++){
            while(!st.isEmpty()&&arr[st.peek()]>arr[i]) st.pop();
            if(st.isEmpty()){
                pse[i]=-1;
            }else{
                pse[i]=st.peek();
            }
            st.push(i);
        }

        long ans=0l;
        for(int i=0;i<n;i++){
            int left=i-pse[i],right=nse[i]-i;
            ans=(ans+((long) left*right*arr[i])%mod)%mod;
        }
        return (int) ans;
    }
}