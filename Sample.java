// # Binary-Search-2
// ## Problem 1: (https://leetcode.com/problems/find-first-and-last-position-of-element-in-sorted-array/)
// Time Complexity : 0(log n)
// Space Complexity : 0(1)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : I didnt face any problem while coding this.
class Solution {
    private int binarySearchFirst(int[] nums, int low, int high, int target){
        while(low<=high){
            int mid = low + (high - low)/2;
            if(nums[mid] == target){
               if(mid == 0 || nums[mid] > nums[mid - 1]){
                   return mid;
               }else{
                   high = mid - 1;
               }
            }
             else if(nums[mid] > target){
                   high = mid - 1;
               }else{
                   low = mid + 1;
               } 
            }
        return -1;
        }
    private int binarySearchSecond(int[] nums, int low, int high, int target){
            while(low<=high){
                int mid = low + (high - low)/2;
                if(nums[mid] == target){
                   if (mid == nums.length - 1||nums[mid] < nums[mid + 1] ){
                       return mid;
                   }else{
                       low = mid + 1;
                   }
                }
                 else if(nums[mid] > target){
                       high = mid - 1;
                   }else{
                       low = mid + 1;
                   } 
                }
            return -1;
            }
    
    public int[] searchRange(int[] nums, int target) {
        if(nums.length == 0) return new int[]{-1,-1};
        int low = 0;
        int n = nums.length;
        int high = n - 1;
        //check if the target lesser or greater than the nums[0] & nums[n-1]
        if(nums[low] > target || nums[high] < target) 
            return new int[] {-1,-1};
        
        //To find first index
        int firstIndx = binarySearchFirst(nums, low, high, target);
        if(firstIndx == -1 ){
            return new int[] {-1,-1};
        }
        //To find second index
        int secondIndx = binarySearchSecond(nums, firstIndx, high, target);
        if(secondIndx == -1 ){
            return new int[] {-1,-1};
        }
        return new int[]{firstIndx, secondIndx};
    }
}


// ## Problem 2: (https://leetcode.com/problems/find-minimum-in-rotated-sorted-array/)
// Time Complexity : 0(log n)
// Space Complexity : 0(1)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : I didnt face any problem while coding this.

class Solution {
    public int findMin(int[] nums) {
        if(nums == null || nums.length == 0) return -1;
        int low = 0;
        int n = nums.length;
        int high = n - 1;
        
        while(low <= high){
            //check whole array is sorted
            if(nums[low] <= nums[high]) return nums[low];
            //will calculate the middle, and check adjacent elements are lesser than middle
            int mid = low + (high - low)/2;
            if((mid == 0 || nums[mid] < nums[mid - 1]) && (mid == n - 1 || nums[mid] < nums[mid+1])){
                return nums[mid];
            } //check for the unsorted array
            else if(nums[low] <= nums[mid]){
                low = mid + 1;
            }else{
                high = mid - 1;
            }
        }
        
        return 1;
    }
}

// ## Problem 3: (https://leetcode.com/problems/find-peak-element/)
// Time Complexity : 0(log n)
// Space Complexity : 0(1)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : I didnt face any problem while coding this.

class Solution {
    public int findPeakElement(int[] nums) {
        int n = nums.length;
        int high = n - 1;
        int low = 0;
        while(low <= high){
            int mid = low + (high-low)/2;
            //if mid is the peak, checking with both the adjacent elements - if it is greater
            if((mid == 0 || nums[mid] > nums[mid - 1]) && (mid == n-1 ||nums[mid] > nums[mid + 1])){
                return mid;
            }else{
                //moving towords the greater side
                if(mid > 0 && nums[mid-1] > nums[mid]){
                    high = mid - 1;
                }else{
                    low = mid + 1;
                }
            }
        }
        return low; 
    }
}