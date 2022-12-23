# In the array we first run BST (taking Low, High and Middle). Then check if the middle is the target or not and if not we move to the 
# sorted array either on left or right. If the target is not present in the sorted array then check the otherside of the array and 
# perform BST and get the answer.
class Solution:
    def search(self, nums: List[int], target: int) -> int:
        if (nums == 0 or nums == None):
            return -1
        low = 0
        high = len(nums) - 1 
        while (low<=high):
            mid = low + (high - low)//2 
            if (nums[mid] == target):
                return mid
            elif (nums[low] <= nums[mid]):
                #Left sorted 
                if(nums[low]<= target and nums[mid]>target):
                    high = mid - 1
                else: 
                    low = mid + 1
            else: 
                #right sorted
                if (nums[mid] < target and nums[high] >= target):
                    low = mid + 1
                else: 
                    high = mid -1
        return -1