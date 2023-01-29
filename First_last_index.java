// problem 34

class Solution {

    public int secondBS(int low,int high,int[]nums,int target){
        while(low<=high){
            int mid = low + (high-low)/2;
            if(nums[mid]==target){ // check again if it is the last occurence
                if(mid == nums.length - 1 || nums[mid+1]>target){
                    return mid;
                }
                else{
                    low = mid + 1; // check for first occ on left side
                }
            }
            else if(nums[mid]<target){
                low = mid + 1;
            }
            else{
                high = mid - 1;
            }
        }
        return -1;
    }


    public int firstBS(int low,int high,int[]nums,int target){
        while(low<=high){
            int mid = low + (high-low)/2;
            if(nums[mid]==target){ // check again if it is the first occurence
                if(mid == 0 || nums[mid-1]<target){
                    return mid;
                }
                else{
                    high = mid - 1; // check for first occ on left side
                }
            }
            else if(nums[mid]<target){
                low = mid + 1;
            }
            else{
                high = mid - 1;
            }
        }
        return -1;
    }

    public int[] searchRange(int[] nums, int target) {
        if (nums == null || nums.length == 0){return new int[]{-1,-1};}
        int n = nums.length;
        if(nums[0]>target || nums[n-1]<target){return new int[]{-1,-1};}
        int low = 0;
        int high = n-1;
        int first = firstBS(low,high,nums,target);
        int second = secondBS(first,high,nums,target);//search space is from first occ to end
        return new int[]{first,second};
    }
}