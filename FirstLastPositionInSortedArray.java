// TC: o(log n)
//SC : o(1)

class Solution {
    public int[] searchRange(int[] nums, int target) {
        int[] result = {-1,-1};
        if(nums == null || nums.length == 0){
            return result;
        }
        int first = binarySearchFirst(nums,target);
        int second = binarySearchSecond(nums,target);
        if(first > -1) result[0] = first;
        if(second > -1) result[1] = second;
        return result;
    }

    public int binarySearchFirst(int[] nums, int target){
        int low = 0;
        int high = nums.length-1;
        int index = -1;
        while(low <= high){
            int mid = low + (high-low)/2;
            if(nums[mid] == target){
                index = mid;
                high = mid -1;
            }
            else if(nums[mid] < target){
                low = mid + 1;
            }
            else{
                high = mid -1;
            }
        }
        return index;
    }
    public int binarySearchSecond(int[] nums, int target){
        int low = 0;
        int high = nums.length-1;
        int index = -1;
        while(low <= high){
            int mid = low + (high-low)/2;
            if(nums[mid] == target){
                index = mid;
                low = mid + 1;
            }
            else if(nums[mid] < target){
                low = mid + 1;
            }
            else{
                high = mid -1;
            }
        }
        return index;
    }


}