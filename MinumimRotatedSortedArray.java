// Time complexity: O(Log N)
// Space complexity: O(1)
// Did this code successfully run on Leetcode : yes
// Any problem you faced while coding this : no

/*
 * method 1: brute force; one loop and min value TC:O(N)
 * method 2: Binary Search 
 * min always lies in the unsorted part
 * we can ignore the other part... 
 */
public class MinumimRotatedSortedArray {
        public int findMin(int[] nums) {
            if(nums== null || nums.length == 0){
                return -1;
            }
    
            int n = nums.length;
            int low=0;
            int high = n-1;
    
            while(low<=high){
                // what if first elem is min
                if(nums[low]<= nums[high]){
                    return nums[low];
                }
                int mid= low+ high-low/2;
                // when mid is the min lement in the array
                if ( (mid==0 || nums[mid]<nums[mid-1]) && ( mid==n-1 || nums[mid]< nums[mid+1]) ){
                    return nums[mid];
                }
                // lift sorted
                else if(nums[low]<=nums[mid]){
                    // move to right part
                    low=mid+1;
                }
                else{// right sorted. so, move to lift part
                    high=mid-1;
                }
            
            }
            return -1;
        }
}
