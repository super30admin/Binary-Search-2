class FirstAndLastOcc{ 
    public int[] searchRange(int[] nums, int target) {
        int n = nums.length;
        if(nums.length==0 || nums==null) return new int[]{-1,-1};

        if(nums[0]>target || nums[n-1] < target) return new int[]{-1,-1};

        int first = firstBinarySearch(nums,target,0,n-1);
        if(first == -1) return new int[]{-1,-1};
        int last = lastBinarySearch(nums,target,0,n-1);

        return new int[]{first,last};


    }

    private int firstBinarySearch(int[] nums, int target,int low, int high){
        while(low<=high){
            int mid = low+(high-low)/2;

            if(nums[mid] == target){
                if(mid==0 || nums[mid]>nums[mid-1]){
                    return mid;
                }else{
                    //keep on moving left
                    high = mid-1;
                }
            }else if(nums[mid]> target){
                high = mid-1;
            }else{
                low = mid+1;
            }
        }
        return -1;
    }

    private int lastBinarySearch(int[] nums, int target,int low, int high){
        while(low<=high){
            int mid = low+(high-low)/2;

            if(nums[mid] == target){
                if(mid==nums.length-1 || nums[mid]<nums[mid+1]){
                    return mid;
                }else{
                    //keep on moving left
                    low = mid+1;
                }
            }else if(nums[mid]> target){
                high = mid-1;
            }else{
                low = mid+1;
            }
        }
        return -1;
    }

}