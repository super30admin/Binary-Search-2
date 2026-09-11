'''
    153 Find Minimum in Rotated Sorted Array
    https://leetcode.com/problems/find-minimum-in-rotated-sorted-array/description/

    Suppose an array of length n sorted in ascending order is rotated between 1 and n times. For example, the array nums = [0,1,2,4,5,6,7] might become:

    [4,5,6,7,0,1,2] if it was rotated 4 times.
    [0,1,2,4,5,6,7] if it was rotated 7 times.

    Notice that rotating an array [a[0], a[1], a[2], ..., a[n-1]] 1 time results in the array [a[n-1], a[0], a[1], a[2], ..., a[n-2]].

    Given the sorted rotated array nums of unique elements, return the minimum element of this array.

    You must write an algorithm that runs in O(log n) time.

    Example 1:
    Input: nums = [3,4,5,1,2]
    Output: 1
    Explanation: The original array was [1,2,3,4,5] rotated 3 times.

    Example 2:
    Input: nums = [4,5,6,7,0,1,2]
    Output: 0
    Explanation: The original array was [0,1,2,4,5,6,7] and it was rotated 4 times.

    Example 3:
    Input: nums = [11,13,15,17]
    Output: 11
    Explanation: The original array was [11,13,15,17] and it was rotated 4 times.

    Solution:
    1. Observe the following rotations of the sorted array
        [0,1,2,4,5,6,7]:
        R1 = [7,0,1,2,4,5,6] # mid = 2, [7,0,1,2] unsorted, [2,4,5,6] = sorted
        R2 = [6,7,0,1,2,4,5] # mid = 1, left = unsorted, right = sorted
        R3 = [5,6,7,0,1,2,4] # mid = 0, left = unsorted, right = sorted
        R4 = [4,5,6,7,0,1,2] # mid = 7, left = sorted, right = sorted
        R5 = [2,4,5,6,7,0,1] # mid = 6, left = sorted, right = unsorted
        R6 = [1,2,4,5,6,7,0] # mid = 5, left = sorted, right = unsorted
        R7 = [0,1,2,4,5,6,7] # mid = 4, left = sorted, right = sorted
        Hence, in rotated sorted arrays, at least one half is sorted.

        Case 1: If both halves around mid are sorted (eg. R4, R7), then min/max could lie in either halves. Use if A[low] <= A[hi]: return A[low]
        Case 2: If one half is unsorted, the min and max lie in the unsorted half.
            a) mid is the min element. Return A[mid]
            b) if left half sorted, go to right half (s=mid+1)
            c) if right half sorted, go to left half (e=mid-1)
        Time: O(log N), Space: O(1)
        https://youtu.be/E7HoVIf26ns?t=2928

'''
class Solution:
    def findMin1(self, nums):
            N = len(nums)
            if N == 0:
                return -1
            s = 0
            e = N-1

            while s <= e:
                # both halves are sorted
                if nums[s] <= nums[e]:
                    return nums[s]

                mid = s + (e-s)//2
                if (mid == 0 or nums[mid] < nums[mid-1]) and (mid == N-1 or nums[mid] < nums[mid+1]):
                    return nums[mid]
                else:
                    if nums[s] <= nums[mid]: # left sorted
                            s = mid + 1 # move right to unsorted
                    else: # left not sorted --> guarantees right sorted
                        e = mid - 1 # move left to unsorted
            return -1

    def findMin2(self, nums):
        '''
        This solution shows that if we forget to check both halves sorted early on (before calculating mid like in findMin1()), then it is possible to check this in the else case
        '''
        N = len(nums)
        if N == 0:
            return -1
        s = 0
        e = N-1
        while s <= e:
            mid = s + (e-s)//2
            if (mid == 0 or nums[mid] < nums[mid-1]) and (mid == N-1 or nums[mid] < nums[mid+1]):
                return nums[mid]
            else:
                if nums[s] <= nums[mid]: # left sorted
                        if nums[mid] < nums[e]: # right also sorted
                            return nums[s] # both halves sorted, return low
                        else: # right unsorted
                            s = mid + 1 # move right to unsorted
                else: # left not sorted --> guarantees right sorted
                    e = mid - 1 # move left to unsorted
        return -1

def run_tests():
    tests = [([5,6,7,0,1,2,4], 0), # left unsorted, right sorted
            ([2,4,5,6,7,0,1], 0), # left sorted, right unsorted
            ([4,5,6,7,0,1,2], 0), # both halves sorted
            ([0,1,2,4,5,6,7], 0), # both halves sorted
            ([17, 0], 0),
            ([17,18,2], 2),
            ([2], 2),
    ]
    sol = Solution()
    for test in tests:
        nums, ans = test[0], test[1]
        m1 = sol.findMin1(nums)
        m2 = sol.findMin2(nums)
        print(f"\nnums = {nums}")
        print(f"Soln1: min  = {m1}")
        print(f"Soln2: min  = {m1}")
        passed = (ans == m1 == m2)
        assert passed == True, f"Test case failed"
        print(f"Pass: {passed}")

    print(f"\nDONE")

run_tests()