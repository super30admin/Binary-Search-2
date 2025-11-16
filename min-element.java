// Time Complexity : O(logn)
// Space Complexity :O(1)
// Did this code successfully run on Leetcode :yes
// Any problem you faced while coding this :None

// Your code here along with comments explaining your approach in three sentences only
// do binary search to find min element
// the main condition is if mid < mid-1 and mid < mid + 1
// check which side is sorted and move the opposite side of the sorted part as the min lie there

class Solution {
    public int findMin(int[] nums) {
        int n = nums.length-1;
        int low = 0;
        int high = n;
        while (low<= high){
            if (nums[low]<= nums[high]){
                return nums[low];
            }
            int mid = low + (high-low)/2;
            if((mid == 0 || nums[mid] < nums[mid-1]) && (mid == n || nums[mid] < nums[mid+1])){
                return nums[mid];
            }
            else if (nums[low] <= nums[mid]){
                low = mid + 1;
            }else{
                high = mid -1;
            }
        }
        return 77777;
        
    }
}