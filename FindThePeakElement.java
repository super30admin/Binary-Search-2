// Time Complexity : O(log n)
// Space Complexity : O(1)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No

// We use binary search to find the peak element by comparing the mid element with its neighbors.
// If the mid element is greater than both neighbors, it's a peak.
// Otherwise, we move in the direction of the greater neighbor, as a peak is guaranteed to exist there.

public class FindThePeakElement {

    public int findPeakElement(int[] nums) {
        int low = 0;
        int high = nums.length - 1;
        int n = nums.length;
        while(low <= high) {
            int mid = low + (high - low)/2;
            
            // Check if mid is a peak
            if((mid == 0 || nums[mid] > nums[mid - 1]) && (mid == n - 1 || nums[mid] > nums[mid + 1])) return mid;

            // If left neighbor is greater, move left
            else if(mid > 0 && nums[mid] < nums[mid - 1]){
                high = mid - 1;
            
            //Otherwise move right
            } else {
                low = mid + 1;
            }
        }
        return -1; // Should not reach here as per problem guarantees
    }

    public static void main(String[] args) {
        int[] nums1 = {1, 2, 3, 1};             // Output: 2
        int[] nums2 = {1, 2, 1, 3, 5, 6, 4};     // Output: 1 or 5

        FindThePeakElement obj = new FindThePeakElement();

        System.out.println("Peak Index (Test 1): " + obj.findPeakElement(nums1));
        System.out.println("Peak Index (Test 2): " + obj.findPeakElement(nums2));
    }
}

//Test cases
// Input: nums = [1,2,3,1] output: 2
//Input: nums = [1,2,1,3,5,6,4] output: 1 or 5





// Clarifying questions one could ask:
// 1. Is the array guaranteed to be sorted? No, it's a random (unsorted) array.
// 2. Can the first and last elements be peak elements?
//    Let's assume negative infinity before the first element and after the last element,
//    so for the end elements, only one neighbor needs to be compared to determine if it's a peak.
// 3. Can adjacent duplicates exist, like [2, 2]?
//    According to the constraint nums[i] != nums[i - 1], the answer is NO.
// 4. Are we returning all peak elements or any one of them or the maximum of all the peaks?
//    We return the index of any one peak element, as the problem only requires one here.
//    for maximum of all peaks or all the peaks we fall back to the linear search Brute force approach 
//    Bacause
//    Binary search works by making a decision at each midpoint — going left or right — and discarding half of the array in each step. That means:
//    It does not explore the entire array, only the side where a peak is guaranteed to exist.
//    So, you can find one peak, but not all peaks with Binary Search.


// Brute Force Approach:
// Perform a linear search by iterating through the array and checking whether each element
// is greater than its neighbors.
// In the worst case (e.g., [1, 2, 3, 4, 5]), the peak element is at the end,
// resulting in a time complexity of O(n).
