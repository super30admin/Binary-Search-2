public class MinimumRSA {
    public int findMin(int[] nums) {
        return search(nums,0,nums.length-1);
    }
    public int search(int[] nums,int start,int end){
        if(start>end)
            return -1;
        int mid = start+(end-start)/2;
        if(nums[mid]<=nums[start]&& nums[mid]<=nums[end]){
            if(end-start<=2)
                return nums[mid];
            else{
                start = start+1;
                end = end - 1;
                return search(nums,start,end);
            }
        }

        if(nums[mid]>=nums[start] ){
            if(nums[mid]>=nums[end])
                start = mid+1;
            else
                end = mid-1;
        }else{
            if(nums[mid]<=nums[end])
                end = mid-1;
            else
                start = mid+1;
        }
        return search(nums,start,end);
    }
    public static void main(String[] args) {
        MinimumRSA obj = new MinimumRSA();
        int[] x = new int[]{4,5,1,2,3};
        System.out.println(obj.findMin(x));
    }
}
