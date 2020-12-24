class findMinRotatedArray {
    public int findMin(int[] nums) {
        
        int start=0;
        int l = nums.length;
        int end = l-1;
        int mid;
        
        while(start <= end){
            mid = (start + end) / 2;
            if((mid+1 >= l))
                return nums[0];
            if((nums[mid] > nums[mid+1]))
                return nums[mid + 1];
            else if(nums[mid] > nums[end])
                start = mid + 1;
            else if(nums[mid] < nums[start])
                end = mid - 1;
            else
                start = mid+1;
            }
        return nums[0];
        
    }
}                       