public class FindPeakElement {
//Time Complexity O(logn)
    //Space Complexity O(1)
    //https://leetcode.com/problems/find-peak-element/
    //Try to remove half of elements.
    /*since adjacent elements are not similar there has to be a peak on either sides of middle element
    * so it will be easy if we move in the direction which is greater than the middle element iff middle is not
    * the peak*/
public static void main(String[] args) {
int[] nums = {1,2,1,3,5,6,4};
    System.out.println(findPeakElement(nums));
}
//Brute Force O(n)
/*public static int findPeakElement(int[] nums) {
    if(nums==null||nums.length==0) return -1;
    int second =0;
    for (int i = 1; i <= nums.length+1; i++) {
        int first = i-1;
        int third = i+1;

        if(nums[i]>nums[first] && nums[i]>nums[third]) {second= nums[i];break;}

    }
return second;
}*/
public static int findPeakElement(int[] nums){
    int start = 0;
    int end = nums.length-1;
        while(start<=end){
            int mid= start +(end-start)/2;
            if( (mid==0||nums[mid]>nums[mid-1])&&(mid==nums.length-1|| nums[mid]>nums[mid+1])){
                return mid;
            }
            else if(mid!=0&& nums[mid-1]>nums[mid]){
                end = mid-1;
            }
            else{
                start=mid+1;
            }
        }
        return -1;
    }

}


