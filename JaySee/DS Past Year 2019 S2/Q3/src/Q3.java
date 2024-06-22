import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

/*  
    Here is a bright idea, you pray to whoever is all mighty and powerful in your religion 
    that a question like this will not be given. Not only it is hard to understand, but it
    is too time consuming for a 3 and a half hour test. Just doing the frames without 
    debugging took 3 hours (including procrastination).
*/
public class Q3 {
    private static final int PATH = 1;
    private static final int DEAD_END = 0;
    private static final char CUP = 'C';

    public static void main(String[] args) {
        int[][] maze = readMaze("C:\\Users\\limte\\Desktop\\Visual Studio Code Projects\\VS Code Java\\DS Past Year\\DS Past Year 2019 S2\\Q3\\maze.txt");
        if (maze == null) {
            System.out.println("Error reading the maze.");
            return;
        }
        
        printMaze(maze);
        findCup(maze);
    }

    private static int[][] readMaze(String filename) {
        List<int[]> mazeList = new ArrayList<>();
        try (BufferedReader br = new BufferedReader(new FileReader(filename))) {
            String line;
            while ((line = br.readLine()) != null) {
                String[] tokens = line.split(" ");
                int[] row = new int[tokens.length];
                for (int i = 0; i < tokens.length; i++) {
                    if (tokens[i].equals("1")) {
                        row[i] = PATH;
                    } else if (tokens[i].equals("0")) {
                        row[i] = DEAD_END;
                    } else if (tokens[i].equals("C")) {
                        row[i] = CUP;
                    }
                }
                mazeList.add(row);
            }
        } catch (IOException e) {
            e.printStackTrace();
            return null;
        }

        int[][] maze = new int[mazeList.size()][];
        for (int i = 0; i < mazeList.size(); i++) {
            maze[i] = mazeList.get(i);
        }
        return maze;
    }

    private static void printMaze(int[][] maze) {
        System.out.println("The Triwizard Maze:");
        for (int[] row : maze) {
            for (int cell : row) {
                if (cell == PATH) {
                    System.out.print("1 ");
                } else if (cell == DEAD_END) {
                    System.out.print("0 ");
                } else if (cell == CUP) {
                    System.out.print("C ");
                }
            }
            System.out.println();
        }
    }

    private static void findCup(int[][] maze) {
        int rows = maze.length;
        int cols = maze[0].length;
        boolean[][] visited = new boolean[rows][cols];
        Stack<int[]> path = new Stack<>();
        
        path.push(new int[]{0, 0});
        visited[0][0] = true;

        while (!path.isEmpty()) {
            int[] current = path.peek();
            int x = current[0];
            int y = current[1];

            if (maze[x][y] == CUP) {
                printSuccess(path);
                return;
            }

            boolean moved = false;
            int[][] directions = {{0, 1}, {1, 0}, {0, -1}, {-1, 0}};
            for (int[] dir : directions) {
                int newX = x + dir[0];
                int newY = y + dir[1];

                if (newX >= 0 && newX < rows && newY >= 0 && newY < cols && maze[newX][newY] != DEAD_END && !visited[newX][newY]) {
                    path.push(new int[]{newX, newY});
                    visited[newX][newY] = true;
                    moved = true;
                    break;
                }
            }

            if (!moved) {
                path.pop();
            }
        }

        System.out.println("! Oh no!!! Harry couldn't find the Triwizard Cup! Someone quickly gets Professor Dumbledore.");
    }

    private static void printSuccess(Stack<int[]> path) {
        System.out.println("Hurray!!! Harry found the Triwizard Cup at (" + path.peek()[0] + "," + path.peek()[1] + ")");
        System.out.print("This is the path Harry has taken: ");
        List<int[]> pathList = new ArrayList<>();
        while (!path.isEmpty()) {
            pathList.add(0, path.pop());
        }
        for (int[] step : pathList) {
            System.out.print("(" + step[0] + "," + step[1] + ") ");
        }
        System.out.println();
    }
}

class Stack<T> {
    private Node<T> top;
    private int size;

    private static class Node<T> {
        private T data;
        private Node<T> next;

        public Node(T data) {
            this.data = data;
            this.next = null;
        }
    }

    public Stack() {
        top = null;
        size = 0;
    }

    public void push(T data) {
        Node<T> newNode = new Node<>(data);
        newNode.next = top;
        top = newNode;
        size++;
    }

    public T pop() {
        if (isEmpty()) {
            throw new RuntimeException("Stack is empty");
        }
        T data = top.data;
        top = top.next;
        size--;
        return data;
    }

    public T peek() {
        if (isEmpty()) {
            throw new RuntimeException("Stack is empty");
        }
        return top.data;
    }

    public boolean isEmpty() {
        return top == null;
    }

    public int getSize() {
        return size;
    }
}
