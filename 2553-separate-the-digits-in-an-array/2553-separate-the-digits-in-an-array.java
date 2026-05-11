class Solution {
    public int[] separateDigits(int[] nums) {
        ArrayList<Integer> list=new ArrayList<>();
        for(int i=nums.length-1;i>=0;i--){
            int num=nums[i];
            while(num>0){
                list.add(num%10);
                num=num/10;
            }
        }
        int arr[]=new int[list.size()];
        for(int i=list.size()-1;i>=0;i--){
            arr[Math.abs(i-list.size()+1)]=list.get(i);
        }
        return arr;
    }
}