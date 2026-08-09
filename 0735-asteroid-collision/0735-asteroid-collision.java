class Solution {
    public int[] asteroidCollision(int[] arr) {
        Stack<Integer> st=new Stack<>();
        for(int i=0;i<arr.length;i++){
            

            //collision
            while(!st.isEmpty()&&st.peek()>0&&arr[i]<0){
                if(Math.abs(arr[i])>st.peek()) st.pop();
                else if(Math.abs(arr[i])<st.peek()) arr[i]=0;
                else{
                    st.pop();
                    arr[i]=0;
                }
            }
            if(arr[i]!=0) st.push(arr[i]);
        }
        int[] ans=new int[st.size()];
        int idx=0;
        for(int i:st){
            ans[idx++]=i;
        }
        return ans;
    }
}