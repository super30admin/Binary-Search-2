public class FindPeakElement {

    //Time Complexity: O(LogN)
    //Space Complexity: Constant
    public int findPeakElement(int[] nums) {
        if(nums.length == 1){
            return 0;
        }
        if(nums.length < 3){
            return nums[0] > nums[1]? 0: 1;
        }
        int begin = 0;
        int end = nums.length - 1;

        while(begin <= end){
            int mid = (begin + end)/2;
            //match case
            if((mid == 0 && nums[mid] > nums[mid +1]) ||
                    (mid == nums.length - 1 && nums[mid - 1] < nums[mid])
                    || (nums[mid - 1]  < nums[mid] && nums[mid] > nums[mid + 1])) return mid;


            if(nums[mid] > nums[mid + 1]){
                end = mid;
            }
            else if(nums[mid] < nums[mid + 1]){
                begin = mid + 1;
            }
        }

        return 0;

    }
}
