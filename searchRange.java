public class searchRange {
    public int[] searchRange(int[] nums, int target) {
        if(nums.length==1){
            if(nums[0]==target)
                return new int[]{0,0};
            else
                return new int[]{-1,-1};
        }
        int[] pos = binarySearch(nums,0,nums.length-1,target);
        return pos;
    }
    public int[] binarySearch(int[] nums,int start,int end,int target){
        if(start>end)
            return new int[]{-1,-1};
        int mid = start+(end-start)/2;
        if(nums[mid]==target){
            int low = mid,high = mid;
            while(low>=start && nums[low]==target  ){
                low--;
            }
            while(high<=end && nums[high]==target ){
                high++;
            }
            return new int[]{low+1,high-1};
        }

        if(nums[mid]>=target){
            return binarySearch(nums,start,mid-1,target);
        }
        else{
            return binarySearch(nums,mid+1,end,target);
        }
    }

    public static void main(String[] args) {
        searchRange obj = new searchRange();
        int[] x = new int[]{5,7,7,8,8,10};
        //System.out.println(x);
        int[] y = obj.searchRange(x,8);
        System.out.println(y[0]+"  "+y[1]);
    }
}
