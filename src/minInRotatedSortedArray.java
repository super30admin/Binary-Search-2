// Time Complexity: log(n);
// Space Complexity: o(1);
// Did it run on leetcode: Yes
// Problems faced: No
public class minInRotatedSortedArray {

    public int findMin(int[] nums) {

        if(nums.length == 1){
            return nums[0];
        }

        int low = 0;
        int high = nums.length -1;

        while ( low < high ){

            int mid = low + (high -low)/2;

            if(nums[low] <= nums[high]){
                return nums[low];
            }

            if( (mid ==0 || nums[mid] < nums[mid-1] ) && nums[mid] < nums[mid+1] ){
                return nums[mid];
            }else if( nums[mid] > nums[high] ){
                low = mid+1;
            }else{
                high = mid-1;
            }

        }

        return nums[low];

    }

}
