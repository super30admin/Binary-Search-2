/* Approach:search if the array is sorted, if yes return value in 0 index. if not find mid and check if mid is greater than before and next element, 
if yes return mid as pivot, if not check the sorted half and ignore it and move to unsorted half and find mid and continur the 
process till result is returned */

Time Complexity --> O(log n)
Space Complexity --> O(1)

class Solution {

    public int findMin(int[] nums) {

    if (nums == null || nums.length ==0) return -1;
    int n= nums.length;
    int low = 0;
    int high = n - 1;

    while (low <= high){

if (nums[low] <= nums[high]) return nums[low];

     int mid = low+ (high-low)/2 ;
 if ((mid==0 || nums[mid] < nums[mid-1]) && (nums[mid]< nums[mid+1] || mid == n-1))
     {
    return nums[mid];
    }

     else if (nums[low]<=nums[mid]){

         low = mid+1;
     } else{
         high = mid-1;
     }

    }

return 7856236;
        
}
}

