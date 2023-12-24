class FindFirstLastInSortedArray {
    public int[] searchRange(int[] nums, int target) {

        if(nums == null || nums.length == 0 ) {
            return new int[]{-1, -1};
        }

        int l = 0;
        int n = nums.length;
        int h, high;
        h = high = n - 1;
        int mid = -1;
        int first = -1;

        while(l <= h) {
            mid = l + (h - l)/2;
            if(nums[mid] == target) {
                if(mid==0 || nums[mid] > nums[mid - 1]){
                    first = mid;
                    break;
                } else {
                    h = mid - 1;
                }
            } else if(target < nums[mid]) {
                h = mid - 1;
            } else {
                l = mid + 1;
            }
        }

        if(first == -1) return new int[] {-1,-1};

        while(mid <= high) {
            int m = mid + (high - mid)/2;
            if(nums[m] == target) {
                if(m == nums.length-1 || nums[m] < nums[m+1]) {
                    return new int[]{first, m};
                } else {
                    mid = m + 1;
                }
            } else if(target <= nums[m]) {
                high = m - 1;
            } else {
                mid = m + 1;
            }
        }

        return new int[] {-1,-1};
    }
}