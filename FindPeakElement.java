class FindPeakElement {

    /**
        TC -> O(Log2N) , where N is the length of nums
        SC -> O(1), constant extra is used

        We move towards the peak side of the array when going mid + 1 or mid - 1
        Important condition is to check for mid == 0 / mid == n-1 and not mid == l / mid == h-1
     */
    public int findPeakElement(int[] nums) {
        if(nums.length == 0 || nums == null) return 0;

        int n = nums.length;
        int l = 0, h = n - 1;
        while(l <= h){
            int mid = l + (h-l) / 2;
            if((mid == 0 || nums[mid] > nums[mid-1]) && (mid == n-1 || nums[mid] > nums[mid+1]))
                return mid;
            else if (mid != 0 && nums[mid-1] > nums[mid])
                h = mid - 1;
            else 
                l = mid + 1;
        }
        return 0;
    }
}
