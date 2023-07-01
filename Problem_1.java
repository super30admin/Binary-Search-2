public class Problem_1 {
    private int binarySearchFirst(int[] nums, int target){
        int n = nums.length;
        int low=0, high=n-1, mid=0;
        while(low<=high){
            mid = low + (high-low)/2;
            if(nums[mid] == target){
                if(mid ==0 || nums[mid] > nums[mid-1]){
                    return mid;
                } else {
                    high = mid-1;
                }
            } else if(nums[mid] < target){
                //target is in right half
                low = mid+1;
            } else {
                high = mid - 1;
            }
        }
        return -1;
    }

    private int binarySearchLast(int[] nums, int low, int high, int target){
        int n = nums.length;
        int mid=0;
        while(low<=high){
            mid = low + (high-low)/2;
            if(nums[mid] == target){
                if(mid ==n-1 || nums[mid] < nums[mid+1]){
                    return mid;
                } else {
                    low = mid+1;
                }
            } else if(nums[mid] < target){
                //target is in right half
                low = mid+1;
            } else {
                high = mid - 1;
            }
        }
        return -1;
    }

    public int[] searchRange(int[] nums, int target) {
        int first = -1, last = -1;
        if(nums==null || nums.length==0)    return new int[]{-1,-1};
        int n = nums.length;
        if(nums[0] > target || nums[n-1] < target) return new int[]{-1,-1};
        first = binarySearchFirst(nums, target);
        if(first == -1)  return new int[]{-1,-1};
        last = binarySearchLast(nums, first, n-1, target);
        return new int[]{first, last};
    }
}