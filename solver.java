public class solver {
    public static void main(String[] args) {
        int maze[][] = {
                { 0, 0, 0, 1 },
                { 1, 0, 1, 1 },
                { 0, 0, 1, 1 },
                { 1, 0, 1, 0 },
                { 1, 0, 0, 0 },
                { 1, 0, 1, 0 }
        };
        // maze, start, start, end, end
        int[][] solution = solveMaze(maze, 0, 0, 5, 3);

        if (solution == null) {
            System.out.println("No solution found.");
        } else {
            // iterate through each element of the array and print it in a formatted manner
            for (int i = 0; i < solution.length; i++) {
                for (int j = 0; j < solution[i].length; j++) {
                    // print each element with a padding of 4 spaces
                    System.out.printf("%4d", solution[i][j]);
                }
                // print a newline character after each row
                System.out.println();
            }
        }
    }

    public static int[][] solveMaze(int[][] maze, int startX, int startY, int endX, int endY) {
        int[][] copy = new int[maze.length][maze[0].length]; // maze2
        for (int i = 0; i < maze.length; i++) {
            System.arraycopy(maze[i], 0, copy[i], 0, maze[i].length);
        }

        if (startX == endX && startY == endY) {
            copy[startX][startY] = 2;
            return copy;
        }

        copy[startX][startY] = 1;

        if (startY < endY && copy[startX][startY + 1] == 0) {
            int[][] result = solveMaze(copy, startX, startY + 1, endX, endY);
            if (result != null) {
                result[startX][startY] = 2;
                return result;
            }
        }

        if (startX < endX && copy[startX + 1][startY] == 0) {
            int[][] result = solveMaze(copy, startX + 1, startY, endX, endY);
            if (result != null) {
                result[startX][startY] = 2;
                return result;
            }
        }

        return null;
    }
}
