import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

class Solution {
    public List<Integer> largestDivisibleSubset(int[] nums) {
        List<Integer> result = new ArrayList<>();
        if (nums == null || nums.length == 0) {
            return result;
        }

        Arrays.sort(nums);

        int n = nums.length;
        int[] dp = new int[n];
        Arrays.fill(dp, 1);

        int maxLen = 1;
        int maxIndex = 0;

        for (int i = 1; i < n; i++) {
            for (int j = 0; j < i; j++) {
                if (nums[i] % nums[j] == 0 && dp[i] < dp[j] + 1) {
                    dp[i] = dp[j] + 1;
                    if (dp[i] > maxLen) {
                        maxLen = dp[i];
                        maxIndex = i;
                    }
                }
            }
        }

        int currNum = nums[maxIndex];
        int currLen = maxLen;

        for (int i = maxIndex; i >= 0; i--) {
            if (currNum % nums[i] == 0 && dp[i] == currLen) {
                result.add(nums[i]);
                currNum = nums[i];
                currLen--;
            }
        }

        return result;
    }

    public static void main(String[] args) {
        Solution solution = new Solution();

        // Example 1
        int[] nums1 = {1, 2, 3};
        System.out.println(solution.largestDivisibleSubset(nums1)); // Output: [1, 2] or [1, 3]

        // Example 2
        int[] nums2 = {1, 2, 4, 8};
        System.out.println(solution.largestDivisibleSubset(nums2)); // Output: [1, 2, 4, 8]
    }
}
