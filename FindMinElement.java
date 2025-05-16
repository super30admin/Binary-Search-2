// Time Complexity : O(log n)
// Space Complexity : O(1)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No

class FindMinElement {
    public int findMin(int[] nums) {
        int high = nums.length - 1;
        int low = 0;

        while(low < high){
            int mid = low + (high - low)/2;
              if(nums[low] < nums[high]  ){
                return nums[low];
            }
            
            
            if(nums[mid] >= nums[high] ){
                low = mid +1 ;
            }
            else if(nums[mid] < nums[high]){
                high = mid;
            } 
            else if(nums[mid] < nums[low] ){
                high = mid -1 ;
            }
            else if(nums[mid] >= nums[low]){
                low = mid;
            } 
        }
       if(nums[low] == nums[high]) return nums[low];
       
        return -1;
    }

    public static void main(){
        int[] nums = [3,4,5,1,2];
        FindMinElement min = new FindMinElement();
        int minNum = min.findMin(nums);

        system.out.print('Min : '+minNum);

        nums = [4,5,6,7,0,1,2];
        minNum = min.findMin(nums);

        system.out.print('Min : '+minNum);

        nums = [11,13,15,17];
        minNum = min.findMin(nums);

        system.out.print('Min : '+minNum);

        nums = [1];
        minNum = min.findMin(nums);

        system.out.print('Min : '+minNum);

        nums = [3,1,2];
        minNum = min.(nums);

        system.out.print('Min : '+minNum);

        nums = [5,1,2,3,4];
        minNum = min.findMin(nums);

        system.out.print('Min : '+minNum);

    }
}