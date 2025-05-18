/* Approach : 
- we will initiate two binary search, One to find first index 
- using firstIndex we will intiate second binary search which will give us last index 
- We are using tis appriach in order to get O(logn) time complexity 
- because if we find first index or last in using binary search and then find other significant indexes using two pointer or linear search it will O(n) time complexity 
Time Complexity- O(logn)
Space complexity - O(1)
*/
class FirstandLastIndexLC34 {
    private int searchFirstIndex(int[] nums,int low, int high, int target){
        while(low<=high){
            int mid = low + (high- low) /2;
            if(nums[mid] == target) {
                if(mid ==0 || nums[mid] > nums[mid-1]) {
                    return mid;
                } else {
                    //reject right because we want to findfirst Index which will always be in left
                    high = mid -1;
                }
            } else if(nums[mid] > target) {
                high = mid-1;
            } else {
                low = mid +1;
            }
        }
        return -1;
    }
    private int searchSecondIndex(int[] nums,int low, int high, int target){
        int n = nums.length;
        while(low<=high){
            int mid = low + (high- low) /2;
            if(nums[mid] == target) {
                if(mid == n-1 || nums[mid] < nums[mid+1]) {
                    return mid;
                } else { //keep moving right because we want to find last index 
                    low = mid +1;
                }
            } else if(nums[mid] > target) {
                high = mid-1;
            } else {
                low = mid +1;
            }
        }
        return -1;
    }
    public int[] searchRange(int[] nums, int target) {
        //base cases
        int n = nums.length;
        if(n == 0 || nums == null) return new int[]{-1,-1};

        if(target < nums[0] || target > nums[n-1]) return new int[]{-1,-1};


        int low= 0, high = n-1;
        int firstIndex = searchFirstIndex(nums,low, high, target);
        if(firstIndex == -1) return new int[]{-1,-1};
        int secondIndex = searchSecondIndex(nums,firstIndex,n-1, target);
        return new int[]{firstIndex, secondIndex};
    }
}