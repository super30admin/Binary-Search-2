//time complexity:o(log(N)
//space complexity:o(1)
public class minval {
    public int findMin(int[] nums) {
        int left=0;
        int n=nums.length;
        int right=n-1;
        while(left<right){
            int mid=left+(right-left)/2;
            if(nums[mid]<nums[right]){
                right =mid;
            }else{
                left=mid+1;
            }
        }
       return nums[left];
    }
}
