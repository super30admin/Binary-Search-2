// TC - O(log n)
//SC - O(1)

// We use binary search to solve this problem. Consider the property that at least one side of the mid
// element will be sorted.
class MinRotatedArray {
    public int findMin(int[] nums) {
        // base case
        if(nums==null || nums.length==0){
            return -1;
        }

        int low = 0;
        int high = nums.length-1;

        while(low<=high){
            // If first element is less then last element the array is sorted. We return.
            if(nums[low] <= nums[high]){
                return nums[low];
            }

            int mid = low+ (high-low)/2; // this is to handle Integer overflow

            // checking if mid element is minimum
            if( (mid==0 || nums[mid] < nums[mid-1]) && (mid==nums.length-1 || nums[mid] < nums[mid+1])){
                return nums[mid];
            }
            // if not then updated low and high index
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