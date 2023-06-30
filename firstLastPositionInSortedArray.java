// Time Complexity : log(n) + log(n) --> 2log(n)
// Space Complexity : O(1)
// Did this code successfully run on Leetcode : yes
// Any problem you faced while coding this : no

class FirstLastPositionInSortedArray {
    public int[] searchRange(int[] nums, int target) {
        int len = nums.length;
        int left = 0, right = len-1;
        int[] ans = new int[]{-1,-1};

        while(left <= right){
            int mid = left + (right - left)/2;
            if(nums[mid] == target){
                if(mid == left || nums[mid-1] != target){
                    ans[0] = mid;
                    break;
                }

                right = mid-1;
            }else if(nums[mid] > target){
                right = mid-1;
            }else{
                left = mid+1;
            }
        }

        left = 0; right = len-1;

        while(left <= right){
            int mid = left + (right - left)/2;
            if(nums[mid] == target){
                if(mid == right || nums[mid+1] != target){
                    ans[1] = mid;
                    break;
                }

                left = mid+1;
            }else if(nums[mid] > target){
                right = mid-1;
            }else{
                left = mid+1;
            }
        }

        return ans;
    }
}