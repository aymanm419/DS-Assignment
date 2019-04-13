import java.awt.*;
import java.util.ArrayList;
import java.util.Arrays;
public class Main implements IPlayersFinder {
    static Point dx[] = {new Point(0,1),new Point(0,-1),new Point(1,0),new Point(-1,0)};
    public void DFS(int x,int y,Component component,int n,int m,Boolean visited[][],String[] photo,int team)
    {
        visited[x][y] = true;
        for(int i = 0;i < 4;i++)
        {
            int nx = x + (int)dx[i].getX();
            int ny = y + (int)dx[i].getY();
            if(nx < 0 || ny < 0 || nx >= n || ny >= m)
                continue;
            if(visited[nx][ny])
                continue;
            if(Character.getNumericValue(photo[nx].charAt(ny)) != team)
                continue;
            component.addPoint(nx,ny);
            DFS(nx,ny,component,n,m,visited,photo,team);
        }
        return;
    }
    public java.awt.Point[] findPlayers(String[] photo,int team,int threshold)
    {

        if(photo.length == 0)
            return null;
        if(photo[0].length() == 0)
            return null;
        Boolean arr[][] = new Boolean[photo.length][photo[0].length()];
        for(int i = 0;i < photo.length;i++)
        {
            for(int j = 0;j < photo[0].length();j++)
                arr[i][j] = false;
        }
        ArrayList<Component> Tmp = new ArrayList<Component>();
        for(int i = 0;i < photo.length;i++)
        {
            for(int j = 0;j < photo[i].length();j++)
            {
                if(Character.getNumericValue(photo[i].charAt(j)) == team && (arr[i][j] == false))
                {
                    Component TempComponent = new Component(i,j,i,j);
                    DFS(i,j,TempComponent,photo.length,photo[0].length(),arr,photo,team);
                    if(TempComponent.area >= threshold)
                        Tmp.add(TempComponent);
                }
            }
        }
        Point ret[] = new Point[Tmp.size()];
        for(int i = 0;i < Tmp.size();i++)
            ret[i] = new Point(Tmp.get(i).minY + Tmp.get(i).maxY + 1,Tmp.get(i).minX + Tmp.get(i).maxX + 1);
        if(Tmp.size() == 0)
            return null;
        Arrays.sort(ret,new Comp());
        return ret;
    }
    public static void main(String[] args)
    {
        String s[] = {
                "8D88888J8L8E888",
                "88NKMG8N8E8JI88",
                "888NS8EU88HN8EO",
                "LUQ888A8TH8OIH8",
                "888QJ88R8SG88TY",
                "88ZQV88B88OUZ8O",
                "FQ88WF8Q8GG88B8",
                "8S888HGSB8FT8S8",
                "8MX88D88888T8K8",
                "8S8A88MGVDG8XK8",
                "M88S8B8I8M88J8N",
                "8W88X88ZT8KA8I8",
                "88SQGB8I8J88W88",
                "U88H8NI8CZB88B8",
                "8PK8H8T8888TQR8"

        };
        Main m = new Main();
        Point ans[] = m.findPlayers(s, 8, 9);
        for(int i = 0;i < ans.length;i++)
            System.out.println(ans[i].getX() + " " + ans[i].getY());
    }
}
