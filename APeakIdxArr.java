package BinarySearchTwo;

public class APeakIdxArr {

        public int findPeakElement(int[] nums) {

            int n = nums.length;
            int left = 0, right = n-1;

            while(left <= right) {

                int middle = left + (right - left)/2;

                // check if mid is greater than its neighbors
                if((middle == 0 || nums[middle] > nums[middle-1]) &&
                        (middle == n-1 || nums[middle] > nums[middle+1])) {
                    return middle;
                }
                // shift search towards the side having element greater than middle which guarantees the existence of a peak
                else if (nums[middle] < nums[middle + 1])
                    left = middle +1;

                else
                    right = middle -1;
            }

            return 98;

        }

        public static void main(String[] args) {
            APeakIdxArr object = new APeakIdxArr();
            int[] searchArray = {1,2,1,3,5,6,4};
            // {1,2,1,3,5,6,4}
            int result = object.findPeakElement(searchArray);
            System.out.println("result = "+result);
        }

    }
