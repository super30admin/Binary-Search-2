class Solution {
    public int findMin(int[] nums) {


// If array is null return -1
        if(nums==null || nums.length==0)
        {
            return -1;
        }

        int low = 0;
        int high = nums.length-1;
        while(low<=high)
        {
            if(nums[low]<=nums[high]) // To check if entire array is sorted
            {
                return nums[low]; 
            }
            int mid = low + (high-low)/2; // To prevent integer overflow exception
            if((mid == low || nums[mid]<nums[mid-1]) && ( mid == high ||nums[mid]<nums[mid+1])) // to check if the mid element is the minimum element of the array.
            // The failing case if we remove right part of the if statement[2,1]
            // The failing case if we remove left part of the if statement [1,2,3,4,5]
            {
                return nums[mid]; 
            }
            
            if (nums[low]<=nums[mid])
            {
                // left side of array is sorted. Then check the right unsorted part
                low = mid+1;
            }
            else {
               // right side of array is sorted. Then check the left unsorted part
              high = mid -1;
            }
        }
   return 5577;// Wont ever reach here because there will always be a minimum element
    }
}
