// Time Complexity:O(logn)
// Space Complexity:O(1)
class Solution {
    public int[] searchRange(int[] nums, int target) {
        int n =nums.length;
        if(nums==null||n==0) return new int []{-1,-1};
        if(target<nums[0]||target>nums[n-1]) return new int []{-1,-1};
        int first= First(nums,0,n-1,target);
        if(first==-1) return new int[]{-1,-1};
        int last=Last(nums,first,n-1,target);
        return new int[]{first,last};
    }

    private int First(int[]nums,int low,int high, int target){
        while(low<=high){
            int mid=low+(high-low)/2;
            if(nums[mid]==target){
                if(mid==0||nums[mid-1]!=target){
                    return mid;
                }
                else{
                    high=mid-1;
                }
            }else if(nums[mid]<target){
                low=mid+1;
            }
            else{
                high=mid-1;
            }
        }
        return -1;
    }
    private int Last(int[]nums,int low,int high, int target){
        while(low<=high){
            int mid=low+(high-low)/2;
            if(nums[mid]==target){
                if(mid==high||nums[mid+1]!=target){
                    return mid;
                }
                else{
                    low=mid+1;
                }
            }else if(nums[mid]<target){
                low=mid+1;
            }
            else{
                high=mid-1;
            }
        }
        return -1;
    }
}