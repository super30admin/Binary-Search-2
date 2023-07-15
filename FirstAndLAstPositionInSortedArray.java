public class FirstAndLAstPositionInSortedArray {

    //linear search
    //Time complexity O(N)
    //Space complexity constant
     public int[] searchRangeLinearSearch(int[] nums, int target) {
         if(nums.length == 0 || target > nums[nums.length - 1] || target < nums[0]){
             return new int[]{-1, -1};
         }

         int begin = 0;
         int end = nums.length - 1;

         while(begin < end && (nums[begin] != target || nums[end] != target)){
             if(nums[begin] != target && nums[begin] < target){
                 begin++;
             }
             if(nums[end] != target && nums[end] > target){
                 end--;
             }
         }
         if(nums[begin] == target && nums[end] == target){
             return new int[]{begin, end};
         }
         return new int[]{-1, -1};

     }

    //binary search
    //Time complexity O(log N)
    //Space complexity constant
    public int[] searchRangeBinarySearch(int[] nums, int target) {

        // find index of any occurrence of target

        int index = binarySearch(nums, 0, nums.length - 1, target);

        int leftIndex = index - 1;
        int rightIndex = index + 1;

        while((leftIndex >= 0 && nums[leftIndex] == target) || (rightIndex < nums.length && nums[rightIndex] == target)){
            if(leftIndex >=0 && nums[leftIndex] == target){
                int newLeftIndex = binarySearch(nums, 0, leftIndex, target);
                leftIndex = newLeftIndex - 1;
            }
            if(rightIndex < nums.length && nums[rightIndex] == target){
                int newRightIndex = binarySearch(nums, rightIndex, nums.length - 1, target);
                rightIndex = newRightIndex + 1;
            }

        }

        return new int[]{ leftIndex +1, rightIndex - 1};

    }

    private int binarySearch(int[] nums, int begin, int end, int target){

        if(begin > end){
            return -1;
        }
        int mid = (begin + end)/2;
        if(nums[mid] == target){
            return mid;
        }
        if(nums[mid] > target){
            return binarySearch(nums, begin, mid - 1, target);
        }
        else{
            return binarySearch(nums, mid + 1, end, target);
        }

    }
}
