/*
 Time Complexity: log(n)
 Space Complexity: log(1)
 */
public class MinValueFinderInRotatedSortedArray {
    public int findMin(int[] nums) {
        int low = 0;
        int high = nums.length-1;
        // While loop for binary search with base condition
        while(low<= high){
            // If the array isn't rotated or the element positions don't change even after rotation return 1st element
            if(nums[low] <=nums[high]) return nums[low];

            // Calculate mid and try to reduce the search space by half
            int mid =low+(high-low)/2;
            // If mid is min return mid
            if((mid ==0||nums[mid]<nums[mid-1]) && (mid==nums.length-1 || nums[mid]<nums[mid+1])) return nums[mid];
            // If mid is greater that element at left index
            if (nums[low] <= nums[mid]){
                // Move left index to mid+1
                low = mid+1;
            }
            // Else move right index to mid -1
            else{
                high = mid-1;
            }
        }
        return -1;
    }
}