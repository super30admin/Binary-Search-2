class Solution 
{
    public int findPeakElement(int[] nums) 
    {
        int low = 0;
        int high = nums.length-1;
        
        if(nums.length == 1)
            return 0;
        
        while(low <= high)
        {
            
            int middle = low + (high-low)/2;

            if(middle == 0)
            {
                // compare only middleElement with next element
                if(nums[middle+1] < nums[middle])
                {
                    return middle;
                }
                else
                {
                    return middle+1;
                }
            }
            else if(middle == nums.length -1)
            {
                // compare only middleElement with previous element
                if(nums[middle-1]<nums[middle])
                {
                    return middle;
                }
                else
                {
                    return middle-1;
                }
            }
            else
            {
                //compare the middleElement n both the side
                if(nums[middle] > nums[middle+1] && nums[middle] > nums[middle-1])
                {
                    return middle;
                }
                else if(nums[middle] > nums[middle+1])
                {
                    high = middle -1;
                }
                else
                {
                    low = middle + 1;
                }
            }
        }
        
        return Integer.MIN_VALUE;
    }
}