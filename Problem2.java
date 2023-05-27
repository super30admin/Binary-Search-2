// Time Complexity : O(log(n)base2), beats 100% of Java submissions
    //n is the size of the array.

// Space Complexity : O(1), beats 100% of Java submissions

// Approach :
    //A rotated array has 2 sorted subarrays partitioned by the smallest or the largest number of the array.
    //While we are performing the binary search, we compare the middle indexed number with the first number of the array.
    //If it is smaller than the first number, we are in the second subarray. We move left. Otherwise, we are in the first subarray. We move right.

class Solution {
    public int findMin(int[] nums) 
    {
        int low = 0;
        int high = nums.length-1;
        while(low<=high)
        {
            int mid = low + (high-low)/2;
            if (nums[mid]<nums[0])
            {
                if (nums[mid]<nums[mid-1])
                {
                    return nums[mid];
                }
                high = mid-1;
            }
            else
            {
                low = mid+1;
            }
        }   
        return nums[0];
    }
}