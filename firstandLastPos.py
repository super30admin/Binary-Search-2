#Time Complexity :O(logn)
#Space Complexity : O(1)
#Did this code successfully run on Leetcode : Yes
#Any problem you faced while coding this : No

#Approach: using binary serach find the target element and perform one more binsrt search to get the first index of the target element.
# based on the first index, length of the arry find the last index using Binary search


class Solution(object):

    def binary_search(self,nums, target, is_searching_left):
            left = 0
            right = len(nums) - 1
            idx = -1
            
            while left <= right:
                mid = (left + right) // 2
                
                if nums[mid] > target:
                    right = mid - 1
                elif nums[mid] < target:
                    left = mid + 1
                else:
                    idx = mid
                    if is_searching_left:
                        right = mid - 1
                    else:
                        left = mid + 1
            
            return idx


    def searchRange(self, nums, target):
        """
        :type nums: List[int]
        :type target: int
        :rtype: List[int]
        """
        first_pos = self.binary_search(nums, target, True)
        last_pos = self.binary_search(nums, target, False)
        
        return [first_pos, last_pos]



        
        