
// Time Complexity :O(logn)
// Space Complexity :O(1)
// Did this code successfully run on Leetcode : yes
// Any problem you faced while coding this : No


// Your code here along with comments explaining your approach


/*
It is a rotated sorted array, which means atleast on side is sorted , we will not traverse the sorted side, as we can check the lowest element there in constant time but we need to go on to the unsorted side
*/
class Solution {
    public int findMin(int[] nums) {

        int min = Integer.MAX_VALUE;
        int low=0;
        int high = nums.length -1;
        int mid =0;
        while(low<=high){
            mid = low + (high - low)/2;

            // check if left sorted
            if(isSorted(nums[low],nums[mid])){ 
                if(nums[low] < min){ // if sorted then low might be pointing to min element
                    min = nums[low];
                }
                low = mid+1; // go right , as we dont need to traverse the left part, we already got what we needed
            }
            else{ // otherwise right is sorted, in that case mid's element might be the smallest
            if(nums[mid] < min){ 
                min = nums[mid];
            }
            high = mid-1; // go left
            }
        }
        return min;
    }


    public boolean isSorted(int min, int max){
        return min<=max;
    }
}