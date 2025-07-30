class Solution {
    public int[] searchRange(int[] nums, int target) {


        // first
        // mid == target save index
        //  check if mid - 1 == target yes --> r = mid -1 no -> return mid
        // target < mid -->  r = mid -1
        // l = mid + 1

        // last


        int l = 0;
        int r = nums.length - 1;
        int mid = 0;
        int res = -1;

        while( l <= r ){
            mid = l + ( r-l )/2;

            if( nums[mid] == target ){
                res = mid;
                if( ( mid -1 >= 0 ) && nums[mid - 1] == target ){
                    r = mid - 1;
                }
                else {
                    break;
                }
            }
            else if( target < nums[mid] ){
                r = mid - 1;
            }
            else{
                l = mid + 1;
            }
        }

        int first = res;

        l = 0;
        r = nums.length - 1;
        mid = 0;
        res = -1;

        while( l <= r ){
            mid = l + ( r-l )/2;

            if( nums[mid] == target ){
                res = mid;
                if( (mid + 1 <=  nums.length - 1) && nums[mid + 1] == target ){
                    l = mid + 1;
                }
                else {
                    break;
                }
            }
            else if( target > nums[mid] ){
                l = mid + 1;

            }
            else{
                r = mid - 1;
            }
        }
        return new int[]{first, res};
    }
}
