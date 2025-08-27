// First -  Do binary search to find the left most/start index.
// Second - Again do binary search to find right most index

//Time Complexity  O(2 log n) -> O(log n) (* as constants can be ignored)
//Space Complexity O(1)


class Solution {
    public int[] searchRange(int[] nums, int target) {
         int first = binarySearchFirst(nums, 0, nums.length-1, target);
         if(first==-1){
            return new int[]{-1,-1};
         }
         int second = binarySearchSecond(nums, first, nums.length-1, target);

         return new int[]{first,second};
    }


    int binarySearchFirst(int[] nums, int low, int high, int target){    // Time O(log n)
        int result = -1;
        while(low<=high){
            int mid = low + (high-low)/2;
           // check if mid index valu is target
            if(nums[mid] == target){

              // check if it is not starting index of array and left most is not target
                if(mid!=0 && nums[mid-1] == target){
                    result = mid;
                    high= mid-1;
                }
                else{
                    return mid;
                }
            }
            else if(nums[mid] > target){
                high = mid-1;
            }
            else if(nums[mid]< target){
                low = mid+1;
            }

        }
        return result;
    }


    int binarySearchSecond(int[] nums, int low, int high, int target){
        int result = -1;
        while(low<=high){
            int mid = low + (high-low)/2;
            
            if(nums[mid] == target){
                if(mid!=nums.length-1 && nums[mid+1] == target){
                    result = mid;
                    low= mid+1;
                }
                else{
                    return mid;
                }
            }
            else if(nums[mid] > target){
                high = mid-1;
            }
            else if(nums[mid]< target){
                low = mid+1;
            }

        }
        return result;
    }
}
