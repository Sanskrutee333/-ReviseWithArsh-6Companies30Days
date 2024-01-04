import java.util.*;

class Solution {
    public int countDistinct(int[] nums, int k, int p) {
        int n = nums.length;
        int ans = 0;
        Set<List<Integer>> subarrays = new HashSet<>();

        for (int i = 0; i < n; i++) {
            int totDiv = 0;
            List<Integer> temp = new ArrayList<>();

            for (int j = i; j < n; j++) {
                temp.add(nums[j]);

                if (nums[j] % p == 0) {
                    totDiv++;
                }

                if (totDiv <= k) {
                    subarrays.add(new ArrayList<>(temp));
                } else {
                    break; // If totDiv exceeds k, no need to continue adding elements to temp
                }
            }
        }
        return subarrays.size();
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        
        int[] nums1 = {2, 3, 3, 2, 2};
        int k1 = 2, p1 = 2;
        System.out.println(solution.countDistinct(nums1, k1, p1)); // Output: 11

        int[] nums2 = {1, 2, 3, 4};
        int k2 = 4, p2 = 1;
        System.out.println(solution.countDistinct(nums2, k2, p2)); // Output: 10
    }
}
