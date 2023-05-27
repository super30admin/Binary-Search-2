#Time Complexity : O(log n)
#Space Complexity : O(1)
#Did this code successfully run on Leetcode : Yes
#Any problem you faced while coding this : No


#Initially, added two condiitons where the length of the array is 1 and 2, which can be performed in O(1) time. For the rest, I used a binary search approach where I first checked if the middle element is greater than its next element and if it is the first element, the it becomes the peak. Next, I checked if the middle element is greater than the previous element and if its the last element, then also it is considered as the largest. Finally, the check for middle element and its neighbours when present. Lastly, if the neighbours are greater then I changed the start or end of the binary search accordingly.


class Solution:
    def findPeakElement(self, nums: List[int]) -> int:
        low, high = 0, len(nums)-1
        peak = nums[0]

        if len(nums) == 1:
            return 0
        elif len(nums) == 2:
            return nums.index(max(nums[0],nums[1]))

        while low <= high:
            mid = (low + high) // 2
            if mid == 0 and nums[mid] > nums[mid+1]:
                    return mid
            elif mid == len(nums)-1 and nums[mid] > nums[mid-1]:
                return mid
            elif nums[mid] > nums[mid-1] and nums[mid] > nums[mid+1]:
                return mid
            elif nums[mid-1] > nums[mid]:
                high = mid - 1
            else:
                low = mid + 1

        return mid
