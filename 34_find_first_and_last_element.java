class Solution {
    public int[] searchRange(int[] nums, int target) {
        int first = binarySearchFirst(nums,0,nums.length-1,target);
        if (first==-1) return new int[]{-1,-1};
        int last = binarySearchLast(nums, first, nums.length - 1, target);
        return new int[]{first, last};
    }
    private int binarySearchFirst(int[] nums,int low,int high, int target){
        while(low<=high){
            int mid = low + (high - low)/2;
            if(nums[mid] == target){
                if(mid == 0 || nums[mid-1] != target){
                    return mid;
                }else{
                    high = mid - 1;
                }}
            else if (nums[mid]>target){
                high = mid - 1;
            }else low = mid+1; 
        }
        return -1;
    }
    private int binarySearchLast(int[] nums,int low,int high, int target){
        while(low<=high){
            int mid = low + (high - low)/2;
            if(nums[mid] == target){
                if(mid == nums.length-1 || nums[mid+1] != target) return mid;
                else low = mid +1;
            }
            else if (nums[mid]>target){
                high = mid - 1;
            }else low = mid+1; 
        }
        return -1;
    }
}

// We used two binary search indivually to find the values for the first and last 
// also for values with just single value it should return the same postion twice - like if 5 appears at 0 -{0,0}