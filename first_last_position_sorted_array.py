"""
Approach:
-> Perform 2 binary search. One to find first occurence of target and second for last occurence of target.
-> BinarySearch1 - if mid element is target, check further if mid-1 is not same as mid. if so, we found we found first occurence of target, so return mid (index of first occurence). else - mid-1 is same as mid and so first occurence lies in left side - so eliminate right side by updating high to mid - 1.
-> BinarySearch2 - similar to BinarySearch1. This time check if mid+1 is not same as mid. follow similar steps and update low pointer to eliminate left half.

Time complexity:
O(logn)

Space complexity:
O(1)
"""
class Solution:
    def searchRange(self, nums: List[int], target: int) -> List[int]:

        def get_first_position(nums, target, low, high):
            
            while low <= high:
                mid = low + (high-low)//2
                if nums[mid] == target:
                    # if mid-1 is not target, so mid is first occurence of target. return mid
                    # also check for index bounds condition
                    if mid == 0 or nums[mid-1] != nums[mid]:
                        return mid
                    
                    # nums[mid-1] == nums[mid], so mid is not first occurence in sorted array. so move to left half and eliminate right half by updating high pointer
                    else:
                        high = mid - 1

            
                # regular binary search    
                elif nums[mid] < target:
                    low = mid + 1
                
                else:
                    high = mid - 1
            return -1
        
        def get_last_position(nums, target, low, high):
            
            while low <= high:
                mid = low + (high-low)//2
                if nums[mid] == target:
                    # if mid+1 is not target, so mid is last occurence of target. return mid
                    # also check for index bounds condition
                    if mid == len(nums) - 1 or nums[mid+1] != nums[mid]:
                        return mid

                    # nums[mid+1] == nums[mid], so mid is not last occurence in sorted array. move to right half and eliminate left half by updating low pointer
                    else:
                        low = mid + 1
            
                # regular binary search    
                elif nums[mid] < target:
                    low = mid + 1
                
                else:
                    high = mid - 1
            
            return -1

        first_position = get_first_position(nums, target,0,len(nums)-1)
        last_position = get_last_position(nums, target,0,len(nums)-1)

        return [first_position, last_position]