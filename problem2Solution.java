//Find Minimum in Rotated Sorted Array
//Time Complexity : O(log n)
//Space Complexity : O(1)

public class problem2Solution {
    public int findMin(int[] nums) {
        int low = 0;
        int high = nums.length-1;
        int result = Integer.MAX_VALUE;
        while(low<=high){
            if(nums[low] <= nums[high]) return nums[low];
            int mid =  low + (high - low)/2;
            System.out.print("mid" + mid);
            if(mid > 0 && nums[mid] < nums[mid-1] && nums[mid]<nums[mid+1]) return nums[mid];
            if(nums[low] <= nums[mid]) {
                low = mid +1;
            }
            else {
                high = mid - 1;
            }
        }
        return result;
    }
}
