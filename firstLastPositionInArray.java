// time: 2log(n) = log(n)
// space: O(1)
// Did this code successfully run on Leetcode : yes
// Any problem you faced while coding this : no

class firstLastPositionInArray {
    public int[] searchRange(int[] nums, int target) {
        //if input is empty
        if(nums==null || nums.length==0) return new int[]{-1,-1};

        //fetching first occurence of target
        int low = bsLeft(nums, target, 0, nums.length-1);

        //if target not found on
        if(low==-1) return new int[]{-1,-1};

        //fetching last occurence of target
        int high = bsRight(nums, target, 0, nums.length-1);

        return new int[]{low, high};
    }

    //returns first occurence of target
    public int bsLeft(int[] nums, int target, int low, int high) {

        //if valid search space
        while(low<=high){

            //calculate mid
            int mid=low+(high-low)/2;

            //if target found
            if(nums[mid]==target){
                //if target at index 0 or number previous to target is not equal to target
                if(mid==0||nums[mid-1]!=target)
                {
                    return mid;
                }

                //move to the left
                else{
                    high = mid-1;
                }
            }
            // if target less then mid
            else if(target<nums[mid]){
                high = mid-1;
            }
            // target greater than mid
            else{
                low = mid+1;
            }
        }
        return -1;
    }

    //returns last occurence of target
    public int bsRight(int[] nums, int target, int low, int high) {

        //if valid search space
        while(low<=high){

            //calculate mid
            int mid=low+(high-low)/2;

            //if target found
            if(nums[mid]==target){

                //if target at index 0 or number previous to target is not equal to target
                if(mid==nums.length-1||nums[mid+1]!=target){ return mid;}
                //move to the right
                else{
                    low= mid+1;
                }
            }
            // if target less then mid
            else if(target<nums[mid]){
                high = mid-1;
            }
            // target greater than mid
            else{
                low = mid+1;
            }
        }
        return -1;
    }
}