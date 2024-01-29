// Identified the base conditions like array being empty or null and if the target is really present in the array

// To identify the lower index check if mid element equals target, if yes then check there are any target element 
// on the left to decide inorder to move left or return the mid element,

// do similarly to find higher index considerig the array start to be the newly found lower index

class Problem1_FindFirstLastTargetIndex {
    public int[] searchRange(int[] nums, int target) {
        int n = nums.length;
        int l=0, r=n-1;
        int[] res= new int[]{-1,-1};
        if(nums==null || n==0) return res;
        else if(nums[0]>target || nums[n-1]<target) return res;
        res[0]=findLowerIndex(nums, target, l, r);
        if(res[0]==-1) return res;
        res[1]=findUpperIndex(nums, target, res[0], r);
        return res;
    }

    private int findLowerIndex(int[] nums, int target, int l, int r){
        while(l<=r){
            int m=l+(r-l)/2;
            if(nums[m]==target){
                if(m==0 || nums[m-1]<target)
                    return m;
                else if(nums[m-1]==target)
                    r=m-1;
            }else if(nums[m]<target){
                l=m+1;
            }else {
                r=m-1;
            }
        }
        return -1;
    }

    private int findUpperIndex(int[] nums, int target, int l, int r){
        while(l<=r){
            int m=l+(r-l)/2;
            if(nums[m]==target){
                if(m==nums.length-1 || nums[m+1]>target)
                    return m;
                else if(nums[m+1]==target)
                    l=m+1;
            }else if(nums[m]<target){
                l=m+1;
            }else {
                r=m-1;
            }
        }
        return -1;
    }
}