public class Problem1 {
    // o(log(n))
    public int[] searchRange(int[] nums, int target) {
        int n = nums.length;
        int low = 0;
        int high = n-1;

        int lowIndex = binarySearchLeft(nums, target, low, high);
        int highIndex = binarySearchRight(nums, target, low, high);


        return new int[]{lowIndex, highIndex};

    }

    int binarySearchLeft(int [] nums, int target, int low, int high){

        while(low <= high){
            int mid = low + (high - low)/2;

            if(nums[mid] == target){

                if( mid == 0 || nums[mid] > nums[mid-1]){
                    return mid;
                }
                else{
                    high = mid-1;
                }
            }

            else if(nums[mid] < target){
                low = mid + 1;
            }
            else{
                high = mid -1;
            }
        }
        return -1;
    }

    int binarySearchRight(int [] nums, int target, int low, int high){

        while(low <= high){
            int mid = low + (high - low)/2;

            if(nums[mid] == target){

                if( mid == nums.length - 1 || nums[mid] < nums[mid+1]){
                    return mid;
                }
                else{
                    low = mid+1;
                }
            }

            else if(nums[mid] > target){
                high = mid -1;
            }
            else{
                low = mid +1;
            }
        }
        return -1;
    }
}
