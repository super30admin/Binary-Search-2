//you will always find the peak if you keep moving towards the element larger than mid
//We check if mid is greater than mid+1 and mid-1 and if statisfies return 
//else we check for the number greater than mid if mid+1 greter then low = mid+1
//else high = mid -1
//TIme complexity = O(log n)
//leetcode num: 162.
class Solution {
    public int findPeakElement(int[] nums) {
        //check for null input and empty arr
        if(nums==null || nums.length==0)return -1;
        int low = 0;  int n = nums.length; int high = n-1;
        while(low <= high)
        {
            int mid = low + (high-low)/2;
            //if mid itself is peak then return mid index
            //check if mid+1 > mid and mid-1>mid
            if((mid==0||nums[mid]>nums[mid-1]) && (mid==n-1||nums[mid]>nums[mid+1]))return mid;
            //if mid is not the first element and the element to the left of mid is greater than mid then move left
            else if(mid>0 && nums[mid-1]>nums[mid])
            {
                high = mid-1;
            }
            //else move to right
            else {
                low = mid + 1;
            }
        }
        return -1;
    }
}