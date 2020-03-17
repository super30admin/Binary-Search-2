// Time Complexity : log(n)
// Space Complexity : O(1)
// Did this code successfully run on Leetcode : yes
// Any problem you faced while coding this : yes, while searching for rightmost index of the element

public class SearchRangeForTargetInSortedArray {
    public static int[] searchRange(int[] nums, int target) {

        // Edge cases
        if(nums == null || nums.length == 0){
            return new int[]{-1,-1};
        }

        // Finding left index
        int low = 0;
        int high = nums.length - 1;
        while(low < high){
            int mid = low + (high - low)/2;
            if(nums[mid] >= target){
                high = mid;
            } else {
                low = mid + 1;
            }
        }

        // Checking if the target element exists at the found index
        if(nums[low] != target){
            return new int[]{-1,-1};
        }

        //Saving low as start index
        int start = low;
        high = nums.length - 1;

        // Finding right index

        while(low < high){
            int mid = (low+high)/2 + 1;
            if(nums[mid] > target){
                high = mid - 1;
            } else {
                low = mid;
            }
        }

        int end = low;

        return new int[] {start, end};
    }

    public static void main(String args[]){
        int[] arr = new int[]{5,7,7,8,8,10};
        int[] answer = searchRange(arr, 8);
        for(int i : answer){
            System.out.print(" " +i);
        }
    }
}
