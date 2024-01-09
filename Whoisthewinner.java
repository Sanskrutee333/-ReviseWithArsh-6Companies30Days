class Solution {
    public int findTheWinner(int n, int k) {
        // Create a list to represent the friends
        List<Integer> friends = new ArrayList<>();
        for (int i = 1; i <= n; i++) {
            friends.add(i);
        }

        // Initialize the index to start counting from
        int index = 0;

        // Continue the elimination process until there is only one friend left
        while (friends.size() > 1) {
            // Calculate the next friend to be eliminated
            index = (index + k - 1) % friends.size();
            // Remove the eliminated friend
            friends.remove(index);
        }

        // Return the remaining friend (the winner)
        return friends.get(0);
    }
}
