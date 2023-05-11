package BinarySearchTwo;

public class MinRotatedSortedArr {

    public int findMin(int[] nums) {

        int n = nums.length;
        int left = 0, right = n-1;

        while(left <= right) {

            // if the complete range is sorted
            if(nums[left] <= nums[right])
                return nums[left];

            int middle = left + (right - left)/2;
            // middle being the smallest than neighbours
            if ((middle == 0 || nums[middle] < nums[middle - 1])
                    && (nums[middle] < nums[middle + 1])) {
                return nums[middle];
            }
            //// when minimum is the last element we stop at line 10, hence no need to add ... && middle = n-1 or nums[middle] < nums[middle + 1]

            // right side is sorted
            else if(nums[middle] <= nums[right])
                // move search to left
                right = middle - 1;

            else
                left = middle + 1;

        }
        // not found, here return can be given any number like return 1003 and we never reach here because minimum element exists in a sorted (rotated) array
        return -1;
    }

    public static void main(String[] args){

        MinRotatedSortedArr object = new MinRotatedSortedArr();
        int [] rotatedSortedArray = {4,5,6,7,0,1,2};

        int result = object.findMin(rotatedSortedArray);

        System.out.println("result =" +result);
    }
}
