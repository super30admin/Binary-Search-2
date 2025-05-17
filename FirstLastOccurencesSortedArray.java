//Time Complexity: O(logn)
//Space Complexity: O(1)
//Approach: use binary search to find first occurence of target and another binary search to search last occurence of target
class Solution {
    private int binarySearchFirst(int nums[], int low, int high, int target)
    {
        while(low<=high){
            int mid = low + (high-low)/2;
            if(nums[mid]==target){
                if(mid==0||nums[mid-1]!=target){
                    return mid;
                }
                else{
                    high=mid-1;
                }
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
    private int binarySearchLast(int nums[], int low, int high, int target)
    {
        while(low<=high){
            int mid = low + (high-low)/2;
            if(nums[mid]==target){
                if(mid==nums.length-1 || nums[mid+1]!=target){
                    return mid;
                }
                else{
                    low=mid+1;
                }
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
    
    public int[] searchRange(int[] nums, int target) {
        int res[] = new int[2];
        if(nums.length==0){
            res[0] = -1;
            res[1] = -1;
            return res;
        }
        int firstIndex = binarySearchFirst(nums, 0, nums.length-1, target);
        if(firstIndex == -1){
            res[0]=-1;
            res[1]=-1;
            return res;
        }
        int lastIndex = binarySearchLast(nums, firstIndex, nums.length-1, target);
        res[0]=firstIndex;
        res[1]=lastIndex;
        return res;
    }
}