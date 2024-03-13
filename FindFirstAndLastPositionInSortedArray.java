class Solution {

    // TC -> O(logN), where N is length of nums
    // SC -> O(1)
    public int[] searchRange(int[] nums, int target) {
        int[] res = {-1, -1};
        int n = nums.length;
        if(nums == null || n == 0) return res;
        int l = 0, h = n-1, mid = 0;
        // Finding res[0];
        while(l<=h){
            mid = l + (h-l)/2;
            if(nums[mid] == target && (mid == 0 || nums[mid-1]<target)){
                res[0] = mid;
                break;
            }
            else if(nums[mid] >= target)
                h = mid - 1;
            else
                l = mid + 1;
        }
        l = res[0];
        if(l != -1) // For test case [1] and target = 0
        {
            h = n-1;

            // Finding res[1];
            while(l<=h){
                mid = l + (h-l)/2;
                if(nums[mid] == target && (mid == n-1 || nums[mid+1]>target)){
                    res[1] = mid;
                    break;
                }
                else if(nums[mid] <= target)
                    l = mid + 1;
                else
                    h = mid - 1;
            }
        }
        return res;
    }
}
