public class PeakElement {
    public static void main(String[] args) {
        int[] x = new int[]{1};
        int y = peak(x);
        System.out.println(y);
    }

    public static int peak(int[] nums) {
        if(nums.length==1)
            return 0;
        return binarySearch(nums,0,nums.length-1);
    }
    public static int binarySearch(int[] nums,int start,int end){
        if(start>end)
            return -1;
        int mid = start+(end-start)/2;
        if((mid==0 || nums[mid]>nums[mid-1]) && (mid==nums.length-1 || nums[mid]>nums[mid+1]))
            return mid;
        if(mid>0 && nums[mid]<nums[mid-1])
            return binarySearch(nums,start,mid-1);
        else
            return binarySearch(nums,mid+1,end);
    }
}
