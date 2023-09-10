class Solution {
    public int[] searchRange(int[] nums, int target) {
        if(nums==null || nums.length==0){
            return new int[] {-1,-1};
        }

        int first= BSfirst(nums,target);
        if(first==-1){
            return new int[] {-1,-1};
        }
        int last = BSlast(nums,target,first);

    return new int[] {first , last};
    
    }

    private int BSfirst(int[] nums, int target){
        int low=0;
        int high=nums.length-1;
        int mid;
        while(low<=high){
            mid=low+(high-low)/2;
            if(nums[mid]==target){
                if(mid==low || nums[mid-1]!=target)
                 return mid;
                else
                 high=mid-1;
            }
            else if(nums[mid]<target)
              low=mid+1;
            else 
              high=mid-1;
            
        }
        return -1;
    }
    private int BSlast(int[] nums, int target, int first){
        int low=first;
        int high=nums.length-1;
        int mid;
        while(low<=high){
            mid=low+(high-low)/2;
            if(nums[mid]==target){
                if(mid==high || nums[mid+1]!=target)
                 return mid;
                low=mid+1;
            }
            else if(nums[mid]>target)
              high=mid-1;
        }
        return -1;
    }
}
