public class FindFirstAndLastPositionOfElement {

    // Time Complexity : O(log(N))
// Space Complexity : O(1)
// Did this code successfully run on Leetcode : yes
// Any problem you faced while coding this : No

    private int binarySearchFirst(int[] arr, int target, int low, int high) {
        while(low<=high) {
            int mid = (low+(high-low))/2;
            if(arr[mid] == target) {
                if(mid == 0 || arr[mid] > arr[mid-1]) {
                    return mid;
                } else {
                    high = mid -1; //keep moving left
                }
            } else if(arr[mid] > target){
                high = mid-1;
            } else {
                low = mid+1;
            }
        }
        return -1;
    }
    private int binarySearchLast(int[] arr, int target, int low, int high) {
        int n = arr.length;
        while(low<=high) {
            int mid = (low+(high-low))/2;
            if(arr[mid] == target) {
                if(mid == n-1 || arr[mid]<arr[mid+1] ) return mid;
                else {
                    low = mid+1;//keep moving right
                }
            } else if(arr[mid] > target) {
                high = mid-1;
            } else {
                low = mid+1;
            }
        }
        return -1;
    }
    public int[] searchRange(int[] nums, int target) {

        int n = nums.length;
        if(nums == null || nums.length == 0) return new int[]{-1,-1};
        if(nums[0] > target || nums[n-1] < target) return new int[]{-1,-1};

        int firstOccurance = binarySearchFirst(nums, target, 0, n-1);
        if(firstOccurance == -1) return new int[]{-1,-1};
        int lastOccurance = binarySearchLast(nums, target, firstOccurance, n-1);
        return new int[]{firstOccurance, lastOccurance};

    }
}
