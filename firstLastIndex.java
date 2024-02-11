class firstLastIndex {
    public int[] searchRange(int[] nums, int target) {
        
        int n = nums.length;
        
        if(nums == null || n == 0) {
            return new int[]{-1,-1};
        }
        if(nums[0]>target || nums[n-1]<target) {
            return new int[]{-1,-1};
        }
        int firstidx = firstBinarySearch(nums,0,n-1,target);
        if(firstidx == -1) {
            return new int[]{-1,-1};
        }
        int lastidx = lastBinarySearch(nums,firstidx,n-1,target);
        
        return new int[]{firstidx,lastidx};
    }
    private int firstBinarySearch(int[] nums,int l,int h,int target) {
        while(l<=h) {
            int m = l + (h - l)/2;
            if(target == nums[m]) {
                if(m == 0 || nums[m]>nums[m-1]) {
                    return m;
                }
                else{
                    h = m - 1;
                }
            }
            else if(nums[m]>target){
                h = m - 1;
            }
            else{
                l = m + 1;
            }
        }
        return -1;
    }

    private int lastBinarySearch(int[] nums,int l,int h,int target) {
        while(l<=h) {
            int m = l + (h - l)/2;
            if(target == nums[m]) {
                if(m == h || nums[m]<nums[m+1]) {
                    return m;
                }
                else{
                    l = m + 1;
                }
            }
            else if(nums[m]>target){
                h = m - 1;
            }
            else{
                l = m + 1;
            }
        }
        return -1;
    }

}