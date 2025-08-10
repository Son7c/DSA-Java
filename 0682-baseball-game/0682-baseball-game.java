class Solution {
    public int calPoints(String[] operations) {
        Stack<Integer> st=new Stack<>();
        ArrayList<Integer>list=new ArrayList<>();
        for(String str:operations){
            if(str.equals("C")&&!st.isEmpty()&&list.size()>0){
                st.pop();
                list.remove(list.size()-1);
            }
            else if(str.equals("D")){
                int a=st.peek();
                list.add(a*2);
                st.push(a*2);
            }
            else if(str.equals("+")){
                int a=st.pop();
                int b=st.peek();
                st.push(a);
                list.add(a+b);
                st.push(a+b);
            }
            else{
                int num=Integer.parseInt(str);
                st.push(num);
                list.add(num);
            }
        }
        int sum=0;
        for(Integer i:list){
            sum+=i;
        }
        return sum;
    }
}