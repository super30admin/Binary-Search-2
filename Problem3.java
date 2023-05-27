// Time Complexity : O(log(n)base2), beats 100% of Java submissions
    //n is the size of the array.

// Space Complexity : O(1), beats 96.10% of Java submissions

// Approach :
    //We first find if the peak is at first or last index by comparing them with their adjacent numbers.
    //Then we perform a binary search from second index to second last index.
    //If we are on the positive slope, we move right. Otherwise, we move left.

class Solution {
    public int findPeakElement(int[] nums) 
    {
        int n = nums.length;
        if (n==1 || nums[0]>nums[1])
        {
            return 0;
        }
        if (nums[n-1]>nums[n-2])
        {
            return n-1;
        }
        int low = 1;
        int high = n-2;   
        while(low<=high)
        {
            int mid = low + (high-low)/2;
            if (nums[mid]>nums[mid-1]&&nums[mid]>nums[mid+1])
            {
                return mid;
            }
            else if (nums[mid]<nums[mid+1])
            {
                low = mid+1;
            }
            else
            {
                high = mid-1;
            }
        }
        return -1;
    }
}