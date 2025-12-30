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
def binary_search_first(A, tgt, s, e):
    while s <= e:
        mid = s + (e-s) // 2
        if A[mid] == tgt:
            if mid == 0 or A[mid-1] != A[mid]:
                return mid
            else:
                e = mid - 1
        elif A[mid] < tgt:
            s = mid + 1
        else: # A[mid] > tgt
            e = mid - 1
    return -1

def binary_search_last(A, tgt, s, e):
    N = len(A)
    while s <= e:
        mid = s + (e-s) // 2
        if A[mid] == tgt:
            if mid == N-1 or A[mid] != A[mid+1]:
                return mid
            else:
                s = mid + 1
        elif A[mid] < tgt:
            s = mid + 1
        else: # A[mid] > tgt
            e = mid - 1
    return -1

def search_range(A, tgt):
    N = len(A)
    if N == 0:
        return [-1,-1]

    first = binary_search_first(A, tgt, 0, N-1)
    if first == -1:
        return [-1,-1]
    last = binary_search_last(A, tgt, first, N-1)

    return [first, last]

def run_search_range():

    A = [0, 1, 1, 1, 1, 2, 2, 2, 3, 4, 4, 5, 10]
    print(f"A = {A}")
    for tgt in [2, 3, 4, 6]:
        pair = search_range(A, tgt)
        print(f"Start index and last index of {tgt} = {pair}")

    A = [2,2,2,2,2,2]
    tgt = 2
    print(f"A = {A}")
    pair = search_range(A, tgt)
    print(f"Start index and last index of {tgt} = {pair}")

    A = [2]
    tgt = 2
    print(f"A = {A}")
    pair = search_range(A, tgt)
    print(f"Start index and last index of {tgt} = {pair}")

    A = []
    tgt = 2
    print(f"A = {A}")
    pair = search_range(A, tgt)
    print(f"Start index and last index of {tgt} = {pair}")

run_search_range()
