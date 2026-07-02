class Solution {
    public int compareVersion(String version1, String version2) {
        String[] a=version1.split("\\.");
        String[] b=version2.split("\\.");
        int i=0,j=0;
        int m=a.length;
        int n=b.length;
        while(i<m&&j<n){
            int x=Integer.parseInt(a[i]);
            int y=Integer.parseInt(b[j]);
            if(x==y){
                i++;
                j++;
            }
            else if(x<y) return -1;
            else if(x>y) return 1;
        }
        while(i<m){
            int x=Integer.parseInt(a[i]);
            if(x==0) i++;
            else if(x>0) return 1;
        }
        while(j<n){
            int y=Integer.parseInt(b[j]);
            if(y==0) j++;
            else if(y>0) return -1;
        }
        return 0;
    }
}