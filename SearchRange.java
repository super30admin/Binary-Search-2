public class SearchRange {
    private int binarySearchFirst(int[] nums, int target, int low, int high){
        while(low<=high){
            int mid = low + (high-low)/2;
            if(nums[mid]==target){
                //check its neighbours
                if(mid==0 || nums[mid] > nums[mid-1]){
                    return mid;
                }else{
                    high = mid-1;
                }
            } else if (nums[mid] > target){
                high=mid-1;
            }else{
                low=mid+1;
            }
        }
        return -1;
    }
    private int binarySearchLast(int[] nums, int target, int low, int high){
        while(low<=high){
            int mid = low + (high-low)/2;
            if(nums[mid]==target){
                //check its neighbours
                if(mid == nums.length-1 || nums[mid] < nums[mid+1]){
                    return mid;
                }else{
                    low = mid+1;
                }
            } else if (nums[mid] > target){
                high=mid-1;
            }else{
                low=mid+1;
            }
        }
        return -1;
    }
    public int[] searchRange(int[] nums, int target) {
        int n = nums.length;
        int low = 0;
        int high = n-1;
        int mid = 0;
        //if target is < or > first and last element then no need to check further
        if(n==0 || target<nums[0] || target>nums[n-1]){
            return new int []{-1,-1};
        }
        int first = binarySearchFirst(nums, target, low, high);
        //if target not found with first binary search then return -1
        if(first == -1) return new int[]{-1,-1};

        int last = binarySearchLast(nums, target, first, high);
        return new int[]{first, last};
    }
}

//Time complexity : O(log n)
//Space complexity : O(1)