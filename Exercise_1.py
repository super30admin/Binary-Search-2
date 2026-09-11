'''
    34  First and last position of target element in sorted array
    https://leetcode.com/problems/find-first-and-last-position-of-element-in-sorted-array/description/

    Given an array of integers nums sorted in non-decreasing order, find the starting and ending position of a given target value.

    If target is not found in the array, return [-1, -1].

    You must write an algorithm with O(log n) runtime complexity.

    Example 1:
    Input: nums = [5,7,7,8,8,10], target = 8
    Output: [3,4]

    Example 2:
    Input: nums = [5,7,7,8,8,10], target = 6
    Output: [-1,-1]

    Example 3:
    Input: nums = [], target = 0
    Output: [-1,-1]

    Solution:
        1. Perform binary search to find the first element
           Perform binary search to find the last element
           Time: O(2log N), Space: O(1)
           https://youtu.be/E7HoVIf26ns?t=68

'''
def binary_search_last(nums, target, s, e):
    N = len(nums)
    while s <= e:
            mid = s + (e-s)//2
            if nums[mid] == target:
                # mid=N-1 implies s = e = N-1
                if mid == N-1 or nums[mid] < nums[mid+1]:
                    return mid
                else:
                    s = mid + 1
            elif nums[mid] < target:
                s = mid + 1
            else:
                e = mid - 1
    return -1


def binary_search_first(nums, target, s, e):
    N = len(nums)
    while s <= e:
        mid = s + (e-s)//2
        if nums[mid] == target:
            # mid=0 implies s = e = 0
            if mid == 0 or nums[mid-1] < nums[mid]:
                return mid
            else:
                e = mid - 1
        elif nums[mid] < target:
            s = mid + 1
        else:
            e = mid - 1
    return -1

def search_range(nums, target):
    N = len(nums)
    if N == 0:
        return [-1, -1]

    first = binary_search_first(nums, target, 0, N-1)
    if first == -1:
        return [-1, -1]
    last = binary_search_last(nums, target, first, N-1)
    return [first, last]

def run_tests():
    tests = [([0,1,1,1,1,2,2,2,3,4,4,5,10], 2, [5,7]),
             ([0,1,1,1,1,2,2,2,3,4,4,5,10], 3, [8,8]),
             ([0,1,1,1,1,2,2,2,3,4,4,5,10], 4, [9,10]),
             ([0,1,1,1,1,2,2,2,3,4,4,5,10], 10, [12,12]),
             ([0,1,1,1,1,2,2,2,3,4,4,5,10], 0, [0,0]),
             ([0,1,1,1,1,2,2,2,3,4,4,5,10], 6, [-1,-1]),
             ([2,2,2,2,2,2], 2, [0,5]),
             ([2], 2, [0,0]),
             ([], 2, [-1,-1]),
    ]
    for test in tests:
        nums, target, ans = test[0], test[1], test[2]
        print(f"\nnums = {nums}")
        pair = search_range(nums, target)
        passed = ans == pair
        print(f"Start index and last index of {target} = {pair}")
        assert passed == True, f"Test case failed"
        print(f"Pass: {passed}")

run_tests()
