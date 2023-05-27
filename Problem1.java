// Time Complexity : O(log(n)base2), beats 100% of Java submissions
    //n is the size of the array.

// Space Complexity : O(1), beats 95.95% of Java submissions

// Approach :
    //We perform 2 binary searches.
    //First search is to find the first occurrence.
    //Second search is to find the last occurrence.

class Solution {
    public int[] searchRange(int[] nums, int target) 
    {
        int[] ans = new int[2];
        ans[0] = -1;
        ans[1] = -1;
        int low = 0, high = nums.length-1;
        //finding the first occurrence
        while(low<=high)
        {
            int mid = low + (high-low)/2;
            if (nums[mid]==target)
            {
                if (mid==0)
                {
                    ans[0] = 0;
                    break;
                }
                else if (nums[mid-1]<target)
                {
                    ans[0] = mid;
                    break;
                }
                else
                {
                    high = mid-1;
                }
            }
            else if (nums[mid]<target)
            {
                low = mid+1;
            }
            else
            {
                high = mid-1;
            }
        }   
        //finding the last occurrence
        low = 0;
        high = nums.length-1;
        while(low<=high)
        {
            int mid = low + (high-low)/2;
            if (nums[mid]==target)
            {
                if (mid==nums.length-1)
                {
                    ans[1] = nums.length-1;
                    break;
                }
                else if (nums[mid+1]>target)
                {
                    ans[1] = mid;
                    break;
                }
                else
                {
                    low = mid+1;
                }
            }
            else if (nums[mid]<target)
            {
                low = mid+1;
            }
            else
            {
                high = mid-1;
            }
        }
        return ans;
    }
}