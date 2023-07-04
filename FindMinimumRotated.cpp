#include<iostream>
#include<vector>

using namespace std;

class FindMinimumRotated {
public:
    int findMin(vector<int>& nums) {
        if(nums.size()==0){
            return -1;

        }
        int low=0;
        int high=nums.size()-1;

        while(low<=high){
            int mid = (low+high)/2;
            if(nums[low]<=nums[high]){
                return nums[low];
            }
            if(((mid==0 )|| (nums[mid]<nums[mid-1]))&&(mid==high||nums[mid]<nums[mid+1])){

                return nums[mid];


            }
            //this condition means sorted array is rotated to the left by n times,
            else if(nums[low]<=nums[mid]){
                low = mid+1;

            }
            //this condition means sorted array is rotated to the right by n times,
            else if(nums[low]>nums[mid]){
                high = mid-1;



            }




        }
        return -1;
        
    }
};



