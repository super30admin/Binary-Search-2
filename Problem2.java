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
        int n = nums.length;
        int min = nums[0];
        for (int i=0; i<n; i++)
        {
            if(min>nums[i])
            {
                return nums[i];
            }
        }
        return min;
    }
}