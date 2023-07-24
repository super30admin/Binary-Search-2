class Solution {
    //Time Complexity:-O(logn)
    //Space COmplexity:-O(1)
    public int binarysearchfirstindex(int[] nums,int low,int high,int target){
        while(low<=high){
            int mid = low+(high-low)/2;
            if(nums[mid]==target){
                if(mid==0 || nums[mid]!=nums[mid-1]){
                    return mid;
                }
                else{
                    high=mid-1;
                }
            }
            else if(nums[mid]>=target){
                high=mid-1;
            }
            else{
                low=mid+1;
            }
        }
        return -1;
    }
    public int binarysearchlastindex(int[] nums,int low,int high,int target){
        while(low<=high){
            int mid = low+(high-low)/2;
            if(nums[mid]==target){
                if(mid==nums.length-1 || nums[mid]!=nums[mid+1]){
                    return mid;
                }
                else{
                    low=mid+1;
                }
            }
            else if(nums[mid]>=target){
                high=mid-1;
            }
            else{
                low=mid+1;
            }
        }
        return -1;
    }
    public int[] searchRange(int[] nums, int target) {
        if(nums == null && nums.length==0) return new int[]{-1,-1};
        int low=0;
        int high = nums.length-1;
        int first = binarysearchfirstindex(nums,low,high,target);
        if(first == -1) return new int[]{-1,-1}; 
        int last = binarysearchlastindex(nums,first,high,target);
        return new int[]{first,last};
    }
}