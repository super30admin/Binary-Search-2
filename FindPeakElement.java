class findPeakElement {
    public int findPeakElement(int[] nums) {
        int n = nums.length;
        return searchPeak(nums, 0, n - 1);
    }
    public int searchPeak(int[] nums, int left, int right){
        if(left == right){
            return left;
        }
        int mid = (left + right)/2;
        if(nums[mid] > nums[mid + 1]){
            return searchPeak(nums, left, mid);
        }
        return searchPeak(nums, mid + 1, right);
    }
}