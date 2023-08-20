//Time comlexity O(log n)
//Space Complexity O(1)
public class FindPeak {
    public int findPeak(int[] nums){
        int n=nums.length;
        int low=0;
        int high=n-1;
        while(low<=high){
            int mid=low+(high-low)/2;
            if((mid==0 || nums[mid]>nums[mid-1]) &&
                    (mid==n-1 || nums[mid]>nums[mid+1])){
                return mid;
            }
            else if(mid>0 && nums[mid-1]>nums[mid]){
                high=mid-1;
            }
            else
                low=mid+1;
        }
        return n+2;
    }

    public static void main(String[] args) {
        FindPeak findPeak=new FindPeak();
        System.out.println(findPeak.findPeak(new int[]{1,2,3,1}));
    }
}
