# // Time Complexity : O(logn) + O(logn) = O(logn)
# // Space Complexity : O(1)
# // Did this code successfully run on Leetcode : yes
# // Any problem you faced while coding this : no


class Problem1(object):
    def searchRange(self, nums, target):
        """
        :type nums: List[int]
        :type target: int
        :rtype: List[int]
        """
        # need to find the first index of the target and last index of the target
        # lets do a binary search and once target is found we need to keep checkig the left side to see if that index is thr first occurence or not
        # so keep looking at the left array to see the first index of the target, same goes with the righ array to find the last index

        def left_binary_search(nums,target):
            low = 0
            high = len(nums)-1

            while (low<=high):
                mid = low + (high-low)//2

                if nums[mid] < target:
                    low = mid + 1 # if mid is low then iterate to the right side of the array
                else:
                    high = mid-1 # moving to the left side to find the first index of the array

                
            if low< len(nums) and nums[low] == target: # checking the boundary condition
                return low # once we get the first occurence of the target we found the first index
                
            return -1 # so if the target is not found, return -1

        
        def right_binary_search(nums,target):
            low = 0
            high = len(nums)-1

            while(low<=high):
                mid = low + (high-low)//2

                if nums[mid] > target:
                    high = mid -1 # move to the left of the array 
                else :
                    low = mid +1 # move to the right of the array


            if high >= 0 and nums[high] == target:
                return high # we are retriving the last index of the array

            return -1 # if not found return -1


        first_occ = left_binary_search(nums, target)
        last_occ = right_binary_search(nums,target)
        
        return [first_occ,last_occ]

