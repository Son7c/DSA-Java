class Solution {
    public boolean lemonadeChange(int[] bills) {
        HashMap<Integer,Integer> map=new HashMap<>();
        map.put(5,0);
        map.put(10,0);
        map.put(20,0);
        for(int i:bills){
            if(i==5) map.put(i,map.get(i)+1);
            else if(i==10){
                if(map.get(5)>0){
                    map.put(5,map.get(5)-1);
                    map.put(i,map.get(10)+1);
                }else return false;
            }else{
                if(map.get(10)>0&&map.get(5)>0){
                    map.put(10,map.get(10)-1);
                    map.put(5,map.get(5)-1);
                    map.put(i,map.get(20)+1);
                }else if(map.get(5)>=3){
                    map.put(5,map.get(5)-3);
                    map.put(i,map.get(20)+1);
                }else return false;
            }
        }
        return true;
    }
}