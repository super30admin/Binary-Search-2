// Time Complexity : O(logn)
// Space Complexity : Not sure
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No

public class MinInSortedArray {
    public int findMin(int[] nums) {
        int start = 0, end = nums.length - 1;
        
        if(nums.length == 0)
            return nums[0];
        
        if(nums[end] >= nums[0])
            return nums[0];
        
        while(start <= end){
            int mid = start + (end - start) / 2;
            
            if(nums[mid] > nums[mid + 1])
                return nums[mid+1];
            
            if(nums[mid-1] > nums[mid])
                return nums[mid];
            
            if(nums[mid] > nums[0]){
                start = mid + 1;
            } else {
                end = mid - 1;
            }
        }
        return -1;
    }
}