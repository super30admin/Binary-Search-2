public class FindFirstAndLastPositionOfElementInSortedArray {
        public int[] searchRange(int[] nums, int target) {
            int n = nums.length;

            int first = bsFirst(nums, target, 0, n - 1);
            if (first == -1) {
                return new int[] { -1, -1 };
            }
            int last = bsLast(nums, target, first, n - 1);

            return new int[] { first, last };
        }

        private int bsFirst(int[] nums, int target, int low, int high) {
            while (low <= high) {
                int mid = low + (high - low) / 2;

                if (nums[mid] == target) {
                    if (mid == 0 || nums[mid - 1] != target) {
                        return mid;
                    } else {
                        high = mid - 1;
                    }
                } else if (target < nums[mid]) {
                    high = mid - 1;
                } else {
                    low = mid + 1;
                }

            }
            return -1;
        }

        private int bsLast(int[] nums, int target, int low, int high) {
            while (low <= high) {
                int mid = low + (high - low) / 2;

                if (nums[mid] == target) {
                    if (mid == nums.length - 1 || nums[mid + 1] != target) {
                        return mid;
                    } else {
                        low = mid + 1;
                    }
                } else if (target < nums[mid]) {
                    high = mid - 1;
                } else {
                    low = mid + 1;
                }

            }
            return -1;
        }
    }

//TC: O(log n), SC: O(1)
