/**

34. Find First and Last Position of Element in Sorted Array

Given an array of integers nums sorted in ascending order, find the starting and ending position of a given target value.

If target is not found in the array, return [-1, -1].

Follow up: Could you write an algorithm with O(log n) runtime complexity?


**/

class Solution {

    private final int NOT_FOUND = -1;
    

    private int possibleFirstPosition( int nums[], int target)
    {
        final int START = 0;
        final int END = nums.length -1;
        
        int low = START;
        int high = END;
        int firstPosition = NOT_FOUND;
        
        while ( low <= high ) {
            
            int mid = low + (high -low)/2;
            
            if (nums[mid] == target) firstPosition = mid;
            
            if( nums[mid] >= target ) {
                
                high = mid -1;
            }
            else
            {
                low = mid +1;
            }
        
        }
        return firstPosition;
    
    }
    
    private int possibleLastPosition( int nums[], int target)
    {
        final int START = 0;
        final int END = nums.length -1;
        
        int low = START;
        int high = END;
        int lastPosition = NOT_FOUND;
        
        while ( low <= high ) {
            
            int mid = low + (high -low)/2;
            
            if (nums[mid] == target) lastPosition = mid;
            
            if( nums[mid] <= target ) {
                
                low = mid +1;
            }
            else
            {
                high = mid -1;
            }
        
        }
        return lastPosition;
    
    }
    
    public int[] searchRange(int[] nums, int target) {
        
        if(nums == null || nums.length == 0) return new int[]{NOT_FOUND, NOT_FOUND};
        
    
        int output[] = new int[2];
        
        int firstPosition = this.possibleFirstPosition(nums, target);
        int lastPosition = this.possibleLastPosition(nums, target);
        
        output[0]= firstPosition;
        output[1]= lastPosition;
        
        return output;
        
        
    }
    
    
}