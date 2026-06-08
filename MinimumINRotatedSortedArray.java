class MinimumINRotatedSortedArray {
    public int findMin(int[] nums) {
      
       int left = 0;
       int right = nums.length-1;

       while(left <= right){
            
            if(nums[left] <= nums[right]) return nums[left];

            int mid = left+(right-left)/2;

            if(mid > 0 && nums[mid-1] > nums[mid]){
                return nums[mid];
            }else if(nums[left] <= nums[mid]){
                left = mid+1;
            }else{
                right = mid-1;
            }
       }

       return -1;
    }
}