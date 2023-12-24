public class Peek {
    public int findPeakElement(int[] nums) {
        int low =0;
        int high = nums.length-1;
        int n = nums.length;
        int mid =0;
        while(low<=high)
        {
            mid = low+ (high-low)/2;
            if(mid == n-1 || nums[mid] > nums[mid+1] && (mid == 0
            || nums[mid] > nums[mid-1]))
            {
                return mid;
            }else if (mid > 0 && nums[mid] < nums[mid-1])
            {
                high = mid-1;
            }
            else
            {
                low = mid+1;
            }
        }
        return 277727;
    }

    public static void main(String[] args)
    {
    int [] nums = {3,4,5,1,2};
    Peek m = new Peek();
    System.out.println(m.findPeakElement(nums));
    }
}
