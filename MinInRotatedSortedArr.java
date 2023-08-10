// Time Complexity : log n
// Space Complexity : O(1)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No


// Your code here along with comments explaining your approach in three sentences only
//  First check if the array is already sorted post rotation, if true return the first element as minimum. If not, then find the mid value, 
// identify the unsorted part with respect to this index and continue performing binary search for the target in the unsorted part for each 
// iteration.

class Solution {
    public int findMin(int[] nums) {
        //  check null conditions

        if(nums==null||nums.length==0) return -1;

        int n = nums.length;
        int low = 0;
        int high = n-1;

        while(low<=high){
            // array already sorted
            if(nums[low]<=nums[high]){
                return nums[low];
            }

            int mid = low+(high - low)/2;
            System.out.println(mid);
            // compare mid with neighbours and bounds to see if it is min
            if((mid==0||nums[mid]<nums[mid-1]) && (mid==n-1||nums[mid]<nums[mid+1])){
                return nums[mid];
            } else if(nums[low]<=nums[mid]){ //left sorted
                low = mid+1;
            } else {          // right sorted
                high = mid-1;
            }
        }

        return -1;
        
    }
}