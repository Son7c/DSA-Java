class Solution {
    class Coor implements Comparable <Coor>{
        int x;
        int y;
        float dist;
        Coor(int x,int y,float dist){
            this.x=x;
            this.y=y;
            this.dist=dist;
        }
        @Override
        public int compareTo(Coor c2){
            return Float.compare(this.dist, c2.dist);
        }
    }
    public int[][] kClosest(int[][] points, int k) {
        PriorityQueue <Coor> pq=new PriorityQueue<>();
        for(int i=0;i<points.length;i++){
            float dist=(float)Math.sqrt(Math.pow(points[i][1],2)+Math.pow(points[i][0],2));
            pq.add(new Coor(points[i][0],points[i][1],dist));
        }
        int[][] arr=new int[k][2];
        for(int i=0;i<k;i++){
            Coor temp=pq.remove();
            arr[i][0]=temp.x;
            arr[i][1]=temp.y;
        }
        return arr;
    }
}