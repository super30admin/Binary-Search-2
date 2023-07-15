public class MinumimInSortedArray {
    //Time complexity: O(Log N)
    //Space complexity: Constant
    public int findMin(int[] nums) {

        int begin = 0;
        int end = nums.length - 1;

        if(nums[begin] <= nums[end]){
            //array is not rotated
            return nums[begin];
        }

        while(begin < end){
            int mid = (begin + end)/2;
            if(nums[mid] > nums[mid + 1]){
                return nums[mid + 1];
            }
            if(nums[begin] > nums[mid]){
                end = mid;
            }
            else{
                begin = mid + 1;
            }
        }
        return -1;
    }
}
