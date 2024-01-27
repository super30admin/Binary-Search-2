class FirstAndLastOccurence {
    public int[] searchRange(int[] nums, int target) {
        // binary search to find the element
        int low = 0;
        int high = nums.length - 1;
        // index where target is found
        int mid;
        int index = -1;

        while (low <= high) {
            mid = low + (high - low) / 2;

            if (nums[mid] == target) {
                index = mid;
                break;
            }

            if (target > nums[mid]) {
                low = mid + 1;
            } else {
                high = mid - 1;
            }
        }

        // not found
        if (index == -1)
            return new int[] { -1, -1 };

        // initializing to the one element that was found
        // updating as we find one on other ends
        int leftRes = index;
        int rightRes = index;

        // finding first occurence
        int newHigh = index - 1;
        low = 0;

        while (low <= newHigh) {
            mid = low + (newHigh - low) / 2;

            if (nums[mid] == target) {
                newHigh = mid - 1;
                leftRes = mid;
            } else {
                low = mid + 1;
            }
        }

        // finding second occurence
        int newLow = index + 1;
        high = nums.length - 1;

        while (newLow <= high) {
            mid = newLow + (high - newLow) / 2;

            if (nums[mid] == target) {
                newLow = mid + 1;
                rightRes = mid;
            } else {
                high = mid - 1;
            }
        }

        return new int[] { leftRes, rightRes };
    }
}