/*
Binary search

Time : O(log(n))
Space :O(1)
 */
public class FindfirstAndLastElementInArray {
        public static int[] searchRange(int[] nums, int target) {

            int[] output = { -1, -1 };

            // corner cases
            if (nums == null || nums.length == 0) {
                return output;
            }

            int n = nums.length;

            if (target < nums[0] || target > nums[n - 1]) {
                return output;
            }

            int first = binarySearchFirst(nums, 0, n - 1, target);

            if (first == -1) {
                return output;
            } else {
                int second = binarySearchLast(nums, first, n - 1, target);
                output[0] = first;
                output[1] = second;
            }

            return output;
        }

        private static int binarySearchFirst(int[] nums, int low, int high, int target) {

            int n = nums.length;


            while (low <= high) {
                int mid = low + (high - low) / 2;

                if (nums[mid] == target) {
                    //if(mid == 0 || nums[mid] != nums[mid - 1]){ //left side
                    if(mid == low || nums[mid] != nums[mid - 1]){
                        return mid;
                    } else {
                        high = mid - 1;
                    }
                } else if (nums[mid] > target){
                    high = mid - 1;
                } else {
                    low = mid + 1;
                }
            }

            return -1;
        }

        private static int binarySearchLast(int[] nums, int low, int high, int target) {

            int n = nums.length;


            while (low <= high) {
                int mid = low + (high - low) / 2;

                if (nums[mid] == target) {
                    //if((mid == n - 1) ||  nums[mid] != nums[mid + 1]){ //right side
                    if((mid == high) ||  nums[mid] != nums[mid + 1]){ //right side optimized
                        return mid;
                    } else {
                        low = mid + 1; //still go on right
                    }
                } else if (nums[mid] > target){
                    high = mid - 1;
                } else {
                    low = mid + 1;
                }
            }

            return -1;
        }

    public static void main(String[] args) {
            int[] nums = {5,7,7,8,8,10};
            int target = 8;
        for(int i : searchRange(nums, target)){
            System.out.println(" i " + i);
        }
    }
}
