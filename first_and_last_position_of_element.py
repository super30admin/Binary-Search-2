# https://leetcode.com/problems/find-first-and-last-position-of-element-in-sorted-array/


# Using the binary search to find the first and last position of the target element in the array. Created two methods, first is to find the first occurance of the target and second is to find the last occurance. Passing the result of first method to second method as an argument, becuase we got the first occurance from that index we can find the last occurance. 
# Time Complexity O(log n)

class Solution:
    # method to find the first position of the element
    def searchRange(self, nums: list[int], target: int) -> list[int]:
        def binarySearchFirst(nums, target, low, high):
            while low <= high:
                mid = (low + high) // 2
                # when the mid is target element
                if nums[mid] == target:
                # if the previous element of the mid is not a target or target is at zero position means we got the first occurance
                    if mid == 0 or nums[mid-1] != target:
                        return mid
                # but if the mid - 1 is also target element then change the high pointer to calculate the first position of the element
                    else:
                        high = mid -1
                # search the target in the left half
                elif nums[mid] > target:
                    high = mid - 1
                # search the target in the right half
                else:
                    low = mid + 1
            return -1
        
        # method to find the last position of the element
        def binarySearchLast(nums, target, low, high):
            while low <= high:
                mid = (low + high) // 2
                # when the mid is target element
                if nums[mid] == target:
                    # if the next element of the mid is not a target or target is at last position means we got the last occurance
                    if  mid == len(nums)-1 or nums[mid + 1] != target:
                        return mid
                    else:
                    # but if the mid + 1 is also target element then change the lower pointer to calculate the last position of the element
                        low = mid + 1
                elif nums[mid] > target:
                    # search the target in the left half
                    high = mid -1
                else:
                    # search the target in the right half
                    low = mid + 1
            return -1

        # find the first position of the element by calling binarySearchFirst method and store into the variable 'first'
        first = binarySearchFirst(nums, target, 0 , len(nums)-1 )
        # if we get the -1 output means target is not present
        if first == -1:
            # exit the program
            return [-1, -1]
        else:
            # if the target is present in the list then pass it's first occurance index value as the 'first' argument in the binarySearchLast method 
            last = binarySearchLast(nums, target, first, len(nums)-1)
        return [first, last] 




sh = Solution()
print(sh.searchRange([5,7,7,8,8,10],8))
print(sh.searchRange([5,7,7,8,8,10],7))
print(sh.searchRange([],0))
