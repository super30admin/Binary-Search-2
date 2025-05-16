// Time Complexity : O(log n)
// Space Complexity : O(1)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No

class FirstAndLastPosition {
    public int[] searchRange(int[] nums, int target) {
        int low = 0;
        int high = nums.length - 1;

        while(low < high){
            int mid = low + (high - low)/2;
            if(nums[mid] == target){
                int start = mid;
                int end = mid;
                while(start > 0 && nums[start-1] == target){
                    start --;
                }
                while(end < nums.length-1 && nums[end+1] == target){
                    end++;
                }

                return new int[]{start,end};
            }

           

            if(nums[mid] < target){
                low = mid + 1;
            }
            else{
                high = mid - 1;
            }

            
        }

     if(low == high && nums[low] == target) return new int[]{low,low};

        return new int[]{-1,-1};
    }

    public static void main(){
        FirstAndLastPosition position = new FirstAndLastPosition();
        int[] nums = [5,7,7,8,8,10];
        int target = 8;
        int[] pos = position.searchRange(nums,target);
        system.out.print('position : '+pos);

        nums = [5,7,7,8,8,10];
        target = 6;
        pos = position.searchRange(nums,target);
        system.out.print('position : '+pos);

        nums = [];
        target = 0;
        pos = position.searchRange(nums,target);
        system.out.print('position : '+pos);

        nums = [1];
        target = 1;
        pos = position.searchRange(nums,target);
        system.out.print('position : '+pos); 

        nums = [2,2];
        target = 2;
        pos = position.searchRange(nums,target);
        system.out.print('position : '+pos); 

        nums = [1,4];
        target = 4;
        pos = position.searchRange(nums,target);
        system.out.print('position : '+pos);  

        nums = [1,2,3];
        target = 1;
        pos = position.searchRange(nums,target);
        system.out.print('position : '+pos);        
    }
}