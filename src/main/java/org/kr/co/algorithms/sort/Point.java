package org.kr.co.algorithms.sort;

public class Point implements Comparable<Point> {
    public int x, y;
    public Point(int x, int y) {
        this.x = x;
        this.y = y;
    }
    @Override
    public int compareTo(Point o) {
        if (this.x == o.x){
            return this.y - o.y;
        }else {
            return this.x - o.x;
        }
    }
}
