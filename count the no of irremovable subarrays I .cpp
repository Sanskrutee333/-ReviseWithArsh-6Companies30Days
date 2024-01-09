typedef long long int ll;

class Solution {
public:
    long long incremovableSubarrayCount(vector<int>& nums) {
        int n = nums.size();
        
        int lft = 0;
        int rgt = n-1;
        while (lft+1 < n && nums[lft] < nums[lft+1]) lft ++;
        while (rgt > 0   && nums[rgt-1] < nums[rgt]) rgt --;
        
        ll ans = (lft == n-1)? 0 : 1 + (n - rgt);
        for (int i = 0; i <= lft; i ++) {
            int valid_start = upper_bound(nums.begin()+rgt, nums.end(), nums[i]) - nums.begin();
            ans += (n - valid_start + 1);
        }
        return ans;
    }
};
