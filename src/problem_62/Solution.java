package problem_62;

import java.awt.*;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;

public class Solution {
    public int uniquePaths(int m, int n) {
        Queue<Point> queue=new LinkedList<>();
        queue.add(new Point(1,1));
        int cnt=0;
        while(!queue.isEmpty()){
            Point p=queue.poll();
            if (p.x==n&&p.y==m)
                cnt++;
            else if (p.x>n||p.y>m)
                continue;
            else{
                    Point down = new Point(p.x, p.y + 1);
                    queue.add(down);
                    Point right = new Point(p.x + 1, p.y);
                    queue.add(right);

            }
        }
        return cnt;
    }

    private int find(int m,int n,int x,int y,int[][] sign){
        if (x==n&&y==m){
            return 1;
        }
        if (x>n||y>m)
            return 0;
        int a,b;
        if (sign[x+1][y]==0){
             a=find(m,n,x+1,y,sign);
            sign[x+1][y]=a;
        }
        else{
            a=sign[x+1][y];
        }
        if (sign[x][y+1]==0){
             b=find(m,n,x,y+1,sign);
            sign[x][y+1]=b;
        }else{
            b=sign[x][y+1];
        }
        return a+b;
    }
    public int uniquePaths2(int m, int n) {
        int[][] sign=new int[105][105];
        int cnt=find(m,n,1,1,sign);
        return cnt;
    }

    public static void main(String[] args) {
        System.out.println(new Solution().uniquePaths2(2,100));
    }
}
