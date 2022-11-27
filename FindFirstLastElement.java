class Solution {
    
    private int firstbinary(int[] nums,int low, int high,int target){
        while(low <= high){
            int mid = low + (high - low)/2;
            if(nums[mid] == target){
                if(mid == 0 || nums[mid] > nums[mid - 1]){
                    return mid;
                }
                else{
                    high = mid -1;
                }
            }
            else if(nums[mid] > target){
                 high = mid - 1;
             }
             else{
                 low = mid + 1;
             }
            
            
            
        }
        return -1;
    }
    
    private int secondbinary(int[] nums, int low, int high, int target){
         while(low <= high){
            int mid = low + (high - low)/2;
            if(nums[mid] == target){
                if(mid == nums.length-1 || nums[mid] < nums[mid + 1]){
                    return mid;
                }
                else{
                    low = mid + 1;
                }
               
            }
             else if(nums[mid] > target){
                 high = mid - 1;
             }
             else{
                 low = mid + 1;
             }
            
            
        }
        return -1;
    }
    public int[] searchRange(int[] nums, int target) {
     
        int low = 0;
        int high = nums.length -1;
        if(nums == null || nums.length == 0 ) return new int[]{-1,-1};
        if(nums[0] > target || nums[high] < target) return new int[] {-1,-1};
        int first = firstbinary(nums,low,high,target);
        if(first == -1) return new int [] {-1,-1};
        int second = secondbinary(nums,first,high,target);
         if(second == -1) return new int [] {-1,-1};
        return new int [] {first,second};
    }
}


// Time Complexity : O(logn) + O(logn) = O(2logn) -> 2 is constant => O(logn)
// Space Complexity : O(1). Not using any extra Space
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : java syntax, edge cases
// Your code here along with comments explaining your approach

//Here need to find the first and last positions of the element. we can use binary search approach but we cant find first and last element in a single Binary search. So finding first number in first Binary Search and second number in second binary search. Then the TC will be O(logn) + O(logn) which is O(2logn) Here 2 is constant. So, O(logn). 
// Handling Edge Cases : If our mid is in the first Index, we cant compare mid with mid - 1 bcz it will throw outof the bound error. Same with nums.length-1.
// Optimization : After finding first element Index we can use it as low for finding second index. If we dont get first number then no need to find second number, return new int[]{-1,-1} there itself.
