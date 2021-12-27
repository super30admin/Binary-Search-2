// Time Complexity :O(log(n))
// Space Complexity : O(1)
// Did this code successfully run on Leetcode :Yes
// Any problem you faced while coding this : No Problems faced


// Your code here along with comments explaining your approach

class Problem2 {
    public int findMin(int[] nums) {
        if(nums.length ==1)
            return nums[0];
        int left = 0, right = nums.length-1;
        if(nums[right] > nums[0])
            return nums[0];
        while(left<=right){
            int mid = left+(right-left)/2;
            if(nums[mid] > nums[mid+1])
                return nums[mid+1];
            if(nums[mid-1]> nums[mid])
                return nums[mid];
            if(nums[mid]>nums[0])
                left = mid+1;
            else
                right = mid-1;
        }
        return -1;
    }
}