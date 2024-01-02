import java.util.ArrayList;
import java.util.List;

class Solution {
    public List<List<Integer>> combinationSum3(int k, int n) {
        List<List<Integer>> result = new ArrayList<>();
        List<Integer> currentCombination = new ArrayList<>();
        backtrack(result, currentCombination, k, n, 1);
        return result;
    }

    private void backtrack(List<List<Integer>> result, List<Integer> currentCombination, int k, int remainingSum, int start) {
        if (currentCombination.size() == k && remainingSum == 0) {
            result.add(new ArrayList<>(currentCombination));
            return;
        }

        for (int i = start; i <= 9; i++) {
            currentCombination.add(i);
            backtrack(result, currentCombination, k, remainingSum - i, i + 1);
            currentCombination.remove(currentCombination.size() - 1);
        }
    }
}
