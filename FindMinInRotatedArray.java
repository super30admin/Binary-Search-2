// Time Complexity : O(log n)
// Space Complexity : O(1)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : -

/*
Need to find minimum of given rotated sorted elements
Logic lies in Binary Search, check if array is already sorted, return low value.
if not, understand min will always be on the unsorted side of the array.
Handle edge conditions of min to be low or high also, if only 2 elements are in array
 */
public class FindMinInRotatedArray {

    //Using Binary Search, need to identify which side is sorted, in rotated sorted array, the min will always be on the unsorted side of the array.
    public static int findMin(int[] nums) {
        if (nums == null || nums.length == 0) return -1;

        int low = 0, high = nums.length - 1, mid;

        while (low <= high) {
            //If array is already sorted, min is low element
            if (nums[low] <= nums[high])
                return nums[low];

            //calculate mid
            mid = low + (high - low) / 2;

            //If mid is lower than its left and right, return mid
            if ((mid == low || nums[mid] < nums[mid - 1]) &&
                    (mid == high || nums[mid] < nums[mid + 1]))
                return nums[mid];
                //If not mid, check which side is sorted, min will always be in unsorted side
                //So move your high/low to the unsorted subset
            else if (nums[mid] >= nums[low]) {
                //This is left sorted so eliminate sorted side
                low = mid + 1;
            } else {
                high = mid - 1;
            }
        }
        return -1;
    }

    public static void main(String ar[]) {
        int[] input = new int[]{4,5,6,7,0,1,2};

        int res = findMin(input);

        System.out.println(" Min is : " + res);
    }
}
