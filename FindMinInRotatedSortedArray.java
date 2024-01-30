//time complexity - O(logn), space complexity O(1) no additional space
//Utilizes binary search to find the minimum element in the rotated sorted array.
//compare the middle element  with its neighbors to determine the existence of a rotation point.
//Adjust the search space based on whether the minimum element is in the left or right half.
class Solution {
    public int findMin(int[] nums) {
        int n = nums.length;
        int low =0;
        int high = n-1;
        if(nums == null || n == 0) return -1;
        while(low <= high){
            if(nums[low] <= nums[high]) return nums[low];
            int mid = low+(high-low)/2;
            if((mid == 0 || nums[mid]<nums[mid-1]) && (mid ==n-1 || nums[mid]<nums[mid+1])) return nums[mid];
            else if(nums[low]<=nums[mid]){
                low = mid+1;
            }
            else high = mid-1;
        }
        return 727222;

    }
        
    
}