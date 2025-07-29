// Time Complexity : O(log n), n - length of array (since binary search)
// Space Complexity : O(1)
// Did this code successfully run on Leetcode : yes
// Any problem you faced while coding this : no
// Approach:
// 1. Use binary search
// 2. mid is the min element if it's lower than its neighbors if they exist
// 3. In rotated sorted array, at least one half is always sorted and
//      min element always lies in the unsorted half;
//      based on this property, ignore the sorted half in each iteration

public class FindMinRotatedSortedArr {
    private static int findMin(int[] nums) {
        int l=0, h=nums.length-1;

        while(l <= h) {
            int mid = l + (h-l)/2;

            // check if mid is lower than it's left and right neighbors if exist
            if((mid-1 < 0 || nums[mid-1] > nums[mid])
                && (mid+1 >= nums.length || nums[mid+1] > nums[mid])) {
                return nums[mid];
            }

            // check if right half is sorted, move to left as min lies in left
            // this also handles the scenario where both halved are sorted, then move to left
            // e.g [6,7,0,2,3,4,5]
            if(nums[mid] <= nums[h]) {
                h = mid - 1;
            }
            // if right half is not sorted, then left is sorted, move to right as the min element lies in right
            // e.g [5,6,7,2,3,4]
            else {
                l = mid + 1;
            }
        }
        // does not matter what we return here, as min is always guaranteed to be present in the array
        return -1;
    }
    public static void main(String[] args) {
        System.out.println(findMin(new int[]{3,4,6,0,2})); //0
        System.out.println(findMin(new int[]{3,4,6,0,1,2})); //0
        System.out.println(findMin(new int[]{1,2,3,4,5})); //1
        System.out.println(findMin(new int[]{3,4,5,1,2})); //1
        System.out.println(findMin(new int[]{4,5,6,7,0,1,2})); //0

    }
}
