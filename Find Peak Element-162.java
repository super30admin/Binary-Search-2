class Solution {
    public int findPeakElement(int[] nums) {
// if array is empty
        if(nums==null || nums.length==0)
        {
            return -1;
        }

        int low =0;
        int high = nums.length-1;
        // Binary search
        while(low<=high)
        {
            int mid = low+(high-low)/2; // To prevent Integer Overflow Exception
            // If middle element is the largest amongst its neighbours 
            // Or if the mid element is first or last element the we comapre with -infinity so we return the element itself
            if((mid == low || nums[mid]>nums[mid-1]) && (mid==high ||nums[mid]>nums[mid+1]))
            {
               return mid;
            }
            // If the middle element is greater than element on its right side then move left
            else if (nums[mid]>nums[mid+1])
            {
                high = mid -1;
            }
             // If the middle element is greater than element on its left side then move right
            else {
                low = mid+1;
            }
        }
        return -1;
    }
}
