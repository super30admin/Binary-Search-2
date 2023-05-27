// Time Complexity : O(log(n)) as we're halving the search list during each iteration
// Space Complexity : O(1) as we're not using any auxiliary data structure
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this :

class MinRotatedSortedArray
{
    private int minValue; //max value is 5000

    public MinRotatedSortedArray()
    {
        this.minValue = 5001;
    }

    public int findMin(int[] nums)
    {
        int low = 0;
        int high = nums.length -1;

        while(low <= high)
        {
            int mid = low + (high-low)/2;
            if(nums[mid] < minValue)
            {
                minValue = nums[mid];
            }

            if(nums[high] > nums[mid])
            {
                //search the left half
                high = mid -1;
            }
            else
            {
                low = mid +1;
            }
        }

        return minValue;
    }
}