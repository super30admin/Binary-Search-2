class Solution {
    public int[] searchRange(int[] nums, int target) {
        int n = nums.length;
        if(nums == null || nums.length == 0 ) return new int [] {-1,-1} ;
        if(nums[0]>target) return new int [] {-1,-1} ;
      int first = bsFirst(nums, target,0, n-1);
    if(first == -1)   {
          //element was not found 
          return new int [] {-1,-1};} 
    else{
        int last = bsLast(nums, target, first, n-1);
        return new int[] {first,last}; 
        }
      }
    
    private int bsFirst(int[]nums, int target, int low, int high)   {
        while(low<=high){
            int mid = low + (high-low)/2;
            if(nums[mid] == target){
               if(mid==low || nums[mid-1]<target) return mid;
            else
            high = mid-1;

            }
            else if(nums[mid]>target){
                high=mid-1;
            }
            else{
                low=mid+1;
            }
        }
    return -1;
    }

    private int bsLast(int[]nums, int target, int low, int high)   {
        while(low<=high){
            int mid = low + (high-low)/2;
            if(nums[mid] == target){
                if(mid== high || nums[mid+1]>target){
                    return mid;
                }
                else
                low = mid+1;
            }
            else if (nums[mid]>target){
                high = mid-1;
            }
        }
    return -1;
    }
}