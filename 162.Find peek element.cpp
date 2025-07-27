class Solution {
public:
    int findPeakElement(vector<int>& nums) {
        int l =0;
        int h = nums.size()-1;
        int n =h;//to check edge case if mid is last index
        while(l<=h)
        {
            int mid = l+(h-l)/2;
            if((mid==0||nums[mid]>nums[mid-1])&&(mid==n||nums[mid]>nums[mid+1]))//in case single element or the last element checking m+1 or m-1 give wromg answer
             return mid;
            else if(mid<n && nums[mid]>nums[mid+1])//1st check is added if l=m=h and consider increasing neighbour and elimainate other half bcz eventually it will readuce or reach neg infinity
              h =mid-1;
            else
              l= mid+1;
             
        }
        return -1;
    }
};