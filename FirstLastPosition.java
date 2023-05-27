class Solution {
    public int[] searchRange(int[] nums, int target) {
        int high = nums.length-1;
        int low =0;
        int mid = 0;

        if (low > high)
        {
            return  new int[] {-1,-1};
        }
        while (low <= high)
        {
            
            mid = low + (high-low)/2;

            if (nums[mid] == target)
            {
                
                if (low == high && nums[low]==target)
                {
                    
                    return new int[] {low, high};
                }
                
                if(nums[mid+1] ==target && (mid+1)<=high)
                {
                    return new int[] {mid, mid+1};
                }
                else if((mid-1)>=low)
                {
                if (nums[mid-1] ==target )
                {
                    return new int[] {mid-1, mid};
                }
            }
                else 
                {
                    return new int[] {mid, mid};
                }
            }
            else if ( nums[mid]<=target)
            {
                low = mid +1;
            }
            else if (nums[mid] >= target)
            {
                high = mid -1;
            }
        }
        return new int[] {-1,-1};
    }
}