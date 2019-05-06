package eg.edu.alexu.csd.datastructure.maze.cs69_cs12_cs21;

import java.io.File;

public class Main {

    public static void main(String[] args) {
        MazeSolver mazeSolver = new MazeSolver();
        int[][] ans = null;
        try {
            ans = mazeSolver.solveDFS(new File("C:\\Users\\Mohanad\\IdeaProjects\\Maze\\dfs.txt"));
        } catch (Exception e) {
            e.printStackTrace();
        }
        if(ans == null)
            return;
        for(int i = 0;i < ans.length;i++)
            System.out.println(ans[i][0] + " " + ans[i][1]);
    }
}
