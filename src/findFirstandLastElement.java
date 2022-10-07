// Time Complexity: log(n);
// Space Complexity: o(1);
// Did it run on leetcode: Yes
// Problems faced: No

public class findFirstandLastElement {

    public int[] searchRange(int[] nums, int target) {

        if(nums == null || nums.length ==0 ){
            return new int[]{-1,-1};
        }


        if( nums[0] > target || nums[nums.length-1] < target ){
            return new int[]{-1,-1};
        }

        int first = helper1(nums,0, nums.length-1, target);

        if( first == -1){
            return new int[]{-1,-1};
        }

        int last = helper2(nums,first, nums.length-1, target);

        return new int[]{first,last};

    }

    public int helper1(int[] nums, int low, int high, int target){

        while(low<=high){

            int mid= low + (high-low)/2;
            if( nums[mid] == target){

                if(mid ==0 || nums[mid] > nums[mid-1]){
                    return mid;
                }else{
                    high = mid-1;
                }

            }else if( nums[mid] > target){
                high = mid-1;
            }else{
                low = mid+1;
            }

        }

        return -1;
    }

    public int helper2(int[] nums, int low, int high, int target){

        while(low<=high){

            int mid= low + (high-low)/2;
            if( nums[mid] == target){

                if(mid ==nums.length-1 || nums[mid] < nums[mid+1]){
                    return mid;
                }else{
                    low = mid+1;
                }

            }else if( nums[mid] > target){
                high = mid-1;
            }else{
                low = mid+1;
            }

        }

        return -1;
    }


}
