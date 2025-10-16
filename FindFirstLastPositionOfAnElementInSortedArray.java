/*
Time Complexity: O(log(n))
Space Complexity: O(1)
 */
public class FindFirstLastPositionOfAnElementInSortedArray {
    public int[] searchRange(int[] nums, int target) {
        int[] result= new int[2];
        // Create a two bnary searches to find min and max indexes
        result[0] = firstIndexBinarySearch(0, nums.length -1,nums, target);
        result[1] = lastIndexBinarySearch(0, nums.length -1,nums, target);

        return result;

    }

    public int firstIndexBinarySearch(int low, int high, int[] nums, int target){
        while(low<=high){
            // Finding mid
            int mid= low+(high-low)/2;
            // If an element at index mid is the target
            if(nums[mid] == target){
                // Check if the element is at index 0 or the element before it is less than the element
                if(mid == 0 || nums[mid-1]!=target){
                    // Then that is the first index
                    return mid;
                }
                // Else the first index will be in the left half, reduce the search space by 1/2
                else{
                    high = mid -1;
                }
            }
            // Else reduce the search space by 1/2 by checking if the target is on left or right half
            else if(nums[mid]< target){
                low = mid+1;
            }
            else{
                high = mid-1;
            }


        }
        return -1;
    }

    public int lastIndexBinarySearch(int low, int high, int[] nums, int target){
        while(low<=high){
            // Finding mid
            int mid= low+(high-low)/2;
            // If an element at index mid is the target
            if(nums[mid] == target){
                // Check if the element is at last index or the element after it is greater than the element
                if(mid == nums.length-1 || nums[mid+1] != nums[mid]){
                    // Then that is the first index
                    return mid;
                }
                else{
                    // Else the last index will be in the right half, reduce the search space by 1/2
                    low = mid +1;
                }
            }
            // Else reduce the search space by 1/2 by checking if the target is on left or right half
            else if(nums[mid]< target){
                low = mid+1;
            }
            else{
                high = mid-1;
            }
        }
        return -1;

    }
}
