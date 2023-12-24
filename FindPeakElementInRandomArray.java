class FindPeakElementInRandomArray {
    public int findPeakElement(int[] nums) {
        if(nums == null || nums.length == 0) return -1;

        int n = nums.length;
        int l = 0;
        int h = n -1;

        while(l <= h) {
            int m = l + (h-l)/2;
            if((m == 0 || nums[m] > nums[m-1])
                    && (m == n -1 || nums[m] > nums[m+1])) {
                return m;
            }  else if (nums[m] < nums[m+1]) {
                l = m + 1;
            } else {
                h = m - 1;
            }
        }

        return -1;
    }
}
