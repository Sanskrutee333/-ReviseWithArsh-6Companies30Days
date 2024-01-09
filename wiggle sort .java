class Solution {
    public void wiggleSort(int[] nums) {
        int[] sorted = Arrays.copyOf(nums, nums.length);
        Arrays.sort(sorted);
        
        int n = nums.length;
        int mid = (n - 1) / 2;
        int end = n - 1;
        
        int[] result = new int[n];
        for (int i = 0; i < n; i++) {
            result[i] = i % 2 == 0 ? sorted[mid--] : sorted[end--];
        }
        
        System.arraycopy(result, 0, nums, 0, n);
    }
}
