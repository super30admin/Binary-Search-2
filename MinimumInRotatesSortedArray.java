/**
Leetcode Problem 153: Find the minimum in a rotated sorted array


Time Complexity : O(logN)
Space Complexity : O(1)
Did this code successfully run on Leetcode : YES
Any problem you faced while coding this : checking some boundary conditions
    
Collabedit: http://collabedit.com/ux3hq

at any point in the rotated sorted array, one side of the array will be sorted and other one
find that element starting such that all the elements from right side of it are sorted and
all the elements from start to left nighbours of that point are sorted

    

**/

class Solution {
    public int findMin(int[] nums) {
        
    final int START = 0;
    final int END = nums.length -1;
    
    
    int low = START;
    int high = END;
    
    // if the input array has only 2 element, the return the minimum of the two     
    if(nums.length ==2) {
        
        return Math.min(nums[0], nums[1]);
    }
    
    
    while ( low < high) 
    {
        
        int mid = low + (high - low)/2;
        
        // if the array under conisderation has only 2 element, then return the minimum of the two    
        if(high-low ==1) {
            return Math.min(nums[low], nums[high]);
        }
        
        if (mid > START && nums[mid] < nums[mid-1]) return nums[mid];
        else if (mid == START && nums[mid] > nums[END]) return nums[mid];
        else if ( nums[mid] < nums[high] ) high = mid -1;
        else low = mid + 1;
        
    }
    
    return nums[low];
        
    }
}

