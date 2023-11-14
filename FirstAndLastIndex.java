// Time Complexity : O(log(n))
// Space Complexity : O(1)
// Did this code successfully run on Leetcode : yes
// Any problem you faced while coding this : No


// Your code here along with comments explaining your approach in three sentences only
//Split the code logic into 3 parts. 1.when you find the mid elem as the target, divide the
//array into 2 parts and perform binary search on each half to get the first index and the last index
//if the mid element is not target, then adjust left and right pointers accordingly to get the range
//closer to the target
class FirstAndLastIndex {
    public int[] searchRange(int[] nums, int target) {

        if(nums == null || nums.length == 0) return new int[]{-1,-1};
        if(nums.length == 1 && nums[0] == target) return new int[]{0,0};

        int low = 0 ;
        int high = nums.length-1;
        int arr[] = new int[2];
        while(low <= high){
            int mid = low + (high-low)/2;
            if(nums[mid] == target){
                if(mid == 0 || nums[mid-1]<nums[mid]){
                    arr[0] = mid;
                    arr[1] = rightIndex(mid+1,high,nums,target);
                    if(arr[1] == -1) arr[1] = mid;
                    return arr;
                } else if(mid == nums.length-1 || nums[mid+1] > nums[mid] ){
                    arr[1] = mid;
                    arr[0] = leftIndex(low,mid-1,nums,target);
                    if(arr[0] == -1) arr[0] = mid;
                    return arr;
                } else{
                    arr[0] = leftIndex(low,mid-1,nums,target);
                    arr[1] = rightIndex(mid+1,high,nums,target);
                    return arr;
                }
            } else if(target > nums[mid]){
                low = mid+1;
            } else {
                high = mid-1;
            }
        }
        return new int[]{-1,-1};


    }

    public int leftIndex(int low, int high, int[]nums, int target){
        int ind = -1;
        while(low<=high){
            int mid = low + (high-low)/2;
            if(nums[mid]>=target){
                high = mid-1;
            } else {
                low = mid+1;
            }
            if(nums[mid] == target) ind = mid;
        }
        return ind;
    }

    public int rightIndex(int low, int high, int[]nums, int target){
        int ind = -1;
        while(low<=high){
            int mid = low + (high-low)/2;
            if(nums[mid]<=target){
                low = mid+1;
            } else {
                high = mid-1;
            }
            if(nums[mid] == target) ind = mid;
        }
        return ind;
    }
}