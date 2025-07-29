// Time Complexity : O(log n), n - length of array
// Space Complexity : O(1)
// Did this code successfully run on Leetcode : yes
// Any problem you faced while coding this : no
// Approach:
// 1. Use binary search to find the first position of target
// 2. Use another binary search to find the last position of target
// 3. In each case, if mid is equal to target, move to left if looking for start position,
//      move to right if looking for end position

public class FirstLastPos {
    private static int findFirst(int[] nums, int target) {
        int l = 0, h = nums.length-1;
        // binary search
        while(l <= h) {
            int mid = l + (h-l)/2;
            if(nums[mid] == target) {
                if(mid-1 < 0 || nums[mid-1] != target) {
                    return mid;
                } else {
                    // move left
                    h = mid - 1;
                }
            }
            // move left
            else if(target < nums[mid]) {
                h = mid - 1;
            }
            // move right
            else {
                l = mid + 1;
            }
        }
        return -1;
    }

    private static int findLast(int[] nums, int target) {
        int l=0, h=nums.length-1;

        while(l <= h){
            int mid = l + (h-l)/2;

            if(nums[mid] == target) {
                if(mid + 1 >= nums.length || nums[mid+1] != target) {
                    return mid;
                }
                else{
                    l = mid + 1;
                }
            }
            // move left
            else if(target < nums[mid]){
                h = mid - 1;
            }
            // move right
            else {
                l = mid + 1;
            }
        }
        return -1;
    }

    private static int[] searchRange(int[] nums, int target) {

        int first = findFirst(nums, target);
        if(first == -1) {
            return new int[]{-1, -1};
        }
        int last = findLast(nums, target);
        return new int[]{first, last};
    }

    public static void main(String[] args) {
        int[] res;
        res = searchRange(new int[]{1,1,2,30,30,30,30,30,40,50,50,50}, 50);
        System.out.println(res[0] + " " + res[1]);

        res = searchRange(new int[]{1,1,2,30,30,30,30,30,40,50,50,50}, 30);
        System.out.println(res[0] + " " + res[1]);
    }
}
