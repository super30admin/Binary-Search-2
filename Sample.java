// Time Complexity :
// Space Complexity :
// Did this code successfully run on Leetcode :
// Any problem you faced while coding this :
//Find Minimum in Rotated Sorted Array
//time Complexity -> O(logn)
//Space Complexity -> O(1)
class Solution {
    public int findMin(int[] nums) {
        if(nums == null || nums.length == 0) return -1;

        int low = 0;
        int high = nums.length - 1;

        while(low<=high){
            int mid = low + (high - low)/2; //to avoid integer overflow
            if(nums[low]<nums[high]) return nums[low];
            else if((mid == 0 || nums[mid]<nums[mid-1]) &&
               (mid == nums.length-1 || nums[mid]<nums[mid+1])){
                   return nums[mid];
               }
            else if(nums[low]<=nums[mid]){
                 low = mid + 1;
            }   
            else{
                high = mid - 1;
            }
        }

        return -1;    
        
    }
}

//Find First and Last Position of Element in Sorted Array
//Time Complexity -> O(logn)
//Space Complexity -> O(1)
class Solution {
    public int[] searchRange(int[] nums, int target) {
        if(nums.length == 0 || nums == null ) return new int[]{-1,-1};
        int n = nums.length;

        int firstElement = binarySearchFirst(nums,n,target);
        if(firstElement == -1) return new int[]{-1,-1};
        int secondElement = binarySearchLast(nums,firstElement,n-1,target);
        if(secondElement == -1) return new int[]{-1,-1};
         
         return new int[]{firstElement,secondElement};
        
    }

    private int binarySearchFirst(int[] nums,int n,int target){
        int low = 0;
        int high = n -1 ;
        while(low<=high){
            int mid = low + (high - low)/2;
            if(nums[mid] == target){
                if(mid == low || nums[mid] > nums[mid -1]){
                    return mid;
                    
                }
                else{
                    high = mid - 1;
                }
            }
            else if(nums[mid]>target){
                high = mid -1;
            }
            else{
                low = mid + 1;
            }
        }

        return -1;
    }

    private int binarySearchLast(int[] nums,int low,int high,int target){
        while(low<=high){
            int mid = low + (high - low)/2;
            if(nums[mid] == target){
                if(mid == high || nums[mid] < nums[mid +1]){
                    return mid;
                    
                }
                else{
                    low = mid + 1;
                }
            }
            else if(nums[mid]>target){
                high = mid -1;
            }
            else{
                low = mid + 1;
            }
        }

        return -1;
    }
   
}

//Find Peak Element
//Time Complexity -> O(logn)
//Space Complexity -> O(1)
class Solution {
    public int findPeakElement(int[] nums) {
        if(nums.length == 0 || nums == null) return -1;
        int n = nums.length;
        int low = 0;
        int high = n-1;
        while(low<=high){
            int mid = low +(high -low)/2;
            if((mid == 0 || nums[mid]>nums[mid-1]) && 
            (mid == n-1 || nums[mid]>nums[mid+1])){
                return mid;
            }
            else if(nums[mid]<nums[mid+1]){
                low = mid + 1;
            }
            else{
                high = mid - 1;
            }
        }

        return -1;
        
    }
}