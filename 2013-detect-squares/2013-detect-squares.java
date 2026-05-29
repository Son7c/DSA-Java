class DetectSquares {
    List<int[]> list;
    Map<String,Integer>map;
    public DetectSquares() {
        list=new ArrayList<>();
        map=new HashMap<>();
    }
    
    public void add(int[] point) {
        String str=point[0]+","+point[1];
        list.add(point);
        map.put(str,map.getOrDefault(str,0)+1);
    }
    
    public int count(int[] point) {
        int total=0;
        for(int[] coor:list){
            int px=coor[0],py=coor[1];
            int x=point[0],y=point[1];
            if(px==x||py==y||Math.abs(px-x)!=Math.abs(py-y)) continue;
            total+=map.getOrDefault(x+","+py,0)*map.getOrDefault(px+","+y,0);
        }
        return total;
    }
}

/**
 * Your DetectSquares object will be instantiated and called as such:
 * DetectSquares obj = new DetectSquares();
 * obj.add(point);
 * int param_2 = obj.count(point);
 */