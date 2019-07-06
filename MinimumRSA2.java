public class MinimumRSA2 {
    public int findMin(int[] nums) {
        return search(nums,0,nums.length-1);
    }
    public int search(int[] nums,int start,int end){
        while(start<=end){
            if(nums[start]<nums[end])
                return nums[start];
            int mid = start + (end-start)/2;
            if((mid==0|| nums[mid]<=nums[mid-1]) && (mid==nums.length-1 || nums[mid]<=nums[mid+1])){
                return nums[mid];
            }
            if(nums[mid]<nums[end])
                end = mid-1;
            else
                start=mid+1;
        }
        return nums[end];
    }
    public static void main(String[] args) {
        MinimumRSA2 obj = new MinimumRSA2();
        int[] x = new int[]{4,5,1,2,3};
        System.out.println(obj.findMin(x));
    }
}
