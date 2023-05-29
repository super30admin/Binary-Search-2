/*Time complexity: O(logn) */

class Solution {
    public int findPeakElement(int[] nums) {
        int n = nums.length;
        int low = 0; int high = n - 1;
       while(low < high){ 
           int mid = low +(high - low)/2;
           // checking if mid is peak
           if((mid == 0 || nums[mid] > nums[mid-1]) 
              && (mid == n-1 || nums[mid] > nums[mid +1])){
               return mid;
           } else if(mid > 0 && nums[mid-1] > nums[mid]){
               //move towards
               high = mid;
           } else {
               low = mid + 1;
           }
       }
        return high;
    }
}