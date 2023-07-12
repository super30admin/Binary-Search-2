//Time Complexity: O(logn)
//Space Complexity: O(1)

/*
 * check the esge case if the array is empty.
 * get the mid value and check if that is less than its neighbours return mid.
 * else search in the unsorted side of the array.
 */
public class MinInSortedArray {
    public int findMin(int[] nums) {
        if(nums == null || nums.length == 0) return 0;
        int low = 0;
        int high = nums.length-1;
        int n = nums.length-1;
        while (low <= high){
            if(nums[low] < nums[high]) return nums[low];
            int mid = low + (high-low)/2;
            if((mid == n || nums[mid] < nums[mid+1]) && (mid == 0 || nums[mid] < nums[mid-1])){
                return nums[mid];                
            }
            else if(nums[low] <= nums[mid]){
                low = mid+1;
            }
            else{
                high = mid-1;
            }
        }
        return -1;
    }
}