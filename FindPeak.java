public class FindPeak {
    public int findPeakElement(int[] nums) {
        int n=nums.length;
        if(nums.length == 1) return 0;
        if(nums[0] > nums[1]) return 0;
        if(nums[n-1] > nums[n-2]) return n-1;
        int start=1, end=n-2, mid=0;
        while(start<=end){
            mid = start + (end-start)/2;
            if(nums[mid-1]<nums[mid] && nums[mid+1]<nums[mid]){
                return mid;
            }
            else if(nums[mid] < nums[mid+1]){
                start = mid+1;
            }
            else{
                end = mid-1;
            }
        }
        return mid;
    }

    public static void main(String[] args) {
        FindPeak obj = new FindPeak();
        int[] nums = new int[]{0,5,6,3,9,2,1,23,4,12,44,67,31};
        int res = obj.findPeakElement(nums);
        System.out.println("result = " + res);
    }
}
