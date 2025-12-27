// Time Complexity : O(logn)
// Space Complexity :O(1)
// Did this code successfully run on Leetcode :Yes
// Any problem you faced while coding this : same as RotatedArray


// Your code here along with comments explaining your approach in three sentences only
class FindMin {
    public int findMin(int[] nums) {
        int start = 0;
        int end = nums.length -1;
        //if sorted and not rorated return beginning
        if(nums[start]<=nums[end])
        {
            return nums[start];
        }

        while(start<=end)
        {
            int mid = start + ((end-start)/2);
            //found the pivot element
            if (nums[mid]>nums[mid+1])
            {
                return nums[mid + 1];
            }
            //reject the other half,
            // if nums[mid] to nums[end] is sorted, pivot lies first half
            else if(nums[mid]<nums[end])
            {
                end = mid;
            }
            // if nums[start] to nums[mid] is sorted, pivot lies sec half
            else if(nums[start]<nums[mid])
            {
                start = mid + 1;
            }
        }
        return -1;
    }
}