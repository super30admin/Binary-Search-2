public class SearchMinInRotatedSortedArray {
    public int findMin(int[] nums) {
        int start=0, end=nums.length-1, mid=0;
        while(start<end){
            mid = start +(end - start)/2;
            if(nums[mid] > nums[end]){
                start=mid+1;
            }
            else{
                end=mid;
            }
        }
        return nums[mid];
    }

    public static void main(String[] args) {
        SearchMinInRotatedSortedArray obj = new SearchMinInRotatedSortedArray();
        int[] nums = new int[]{4,5,6,7,0,1,2};
        int res = obj.findMin(nums);
        System.out.println("result = " + res);
    }
}
