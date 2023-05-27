// Time Complexity : O(log(n)) as we're halving the search list during each iteration
// Space Complexity : O(1) as we're not using any auxiliary data structure
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this :

class FindPeakIndex
{
    public int findPeakElement(int[] nums)
    {
        int peakIndex = -1;
        if(nums.length == 1)
        {
            return 0;
        }
        if(nums[1] < nums[0])
        {
            return 0;
        }
        else if(nums[nums.length -2] < nums[nums.length -1])
        {
            return nums.length -1;
        }

        int low = 1;
        int high = nums.length -2;

        while(low <= high)
        {
            int mid = low + (high-low)/2;
            if(isPeak(nums, mid))
            {
                return mid;
            }
            else if(nums[mid + 1] > nums[mid])
            {
                //search in the right half
                low = mid +1;
            }
            else
            {
                high = mid -1;
            }
        }

        return peakIndex;
    }

    private boolean isPeak(int[] nums, int i)
    {
        if(nums[i] > nums[i-1] &&
                nums[i] > nums[i+1])
        {
            return true;
        }
        return false;
    }
}