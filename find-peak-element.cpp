// Time Complexity : O(log n) your only search either left neighbour or right neighbour
// Space Complexity : O(1) - haven't used any extra space to perform the operations
// Did this code successfully run on Leetcode : yes
// Any problem you faced while coding this : no

// Leetcode(162): https://leetcode.com/problems/find-peak-element/

/*Approach: the solution make use of a binary search:
    The idea is if you want to call your mid element as peak the mid -1 and mid + 1 (left and right neighbours)should be less than the mid element;

    if you see the if either mid-1 or mid +1 are greater than the mid, the possible of peak being there is high, if if there is only one elemnt that 
    can be called as peak or maybe more incresing elemts there or maybe a drop ( in all the cases there is a peak).

    Move to the side where you see the highest 
*/

#include<iostream>

using namespace std;


class Solution {
public:
    int findPeakElement(vector<int>& nums) {

        int low = 0, high = nums.size() -1;

        //binary search
        while(low <= high){

            int mid = low + (high - low)/2;
            //check if the left neighbour is greater
            if(mid > 0 && nums[mid] < nums[mid -1]){
                high = mid - 1;
            }
            //check if the right neighbour is greater
            else if(mid < nums.size()-1 && nums[mid] < nums[mid + 1]){
                low = mid + 1;
            }
            else{
                return mid;//if both left and right neighbours are smaller, then the mid element is peak!
            }

        }
        
        return -1;
    }
};
