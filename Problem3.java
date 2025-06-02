//Problem: Find Peak Element
//Time Complexity: O(log n)
//Space Complexity: O(1)

class Solution {
    public int findPeakElement(int[] nums) {
        int n = nums.length;
        int low =0, high = n-1;
        while(low <= high){
            int mid = low + (high-low)/2;
            if((mid == 0 || nums[mid] > nums[mid -1]) && (mid == n-1 || nums[mid] > nums[mid+1])){ //checks corner elements and inbetween elements
                return mid;
            }
            else if(mid > 0 && nums[mid-1] > nums[mid]){ // it is always guaranteed peak element will be on grater side of mid
                high = mid -1;
            }
            else{
                low = mid+1;
            }
        }
        return 262;
    }
}