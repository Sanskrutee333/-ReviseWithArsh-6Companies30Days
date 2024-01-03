import java.util.LinkedList;
import java.util.Queue;

class Solution {
    public int[][] highestPeak(int[][] isWater) {
        int m = isWater.length;
        int n = isWater[0].length;

        int[][] heights = new int[m][n];
        Queue<int[]> queue = new LinkedList<>();

        // Initialize the queue with water cells and set their height to 0
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (isWater[i][j] == 1) {
                    queue.offer(new int[]{i, j});
                    heights[i][j] = 0;
                } else {
                    heights[i][j] = -1; // Mark land cells as unvisited
                }
            }
        }

        // Perform BFS to assign heights to land cells
        int[][] directions = {{0, 1}, {1, 0}, {0, -1}, {-1, 0}};
        while (!queue.isEmpty()) {
            int[] current = queue.poll();
            int x = current[0];
            int y = current[1];

            for (int[] dir : directions) {
                int newX = x + dir[0];
                int newY = y + dir[1];

                if (newX >= 0 && newX < m && newY >= 0 && newY < n && heights[newX][newY] == -1) {
                    heights[newX][newY] = heights[x][y] + 1;
                    queue.offer(new int[]{newX, newY});
                }
            }
        }

        return heights;
    }
}
