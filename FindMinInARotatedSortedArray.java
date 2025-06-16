// Time Complexity : O(log n)
// Space Complexity : O(1)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No

// We use binary search to repeatedly narrow down the search space by comparing middle and high elements.
// If the middle element is less than the high element, the minimum lies to the left including mid; else it lies to the right.
// This process continues until the search space converges to the minimum element.
public class FindMinInARotatedSortedArray {

    public int findMin(int[] nums) {
        int low = 0;
        int high = nums.length - 1;
        int n = nums.length - 1;
        while(low <= high){
            // There may be a situation where both parts are sorted, 
            // which means the entire array is sorted, and the first element would be the minimum.
            if(nums[low] < nums[high]) return nums[low];
            int mid = low + (high - low)/2;
            // If the mid element is less than both its neighboring elements, then it is the pivot as well as the minimum element.
            // The condition 'mid == 0' accounts for the case when mid is at the start of the array and has no left neighbor.
            if((mid == 0 || nums[mid] < nums[mid - 1]) && nums[mid] < nums[mid + 1]) return nums[mid];
            //eliminate the right part
            else if(nums[mid] < nums[high]){
                high = mid - 1;
            //eliminate the left part
            }else {
                low = mid + 1;
            }
        }
        return nums[low];
    }

    public static void main(String[] args) {
        int[] nums = {11,13,15,17};
        FindMinInARotatedSortedArray obj = new FindMinInARotatedSortedArray();
        int result = obj.findMin(nums);

        System.out.println("Minimum: [" + result + "]");
    }
}


//Test cases
//Input: nums = [3,4,5,1,2] output : 1
//Input: nums = [4,5,6,7,0,1,2] output : 0
//Input: nums = [11,13,15,17] output : 11


//Clarifying questions one could ask for:
//1. Is the array guaranteed to be sorted in ascending order before rotation?
//2. Are there any duplicate values in the array?
//3. Is the array rotated at least once, or could it be fully sorted (no rotation)?
//4. Can the array have only one element?
//5. Should we return the index of the minimum element or just the value?
//6. What should the function return if the input array is empty?
