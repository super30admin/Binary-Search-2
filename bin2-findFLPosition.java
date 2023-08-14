// TC:log n, SC:1

class Solution {
    public int[] searchRange(int[] nums, int target) {
        
        if(nums==null ||nums.length==0) return new int[]{-1,-1};
        int n= nums.length;
        if(nums[0]>target || nums[n-1]<target) return new int[]{-1,-1};
        int first= binarySearchFirst(nums,target);
        if(first==-1) return new int[]{-1,-1};
        int last= binarySearchLast(nums, first, n-1, target);
        if(last==-1) return new int[]{-1,-1};
        return new int[]{first,last};
    }
    
    private static int binarySearchFirst(int[] nums, int target){
        int n= nums.length;
        int low=0;
        int high=n-1;
        while(low<=high){
            int mid= low+ (high-low)/2;
            if(nums[mid]==target){
                if(mid==0 || nums[mid]>nums[mid-1])
                    return mid;
                else high=mid-1;
            }
            else if(nums[mid]>target){
                high=mid-1;
            }
            else low= mid+1;
        }
        return -1;
    }
    
    private static int binarySearchLast(int[] nums,int low,int high, int 
target){
        int n= nums.length;
        while(low<=high){
            int mid= low+ (high-low)/2;
            if(nums[mid]==target){
                if(mid==n-1 || nums[mid]< nums[mid+1]) return mid;
                else
                    low= mid+1;
            }
            else if(nums[mid]>target){
                high=mid-1;
            }else{
                low=mid+1;
            }
        }
        return -1;
    }
}
