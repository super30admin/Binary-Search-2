class FindPeakElement {
    public int findPeakElement(int[] nums) {
        // Check if the input array is null or empty
        if (nums == null || nums.length == 0)
            return -1; // No peak element found in an empty or null array

        int low = 0; // Initialize the lower bound of the search range
        int high = nums.length - 1; // Initialize the upper bound of the search range
        
        while (low <= high) {
            int mid = low + (high - low) / 2; // Calculate the middle index (avoiding integer overflow)

            // Check if the current element at mid is greater than its neighbors
            if ((mid == nums.length - 1 || nums[mid] > nums[mid + 1]) &&
                (mid == 0 || nums[mid] > nums[mid - 1]))
                return mid; // Return the index of the peak element if found

            // If the element to the right of mid is greater, move the search range to the right
            else if (nums[mid + 1] > nums[mid])
                low = mid + 1;
            // Otherwise, move the search range to the left
            else
                high = mid - 1;
        }

        return -1; // No peak element found in the array
    }
}

//Time Complexity: O(logN)
//Space Complexity: O(1)
