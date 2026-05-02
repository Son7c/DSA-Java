class Solution {
    public int rotatedDigits(int n) {
      int count=0;
      Set<Integer> set2=new HashSet<>();
      for(int i=2;i<=n;i++){
        if(String.valueOf(i).contains("3") || String.valueOf(i).contains("4") || String.valueOf(i).contains("7"))  continue;
        if(String.valueOf(i).contains("2")||String.valueOf(i).contains("5")||String.valueOf(i).contains("6")||String.valueOf(i).contains("9")) count++;
      }  
      return count;
    }
}