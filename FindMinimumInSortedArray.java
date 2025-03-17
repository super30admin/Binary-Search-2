package s30.week1;

public class FindMinInRotatedSortedArray {

    /*
    * Points to Note:
    * The smallest value will always be in the unsorted array
    * Atleast one half of the array will always be sorted
    * And in sorted array minimum will be the first element
    * */
    public int findMin(int[] nums) {
        int low = 0;
        int high = nums.length - 1;

        while(low <= high) {

            if(nums[low] <= nums[high]) {
                return nums[low];
            }
            int mid = low + (high-low)/2;

            if( (mid == 0 || nums[mid] <= nums[mid - 1]) && (mid == nums.length - 1 || nums[mid] <= nums[mid + 1])){
                return nums[mid];
            }

            if(nums[low] <= nums[mid]) {
                low = mid + 1;
            } else {
                high = mid - 1;
            }
        }
        //nums[low] in case of while( low < high)
        return -1;
    }

    public static void main(String[] args) {

    }
}
