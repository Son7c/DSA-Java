class Solution {
    public int[] plusOne(int[] digits) {
        int carry=0;
        int n=digits.length-1;
        int j=digits[n]+1;
        if(j>9){
            carry=1;
            digits[n]=0;
        }else{
            digits[n]=j;
        }
        for(int i=n-1;i>=0;i--){
            if(digits[i]+carry<10){
                digits[i]=digits[i]+carry;
                carry=0;
            }else{
                digits[i]=0;
            }
            
        }
        if(carry>0){
            int arr[]=new int[n+2];
            arr[0]=1;
            for(int i=0;i<=n;i++){
                arr[i+1]=digits[i];
            }
            return arr;
        }
        return digits;
    }
}