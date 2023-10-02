
// Time Complexity : log(N)
// Space Complexity : O(1)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No

//Step 1 check if the first element is less than the last element then it is the minimum element
// as the array is sorted.  NO need to search further return the first element
// Else perform binary search and return the minimum element
public class FindMinSortedArray {
    public int findMin(int[] nums) {
        if(nums == null || nums.length ==0) return -1;
        int n = nums.length;
        int low = 0; int high = n -1;
        while(low <= high){
            int mid = low + (high - low )/2; // handle integer overflow
            //Step 1 check if the first element is less than the last element then it is the minimum element
            // as the array is sorted.  NO need to search further return the first element
            if(nums[low] <= nums[high]) return nums[low];
            // Else perform binary search and return the minimum element
            if ((mid == 0 || nums[mid] < nums[mid -1]) && ( nums[mid] < nums[mid +1] )){
                   return nums[mid];
            }else if(nums[low] <= nums[mid]){

                low = mid + 1;
            }else{
                high = mid - 1;
            }
        }
        return -1;
    }
}
