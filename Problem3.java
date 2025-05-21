//Problem : https://leetcode.com/problems/find-peak-element/
//Solved in leetcode and no issues faced
//TC : O(logn) , SC : O(1)
//Approach in below comments

class Solution {
    public int findPeakElement(int[] arr) {
        int start = 0;
        int end = arr.length - 1;
        
        while (start < end) {  // while start and end are not equal
            int mid = start + (end - start) / 2;

            // If mid is greater than the next element, peak lies on the left side or at mid
            if (arr[mid] > arr[mid + 1]) {
                end = mid;  // Move the end to mid
            } else {
                // If mid is smaller than the next element, peak lies on the right side
                start = mid + 1;  // Move the start to mid + 1
            }
        }

        // At the end, start == end, and we have found the peak
        return start;
    }
}
