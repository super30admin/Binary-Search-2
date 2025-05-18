/*
Binary search

Time : O(log(n))
Space :O(1)
 */
public class FindMinInSortedArray {
    public static int findMin(int[] nums) {
        int low = 0;
        int high = nums.length - 1;

        while(low <= high){

            //complete range is sorted

            if(nums[low] <= nums[high]){
                return nums[low];
            }

            int mid = low + (high - low) / 2; //to avoid overflow

            if((mid == 0 || nums[mid] < nums[mid - 1]) /*Left bound take care*/
                    && (mid == nums.length - 1 || nums[mid] < nums[mid+1])){ /*right bound take care*/ ///edge cases check
                //if(nums[mid] < nums[mid - 1] && nums[mid] < nums[mid+1]){
                return nums[mid];
            }

            else if (nums[low] <= nums[mid]) //left is sorted - pivot lies in right side

            {
                low = mid + 1;
            }

            else { //right is sorted - pivot lies in left side
                high = mid - 1;
            }

        }

        return -1;

    }

    public static void main(String[] args) {
        int[] nums = {3,4,5,1,2};

        System.out.println(findMin(nums));
    }
}
