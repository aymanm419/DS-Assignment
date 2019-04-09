
import java.awt.*;
import java.util.*;
import java.lang.*;
import java.io.*;

public class Component
{
    int minX,minY,maxX,maxY;
    int area = 0;
    Component(int minx,int miny,int maxx,int maxy)
    {
        minX = minx;
        minY = miny;
        maxX = maxx;
        maxY = maxy;
        area = 4;
    }
    public void addPoint(int x,int y)
    {
        minX = Math.min(x,minX);
        maxX = Math.max(x,maxX);
        minY = Math.min(y,minY);
        maxY = Math.max(y,maxY);
        area += 4;
    }
}
class Comp implements Comparator<Point>
{
    // Used for sorting in ascending order of
    // roll number
    public int compare(Point a, Point b)
    {
        int Xcompare = Double.compare(a.getX(),b.getX());
        int Ycompare = Double.compare(a.getY(),b.getY());
        if(Xcompare == 0)
            return Ycompare;
        else
            return Xcompare;
    }
}