#Time complexity : O(log n)
#Space complexity : O(1)
#Leet code: Yes
#Solution: The idea is to use binary search to find the minimum element in the rotated sorted array. We will compare the middle element with the left and right elements to determine which half of the array is sorted and where the minimum element is located. We will keep track of the minimum element found so far and update it as we search through the array.
class Solution(object):
    def findMin(self, nums):
        """
        :type nums: List[int]
        :rtype: int
        """
        
        l, r = 0, len(nums)-1
        temp = float('inf')
        while l <= r:
            if nums[l] < nums[r]:
                return min(nums[l],temp)
                break
            mid = l + (r-l)//2
            temp = min(temp,nums[mid])
            if nums[l] <= nums[mid]: # we are in sorted portion and left sorted array is always greater than right sorted array, search on the right
                
                l = mid + 1
                 
            else: # we are in unsorted portion, our mid is in the right sorted portiona nd all the values to the right of mid will be greater so search in the left if we want to find smaller elements
                r = mid - 1
                 
        return temp