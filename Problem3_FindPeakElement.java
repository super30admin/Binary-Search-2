// Base condition is if the array has only one element, return 0 index

// Peak is when the element is greater than its neighbors, so check if left and right elements of mid are smaller

// If not satisfied, move to the right half of the array in binary search if right element of the mid is greater than mid
// hoping to find the peak as we are moving to the increasing order, else move to the left half of the array

class Problem3_FindPeakElement {
    public int findPeakElement(int[] nums) {
        int n=nums.length;
        int l=0, r=n-1, m;
        if(nums.length==1)  return 0;
        while(l<=r){
            m=l+(r-l)/2;
            if((m==0 || nums[m-1]<nums[m]) && (m==n-1 || nums[m]>nums[m+1])){
                return m;
            }else if(m==n-1 || nums[m]<nums[m+1]){
                l=m+1;
            }else{
                r=m-1;
            }
        }
        return -1;
    }
}