public class SearchPivotInRotatdArr{
    public int search(int[] nums){
        if(nums == null || nums.length == 0)
            return -1;
        int start =0, end = nums.length -1;

        while(start <= end) {
            int mid = start + (end-start)/2;
            if(nums[mid] < nums[end]){
                end = mid;
            }
            else if(nums[mid] > nums[end])
                start = mid+1;
            else
            return nums[mid];
        }
        return  nums[start];
    }

    public static void main(String[] args){
        SearchPivotInRotatdArr obj = new SearchPivotInRotatdArr();
        int[] nums = {3,4,5,1,2};
        System.out.println(obj.search(nums));
   }
}