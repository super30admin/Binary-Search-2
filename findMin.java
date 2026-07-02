class solution{
    public int findMin(int[] nums){
        //one side of array is sorted, we use binarybsearch to find where the rotation happend
        int left = 0;
        int right = nums.length-1;

        while(left < right){
            int mid = left + (right - left)/2;

            //min mist be on right side
            if(nums[mid] > nums[right]){
                left = mid + 1;
            }
            //min is at mid or left side
            else{
                right = mid;
            }
        }
      //left is pointing to min elemnt
        return nums[left];
    }
}