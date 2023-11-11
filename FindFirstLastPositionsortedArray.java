//Time complexity : O(log n)
//Space Complexity : O(1)
class Solution {
    public int[] searchRange(int[] nums, int target) {
        int [] index = {-1,-1};
        if(nums == null || nums.length == 0)
            return  index;
        //if target does not exist
        if(target < nums[0] || target > nums[nums.length -1])
             return  index;
        //Find first index
        int first  = BinarySearchFirst(nums,target);
        if(first == -1 ) return index;
        else index[0] = first;

        //Find last index 
        int second = BinarySearchLast(nums,target,first);
        index[1] = second;

        return index;
    
    }

    private int BinarySearchFirst(int[] nums, int target){
        int low = 0, high = nums.length-1,mid;
        while(low<=high){
            mid = low+(high - low)/2;
            if(nums[mid] == target){
                if(mid == low || nums[mid] != nums[mid -1 ])
                    return mid;
                else
                    high = mid - 1;
            }
            else if (nums[mid]> target)
                high = mid -1;
            else
                low = mid +1;

        }
        return -1;
    }

    private int BinarySearchLast(int[] nums, int target,int startIndex){
        int low = startIndex, high = nums.length-1,mid;
        while(low<=high){
            mid = low+(high - low)/2;
            if(nums[mid] == target){
                if(mid == high || nums[mid] != nums[mid + 1 ])
                   return mid;
                else
                    low = mid +1;
            }
            else if (nums[mid]> target)
                high = mid -1;
            else
                low = mid +1;

        }
        return -1;
    }
}