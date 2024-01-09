class Solution {
    public int findTheCity(int n, int[][] edges, int distanceThreshold) {
        int[][] distances = new int[n][n];

        // Initialize distances array with maximum values
        for (int i = 0; i < n; i++) {
            Arrays.fill(distances[i], Integer.MAX_VALUE);
            distances[i][i] = 0;
        }

        // Populate distances array with edge weights
        for (int[] edge : edges) {
            int from = edge[0];
            int to = edge[1];
            int weight = edge[2];
            distances[from][to] = weight;
            distances[to][from] = weight;
        }

        // Floyd-Warshall algorithm to find shortest paths
        for (int k = 0; k < n; k++) {
            for (int i = 0; i < n; i++) {
                for (int j = 0; j < n; j++) {
                    if (distances[i][k] != Integer.MAX_VALUE && distances[k][j] != Integer.MAX_VALUE) {
                        distances[i][j] = Math.min(distances[i][j], distances[i][k] + distances[k][j]);
                    }
                }
            }
        }

        int minCities = n + 1;
        int result = -1;

        // Check the number of reachable cities for each city
        for (int i = 0; i < n; i++) {
            int reachableCities = 0;

            for (int j = 0; j < n; j++) {
                if (distances[i][j] <= distanceThreshold) {
                    reachableCities++;
                }
            }

            if (reachableCities <= minCities) {
                minCities = reachableCities;
                result = i;
            }
        }

        return result;
    }
}
