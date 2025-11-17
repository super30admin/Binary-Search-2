# https://leetcode.com/problems/find-peak-element/

# Using binary search finding the greater element than its neighbors. First check the mid element is greater than its neighbor by applying the 'and' condition. It this condition satisfies, return the mid_index. Else check which sides element is greater than the mid and move the pointer accordingly.     Time Complexity O(log n)



class Solution:
    def findPeakElement(self, nums:list[int]) -> int:
        low = 0 
        high = len(nums)-1
        while low <= high:
            mid_index = (low + high) // 2
            # this edge case check the mid is greater than the previous and smaller than the next, if yes, we got the peak element
            if (mid_index == 0 or nums[mid_index] > nums[mid_index - 1]) and (mid_index == high - 1 or nums[mid_index] > nums[mid_index + 1]):
                return mid_index
            # if the right element is greater than the mid then move the search in right half
            elif nums[mid_index + 1] > nums[mid_index]:
                low = mid_index + 1
            # if the left element is greater than the mid then move the search in left half
            else:
                high = mid_index - 1
        
sh = Solution()
print(sh.findPeakElement([1,2,3,1]))
print(sh.findPeakElement([1,2,1,3,5,6,4]))

# output = 2