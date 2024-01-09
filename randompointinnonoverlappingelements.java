import java.util.Random;

class Solution {
    int[][] rects;
    int totalArea;
    Random random;

    public Solution(int[][] rects) {
        this.rects = rects;
        this.totalArea = 0;
        this.random = new Random();

        for (int[] rect : rects) {
            int width = rect[2] - rect[0] + 1;
            int height = rect[3] - rect[1] + 1;
            totalArea += width * height;
        }
    }

    public int[] pick() {
        int randomPoint = random.nextInt(totalArea) + 1; // Add 1 to include the last point in the range
        int currentArea = 0;

        for (int[] rect : rects) {
            int width = rect[2] - rect[0] + 1;
            int height = rect[3] - rect[1] + 1;
            int area = width * height;

            if (currentArea + area >= randomPoint) {
                int pointInRect = random.nextInt(area);
                int x = rect[0] + pointInRect % width;
                int y = rect[1] + pointInRect / width;
                return new int[]{x, y};
            }

            currentArea += area;
        }

        return null; // Shouldn't reach here
    }
}
