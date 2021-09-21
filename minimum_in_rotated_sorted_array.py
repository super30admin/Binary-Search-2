class Solution:
    def findMin(self, nums: List[int]) -> int:
        l = 0
        n = len(nums)
        r = n-1

        if r == 0:
            return nums[0]

        if nums[l] < nums[r]:
            return nums[l]

        def find_rot(nums, l, r):
            mid = l + (r-l)//2
            if nums[mid] > nums[mid+1]:
                return nums[mid+1]
            elif nums[l] > nums[mid]:
                # search in left half
                return find_rot(nums, l, mid)
            elif nums[mid] > nums[r]:
                # search in right half
                return find_rot(nums, mid, r)
        return find_rot(nums, l, r)


'''
Time complexity - O(logn)
'''
