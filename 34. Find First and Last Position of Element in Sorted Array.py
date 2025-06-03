class Solution:
    def first_binary_search(self,nums, low, high, target):
        while low <= high:
            mid = low + (high - low) // 2
            if nums[mid] == target:
                if (mid == 0 or nums[mid] > nums[mid - 1]):
                    return mid
                else:
                    # reject the right half here because target is == num[mid] and we are finding the first element and not the last one so we can move the high pointer
                    high = mid - 1
            elif (nums[mid] > target):
                high = mid - 1
            else:
                low = mid + 1
        return -1

    def second_binary_search(self,nums, low, high, target):
        while low <= high:
                mid = low + (high - low) // 2
                if nums[mid] == target:
                    if (mid == len(nums) - 1 or nums[mid] < nums[mid + 1]):
                        return mid
                    else:
                        # reject the right half here because target is == num[mid] and we are finding the first element and not the last one so we can move the high pointer
                        low = mid + 1
                elif (nums[mid] > target):
                    high = mid - 1
                else:
                    low = mid + 1
        return -1

    def searchRange(self, nums: List[int], target: int) -> List[int]:
        # if the target is either less than 1st elem or greater than last which means it's not    there and we return [-1,-1] array then and there
        if not nums:
            return [-1, -1]
        if target < nums[0] or target > nums[-1]:
            return [-1, -1]

        first_index = self.first_binary_search(nums, 0, len(nums)-1,target)
        # If we don't find the element in first search no need to do the second search
        if first_index == -1:
            return [-1,-1]
        
        second_index = self.second_binary_search(nums, first_index, len(nums)-1, target)
        return[first_index, second_index]