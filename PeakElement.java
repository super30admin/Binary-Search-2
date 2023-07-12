//Time Complexity: O(logn)
//Space Complexity: O(1)
/*
 * the idea is to get the mid pointer to get the value greater than its neighbours.
 * if the value of the neighbour is greater than move to that side.
 * Run the binary search again until we get the number greater than its neighbours.
 */

 public class PeakElement{
    public int findPeakElement(int[] nums) {
        int n = nums.length-1;
        int low = 0;
        int high = nums.length-1;
        
        while(high >= low){
            int mid = low + (high-low)/2;
            if ((mid == 0 || nums[mid] > nums[mid-1]) && (mid == n || nums[mid] > nums[mid+1])) return mid;
            if (nums[mid] < nums[mid+1]){
                low = mid+1;
            }
            else{
                high = mid-1;
            }
        }
        return -1;
    }
}