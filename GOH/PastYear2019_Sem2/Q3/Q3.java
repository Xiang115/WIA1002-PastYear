import java.util.*;
import java.io.*;

public class Q3 {

    private static final int[] ROW_MOVES = {-1, 1, 0, 0}; // Up, Down, Left, Right
    private static final int[] COL_MOVES = {0, 0, -1, 1};

    public static void main(String[] args) {
        String file1 = "C:/Users/Goh/Downloads/maze1.txt";
        String file2 = "C:/Users/Goh/Downloads/maze2.txt";
        char[][] maze1;
        char[][] maze2;

        maze1 = ReadFile(file1);
        maze2 = ReadFile(file2);

        System.out.println("The Trieizard Maze1:");
        Print(maze1);
        System.out.println("");
        Result(maze1);
        System.out.println("");
        
        System.out.println("The Trieizard Maze2:");
        Print(maze2);
        System.out.println("");
        Result(maze2);
    }
    
    private static void Result(char[][] maze){
        Stack<int[]> stack = solveMaze(maze);
        if(stack == null){
            System.out.println("Oh no!!! Harry couldn't find the Triwizard Cup!\nSomeone quickly gets professor Dumbledore.");
        }else{
            Path(stack);
        }
    }

    private static char[][] ReadFile(String filename) {
        List<String[]> mazeLines = new ArrayList<>();
        try {
            Scanner sc = new Scanner(new FileInputStream(filename));
            while (sc.hasNext()) {
                mazeLines.add(sc.nextLine().split("\\s+"));
            }
            sc.close();

            char[][] maze = new char[mazeLines.size()][];
            int total = mazeLines.size();

            for (int i = 0; i < total; i++) {
                String[] line = mazeLines.get(i);
                maze[i] = new char[line.length];
                for (int j = 0; j < line.length; j++) {
                    maze[i][j] = line[j].charAt(0);
                }
            }
            return maze;
        } catch (FileNotFoundException ex) {
            return null;
        }
    }

    private static void Print(char[][] maze) {
        for (int i = 0; i < maze.length; i++) {
            for (int j = 0; j < maze[0].length; j++) {
                System.out.print(maze[i][j] + " ");
            }
            System.out.println("");
        }
    }

    private static void Path(Stack<int[]> stack) {
        List<int[]> list = new ArrayList<>();

        while (!stack.isEmpty()) {
            list.add(stack.pop());
        }
        System.out.printf("Hurray!!! Harry found the Triwizard Cup at (%d,%d)\n", list.get(0)[0], list.get(0)[1]);
        System.out.print("This is the path Harry has taken: ");
        //reverse the list;
        for (int i = list.size() - 1; i >= 0; i--) {
            System.out.printf("(%d,%d)", list.get(i)[0], list.get(i)[1]);
            if (i > 0) {
                System.out.print(" > ");
            }
        }
        System.out.println("");
    }

    private static Stack<int[]> solveMaze(char[][] maze) {
        Stack<int[]> stack = new Stack<>();
        Stack<int[]> path = new Stack<>();
        boolean[][] visited = new boolean[maze.length][maze[0].length];
        stack.push(new int[]{0, 0});
        path.push(new int[]{0,0});

        while (!stack.isEmpty()) {
            int[] current = stack.pop();
            int row = current[0];
            int col = current[1];

            // Skip already visited cells
            if (visited[row][col]) {
                path.pop();
                continue;
            }

            // Mark the cell as visited
            visited[row][col] = true;

            if (maze[row][col] == 'C') {
                return path;
            }

            boolean deadEnd = true;

            for (int i = 0; i < 4; i++) {
                int newRow = row + ROW_MOVES[i];
                int newCol = col + COL_MOVES[i];

                if (isSafe(maze, newRow, newCol) && !visited[newRow][newCol] && maze[newRow][newCol] != '0') {
                    stack.push(new int[]{newRow, newCol});
                    path.push(new int[]{newRow, newCol});
                    deadEnd = false;
                }
            }

            // If it's a dead end, remove from path
            if (deadEnd) {
                path.pop();
            }
        }
        return null;
    }

    private static boolean isSafe(char[][] maze, int row, int col) {
        return row >= 0 && row < maze.length && col >= 0 && col < maze[0].length;
    }
}