// Time Complexity: O(log n)
// Space Complexity: O(1)
// Did this code run on LeetCode? Yes
// Any problems faced while coding? No

//Approach: I applied binary search to find a peak element. 
//At each step, I check if the current mid element is greater than its neighbors — if so, it’s a peak and I return it. 
//Otherwise, I move in the direction of the greater neighbor, as a peak is guaranteed to exist there.

public class FindMinElement {
    public int findMin(int[] nums){
        int low = 0, high = nums.length - 1;

        while(low <= high){
            int mid = low + (high - low)/2;

            if((mid == 0 || nums[mid] > nums[mid - 1]) && (mid == nums.length - 1 || nums[mid] > nums[mid + 1])){
                return mid;
            }else if(nums[mid] < nums[mid + 1]){
                low = mid + 1;
            }else{
                high = mid - 1;
            }
        }
        return -1;
    }
}
