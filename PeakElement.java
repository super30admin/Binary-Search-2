// Time Complexity : O(n)
// Space Complexity : O(1)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No

// Your code here along with comments explaining your approach in three sentences only

/*
 * Check for every element if it is peak element
 * 
 */
class Solution {
    public int findPeakElement(int[] nums) {
        if(nums.length == 1)
            return 0;
        for(int i = 0; i < nums.length; i++){
            // if it is first or last element then just check with one element
            if(i == 0 && nums[i] > nums[i+1] || i == nums.length -1 && nums[i] > nums[i-1])
                return i;
            else{
                // if not check with both elements
                if(nums[i]>nums[i+1]&&nums[i]>nums[i-1])
                    return i;
            }

        }
        return -1;
    }
}


// Time Complexity : O(logn)
// Space Complexity : O(1)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No

// Your code here along with comments explaining your approach in three sentences only

/*
 * Take low as first element and high as last element. check for mid if left is great or right is great. if right great move right
 * if left is great then move left when you find peak return
 */
class Solution {
    public int findPeakElement(int[] nums) {
        int n = nums.length;
        if(n == 1)
            return 0;
        int low = 0;
        int high = n - 1;
        while(low <= high){
            //initialise mid
            int mid = low + (high - low) / 2;
            // if mid is first or last element just check with one element
            if ((mid == 0 && nums[mid] > nums[mid + 1]) || (mid == n-1 && nums[mid] > nums[mid - 1]))
                return mid;
            else {
                // check if greater than both elements return mid
                if((mid > 0 && nums[mid] > nums[mid -1]) && (mid < n-1 && nums[mid] > nums[mid +1]))
                    return mid;
                // if left great move left
                else if(mid > 0 &&nums[mid - 1] > nums[mid]){
                    high = mid - 1;
                }
                //if right great move right
                else if(mid < n-1 && nums[mid + 1] > nums[mid]){
                    low = mid + 1;
                }
            }
        }
        // no peak return -1
        return -1;
    }
}

// Time Complexity : O(logn)
// Space Complexity : O(1)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No

// Your code here along with comments explaining your approach in three sentences only

/*
 * Take low as first element and high as last element. check for mid if left is great or right is great. if right great move right
 * if left is great then move left when you find peak return
 */
class Solution {
    public int findPeakElement(int[] nums) {
        int n = nums.length;
        if(n == 1)
            return 0;
        int low = 0;
        int high = n - 1;
        while(low <= high){
            int mid = low + (high - low) / 2;
            if ((mid == 0 || nums[mid] > nums[mid - 1]) && (mid == n-1 || nums[mid] > nums[mid + 1]))
                return mid;
            else if(nums[mid + 1] > nums[mid]){
                    low = mid + 1;
                }
            else {
                    high = mid - 1;
                }
            }
        
        return -1;
    }
}

// Time Complexity : O(logn)
// Space Complexity : O(1)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No

// Your code here along with comments explaining your approach in three sentences only

/*
 * Take low as first element and high as last element. check for mid if left is great or right is great. if right great move right
 * if left is great then move left when you find peak return
 */
class Solution {
    public int findPeakElement(int[] nums) {
        int n = nums.length;
        if(n==1)
            return 0;
        int low = 0;
        int high = n - 1;
        while (low < high) {
            int mid = low + (high - low) / 2;
            // since low < high mid is always before last element just check right and shrink left
            if(nums[mid+1] > nums[mid]){
                low = mid + 1;
            }
            else
                high = mid;
            
        }
        //return low
        return low;
    }
}

