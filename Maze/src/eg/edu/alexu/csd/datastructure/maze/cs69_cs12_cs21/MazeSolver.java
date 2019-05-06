package eg.edu.alexu.csd.datastructure.maze.cs69_cs12_cs21;

import java.io.FileReader;
import java.io.IOException;
import java.util.Scanner;

public class MazeSolver implements IMazeSolver {
    /**
     * those 2 arrays are to hold the transition
     * when standing at cell (r,c) one could move to (r + 1,c) or (r - 1,c) or (r, c + 1) or (r, c - 1)
     * so dx[] holds the transition for X while dy[] holds the transition for Y
     */
    private static int dx[] = {1, -1, 0, 0};
    private static int dy[] = {0, 0, 1, -1};

    /**
     * this class is used to simplify matters, it holds each point in (x,y)
     * use point1.Compare(point2) to know if two points are equal or not
     */
    private class Point {
        int x, y;

        Point(int X, int Y) {
            x = X;
            y = Y;
        }

        public boolean compareValue(Point point) {
            return x == point.x && y == point.y;
        }
    }

    /**
     * @param file will be scanned
     * @return this function will scan the file complete,and return an array of string,where each line is return independently
     * for example
     * 5 5
     * ###
     * ...
     * ###
     * would return arrString[3] = {"###" -> zero index
     *                              "..." -> first index
     *                              "###"} -> second index
     * OR throw runtime if the length of matrix is 0
     */
    private String[] fileReader(java.io.File file) {
        FileReader fileReader = null;
        String fileString = "";
        try {
            fileReader = new FileReader(file);
            Scanner scanner = new Scanner(fileReader);
            scanner.nextLine();
            String tmp;
            while (scanner.hasNext()) {
                tmp = scanner.nextLine();
                tmp += "\n";
                fileString += tmp;
            }
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            try {
                if (fileReader != null)
                    fileReader.close();
            } catch (IOException ex) {
                ex.printStackTrace();
            }
        }
        String[] mat = fileString.split("\n");
        if (mat.length == 0 || fileString.length() == 0)
            throw new RuntimeException("Matrix is Empty");
        if (mat[0].length() == 0)
            throw new RuntimeException("Matrix is Empty");
        return mat;
    }

    /**
     * @param matrix
     * @return the position of S in the matrix or runTime if not found
     */
    private Point getStartingPosition(String[] matrix) {
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[0].length(); j++) {
                if (matrix[i].charAt(j) == 'S')
                    return new Point(i, j);
            }
        }
        throw new RuntimeException("No Starting Position found");
    }

    /**
     * @param matrix
     * @return the position of E in the matrix or runtime if not found
     */
    private Point getEndingPosition(String[] matrix) {
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[0].length(); j++) {
                if (matrix[i].charAt(j) == 'E')
                    return new Point(i, j);
            }
        }
        throw new RuntimeException("No Ending Position found");
    }

    public int[][] solveBFS(java.io.File maze) {
        return null;
    }

    /**
     * @param maze maze file
     * @return array of position where arr[i][0] holds the x for the i-th position while arr[i][1] holds the y for the i-th position
     */
    public int[][] solveDFS(java.io.File maze) {
        String[] matrix = null;
        Point start = null, end = null;
        try {
            matrix = fileReader(maze);
            start = getStartingPosition(matrix);
            end = getEndingPosition(matrix);
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
        Point[][] parentNode = new Point[matrix.length][matrix[0].length()];
        boolean[][] visited = new boolean[matrix.length][matrix[0].length()];
        Stack myStack = new Stack();
        myStack.push(start);
        while (!myStack.isEmpty()) {
            Point point = (Point) myStack.pop();
            for (int i = 0; i < 4; i++) {
                int newX = point.x + dx[i];
                int newY = point.y + dy[i];
                if (newX >= 0 && newX < matrix.length && newY >= 0 && newY < matrix[0].length()) {
                    if (visited[newX][newY] || matrix[newX].charAt(newY) == '#')
                        continue;
                    visited[newX][newY] = true;
                    parentNode[newX][newY] = point;
                    myStack.push(new Point(newX, newY));
                }
            }
        }
        if (!visited[end.x][end.y])
            return null;
        myStack.clear();
        while (!start.compareValue(end)) {
            myStack.push(end);
            end = parentNode[end.x][end.y];
        }
        myStack.push(start);
        int[][] wayPoint = new int[myStack.size()][2];
        int counter = 0;
        while (!myStack.isEmpty()) {
            Point point = (Point) myStack.pop();
            wayPoint[counter][0] = point.x;
            wayPoint[counter][1] = point.y;
            counter++;
        }
        return wayPoint;
    }
}
