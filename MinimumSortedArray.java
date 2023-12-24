// Time Complexity : O(logn)
// Space Complexity : O(1) 
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No

public class MinimumSortedArray {
    public int findMin(int[] nums) {
        if(nums == null)
            return -1;
        int low = 0;
        int high = nums.length -1;
        int mid = 0;
        int n = nums.length;
        while(low <=high)
        {
            if(nums[low]< nums[high])
                return nums[low];
            mid = low + (high -low)/2;
            if(mid == 0 || nums[mid]< nums[mid -1] && 
            (mid == n-1 || nums[mid] < nums[mid+1]))
            {
                return nums[mid];
            }
            else if(nums[low] <= nums[mid])
            {
                low = mid +1;
            }
            else
            {
                high = mid -1;
            }
        }
    return -1;
    }
    public static void main(String[] args)
    {
        int [] nums = {3,4,5,1,2};
        MinimumSortedArray m = new MinimumSortedArray();
        System.out.println(m.findMin(nums));
    }
}
