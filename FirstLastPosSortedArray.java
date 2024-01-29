// Time Complexity : Olog(n)
// Space Complexity : O(1)
// Did this code successfully run on Leetcode : Yes

// Any problem you faced while coding this : No

// Your code here along with comments explaining your approach in three sentences only
/*
 * Applied Binary search twice to find first and last pos
 * for first Pos, shifted towards left to find the left most position of the target value
 * for right Pos, shifted towards right to find the right most position of the target value
 */

// Java code to implement the approach

class FirstLastPosSortedArray {
    public int[] searchRange(int[] nums, int target) {
        if(nums == null || nums.length == 0) {
             return new int [] {-1, -1};
        }
        
         int n = nums.length;
        if(nums[0] > target || nums[n-1] < target) {
             return new int [] {-1, -1};
        }    
       

        int arr[] = new int[2];
        arr[0] = binarySearchFirstOccurrence(0, n-1, nums, target);
        
        if (arr[0] == -1) {
            return new int [] {-1, -1};
        }
        arr[1] = binarySearchSecondOccurrence(arr[0], n-1, nums, target);

        return arr;
    }

    private int binarySearchFirstOccurrence(int l, int r, int[]arr, int target) {
        while (l <= r) {
            int mid = l + (r - l) / 2;
            
            if (arr[mid] == target) {
                if (mid == 0 || arr[mid] > arr[mid -1]) {
                    return mid;
                } else {
                    r = mid - 1;  // move left
                }
            } else if (arr[mid] > target) {
                r = mid - 1;  // move left
            } else {
                l = mid + 1;
            }
        }

        return -1;
    }

    private int binarySearchSecondOccurrence(int l, int r, int[]arr, int target) {
        while (l <= r) {
            int mid = l + (r - l) / 2;
            
            if (arr[mid] == target) {
                if(mid == arr.length -1 || arr[mid] < arr[mid + 1]) {
                    return mid;
                } else {
                    l = mid + 1; // move right
                }
            } else if (arr[mid] > target) {
                 r = mid - 1;  // move left
            } else {
                l = mid + 1;
            }
        }

        return -1;
    }
}   