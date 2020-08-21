class Solution {
public:
    int findMin(vector<int>& nums) {
        
        int left = 0, right = nums.size() - 1;
        
        // If the list has just one element then return that element.
        if (nums.size() == 1) {
         return nums[0];
        }

    // if the last element is greater than the first element then there is no   rotation.
        
        if (nums[right] > nums[0]) {
            return nums[0]; 
        }
    
        // Binary search way
        while (right >= left) {
         
            int mid = left + (right - left) / 2;

      // if the mid element is greater than its next element   
       
        if (nums[mid] > nums[mid + 1]) { 
            return nums[mid + 1];
          }

      // if the mid element is lesser than its previous element 
        if (nums[mid - 1] > nums[mid]) {
        return nums[mid];
        }

      // if the mid elements value is greater than the 0th element  
        if (nums[mid] > nums[0]) {
         left = mid + 1;
        } else {
        
        right = mid - 1;
      }
    }
    return -1;
        
    }
};