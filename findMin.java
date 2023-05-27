//The minmimum always lies in the unsorted array so we find the sorted array and discard it and move to the unsorted array
//we perform a binary search and check mid is less than mid-1 and mid+1
//TIme complexity: O(log n)
//leetcode: 153
class Solution {
    public int findMin(int[] nums) {
        //check for null input and empty array if yes exit
        if (nums == null || nums.length == 0)return -1;
        int n = nums.length;
        int low = 0; int high = n-1;
        while(low<=high)
        {
            //if the array is already sorted and in its original position then return the leftmost element
            if(nums[low]<=nums[high])return nums[low];
            int mid = low + (high-low)/2;
            //if mid-1>mid and mid+1>mid then mid is the lowest element
            //also checks if mid is not firstmost element and the lastmost element in the array
            if((mid == 0 || nums[mid] < nums[mid-1])&&(mid == n-1 || nums[mid] < nums[mid+1]))return nums[mid];
            //if left sorted discard left and move to right
            else if (nums[low] <= nums[mid])
            {
               low = mid+1;
            }
            //if right sorted move to left subarray
            else {
                high = mid-1;
            }
        }
        return -1;

        
    }
}