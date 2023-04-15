## Problem 1: (https://leetcode.com/problems/find-first-and-last-position-of-element-in-sorted-array/)

// Time Complexity - O (2 log n) which is O(log n) because the code uses binary search two times
// Space Complexity - O(1)


class Solution {
    public int[] searchRange(int[] nums, int target) {
        if (nums == null || nums.length == 0) {                  // if target is not present or found
            return new int[] {-1, -1};                         
        }
        int left = binarySearchLeft(nums, target);               // two binary search will be executed one is left 
        if (left == -1) {                                        // the occurence of the target is not there so nu use of 2nd Binary search
            return new int[] {-1, -1};
        }
        int right = binarySearchRight(nums, target);             // this is the second binary search
        return new int[] {left, right};
    }

    private int binarySearchLeft(int[]nums, int target) {          // first binary search for the left side 
        int low = 0;                                               // lower bound
        int high = nums.length - 1;                                // high bound
        while (low <= high) {                                      
            int mid = low +(high - low) / 2;                        // prevent integer overflow
            if (nums[mid] == target) {                              // checking if element in the mid equal to target
                if (mid == 0 || nums[mid - 1] != nums[mid]) {       // if it is equal check the left side
                    return mid;                                      // return index
                }
                high = mid - 1;                                       // if not equal move left
            }
            else if (target > nums[mid]) {                            // if target is greater
                low = mid + 1;                                        // move right
            }
            else {
                high = mid - 1;                                       // if target is smaller move left
            }
        }
        return -1;                                            // if nothing exists or nothing found in the binary search 1
    }

    private int binarySearchRight(int[]nums, int target) {         // second binary search for the right side 
        int low = 0;
        int high = nums.length - 1;
        while (low <= high) {
            int mid = low + (high - low) / 2;
            if (nums[mid] == target) {
                if (mid == nums.length - 1 || nums[mid + 1] != nums[mid]) {
                    return mid;
                }
                low = mid + 1;                                      // move towards right if the index is not returned 
            }
            else if (target > nums[mid]) {
                low = mid + 1;
            }
            else {
                high = mid - 1;
            }
        }
        return -1;
    }
}


# Problem 2: (https://leetcode.com/problems/find-minimum-in-rotated-sorted-array/)

// Time Complexity - O(logn) because binary search to find the minimum element in a sorted rotated array.
// Space Complexity - O (1)

// for both the approaches the time and space complexity is same


## This is my approach and wants to get it reviewed if this also works as leet code accepts it. Please review and can leave comments if something I am missing

class Solution {
    public int findMin(int[] nums) {
        int left = 0;
        int right = nums.length - 1;

        while(left < right) {
            int mid = left + (right - left)/2;

                    // If mid element is greater than the last element, then the minimum element is in the right half
            if (nums[mid] > nums[right]) {
                left = mid + 1;
            }
                    // Otherwise, the minimum element is in the left half
            else {
                right = mid;
            }
        }
        return nums[left];
    }
}


## This is the approach we discussed in the class

class Solution {
    public int findMin(int[] nums) {
        if (nums == null || nums.length == 0) {              //if target is not present or found
            return -1; 
        }
        int low = 0;                                         // low bound
        int high = nums.length - 1;                          // high bound

        while(low <= high) {
            if (nums[low] <= nums[high]) {                   // checks if the array is sorted
                return nums[low];                            // this shows yes it sorted
            }                                                // if the array is not sorted do the below steps
            int mid = low + (high - low)/2;                  // prevent integer overflow 
            if ((mid == 0 || nums[mid - 1] > nums[mid]) && (mid == nums.length - 1 ||nums[mid + 1] > nums[mid])) {    // to check whether we are on the smallest element
                return nums[mid];                             // returns index
            }
            if (nums[low] <= nums[mid]) {                     // unsorted right side
                low = mid + 1;                                 // move right
            }
            else {
                high = mid - 1;                                 // or if not then move left side
            }
        }
        return -1;                                              // return anything if you do not find the minimum element
    }
}


## Problem 3: https://leetcode.com/problems/search-in-a-sorted-array-of-unknown-size/   (Yesterdays problem)

// Time Complexity - o (log n) because the code uses binary search algorithm
// Space Complexity - 


class Solution {
    public int search(ArrayReader reader, int target) {
        int low = 0;                                                      // lower bound
        int high = 1;                                                     // higher bound
        
        while (target > reader.get(high)) {                                // when the target is greater which means high is not set properly
            low = high;                                                    // make low conatin the value of high 
            high = high * 2;                                               // and multiply high with two to provide a range for the search
        }
        return binarySearch(reader, target, low, high);
    }

    private int binarySearch(ArrayReader reader, int target, int low, int high) {
        while (low <= high) {
            int mid = low + (high - low) / 2;                            // prevent integer overflow
            if (reader.get(mid) == target) {                             // check mid is found or not
                return mid;                                               // equal to target so return index
            } 
            else if (target < reader.get(mid)) {                        // target is not equal and is smaller than mid
                high = mid - 1;                                         // move left
            } 
            else {
                low = mid + 1;                                           // if target is greater than mid move right
            }
        }
        return -1                                                        // target not found
    }
}
