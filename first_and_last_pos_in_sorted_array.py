class Solution:
    def searchRange(self, nums, target):
        l = 0
        n = len(nums)
        r = n-1
        result_ = []

        def search(nums, l, r, result_):
            while l < r:
                mid = l + (r-l)//2
                if nums[mid] == target:
                    result_.append(mid)
                    return result_
                elif nums[mid] > target:
                    return search(nums, l, mid-1, result_)
                elif nums[mid] < target:
                    return search(nums, mid+1, r, result_)
            # return result_
            return [-1, -1]
        return search(nums, l, r, result_)


nums = [5, 7, 7, 8, 8, 10]
target = 8
s = Solution()
print(s.searchRange(nums, target))
