class Solution {
    public int findPeakElement(int[] arr) {
       int n = arr.length;

        // Edge cases
        if (n == 1) return 0; // Single element is the peak
        if (arr[0] > arr[1]) return 0; // First element is the peak
        if (arr[n - 1] > arr[n - 2]) return n - 1; // Last element is the peak

        int low = 1, high = n - 2; // Search within the middle portion
        while (low <= high) {
            int mid = low + (high - low) / 2;

            // If mid is a peak element
            if (arr[mid - 1] < arr[mid] && arr[mid] > arr[mid + 1]) {
                return mid;
            }

            // If on the left slope of a peak
            if (arr[mid] > arr[mid - 1]) {
                low = mid + 1;
            } else {
                // If on the right slope of a peak
                high = mid - 1;
            }
        }

        // Dummy return (function won't reach here for valid input)
        return -1;
    }

    }