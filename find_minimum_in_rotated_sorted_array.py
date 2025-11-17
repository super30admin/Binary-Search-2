# https://leetcode.com/problems/find-minimum-in-rotated-sorted-array/

# Using the binary search finding the minimum number. In the first condition check the low is less than high if yes we go the minimum number. In 'and' case check the mid is minimum than previous and next element if this condition satisfies then return it. Else check the array is left or righ sorted and move the pointer accordingly. Time Complexity O(log n)

class Solution:
    def findMin(self, nums : list[int]) -> int:
        low = 0
        high = len(nums) - 1
        while low <= high:
            # first check is array sorted, if yes, we got the minimum number
            if nums[low] <= nums[high]:
                return nums[low]
            # find the mid point
            mid = (low + high) // 2 
            # this edge case check the mid is smaller than the previous and smaller than the next, if yes, we got the minimum number
            if (mid == 0 or nums[mid] < nums[mid - 1]) and (mid == high - 1 or nums[mid]< nums[mid+1]):
                return nums[mid]
            # this condition means left half is sorted
            elif nums[low] <= nums[mid]:
                # the element is not in the left side move the pointer to right.
                low = mid + 1
            # when the left is not sorted so move the pointer to the left part
            else:   
                high = mid - 1
        return nums[low]
    
sh = Solution()
print(sh.findMin([3,4,5,1,2]))    
print(sh.findMin([4,5,6,7,0,1,2]))    
print(sh.findMin([11,13,15,17]))    
                


        