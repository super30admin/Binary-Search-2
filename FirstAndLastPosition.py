"""
Rasika Sasturkar
Time Complexity: O(logn + logn), we perform binary search twice,
one to find fist occurrence of the element and second binary search
to find last occurrence of the element.
Space Complexity: O(1)
"""


def searchRange(nums, target):
    """
    We perform 2 binary searches to find the first and last occurrence
    of the target.
    Returns [-1,-1] in all other cases.
    """
    if nums is None or len(nums) == 0:
        return [-1, -1]
    n = len(nums)
    if nums[0] > target or nums[n - 1] < target:
        return [-1, -1]

    # to get the first occurrence
    first = binary_search_first(nums, target)
    if first == -1:
        return [-1, -1]

    # to get the second occurrence
    second = binary_search_last(nums, first, n - 1, target)  # slicing will take extra space as it creates another list
    return [first, second]


def binary_search_first(nums, target):
    """
    We first perform binary search to find the target, once we get the target
    we check for 2 conditions - if the mid is first element or if mid is greater
    than the previous element. In both these cases, we found the first occurrence
    of our target, or we keep searching.
    """
    low = 0
    high = len(nums) - 1
    while low <= high:
        mid = low + (high - low) // 2
        if nums[mid] == target:
            if mid == 0 or nums[mid] > nums[mid - 1]:
                return mid
            else:
                high = mid - 1
        elif nums[mid] < target:
            low = mid + 1
        else:
            high = mid - 1
    return -1


def binary_search_last(nums, low, high, target):
    """
    Here, we can directly take the first occurrence as our low pointer,
    as it reduces the range for our search. We first perform binary search to
    find the target, once we get the target we check for 2 conditions -
    if the mid is our last element or if mid is smaller than
    the next element. In both these cases, we found the last occurrence
    of our target, or we keep searching.
    """
    while low <= high:
        mid = low + (high - low) // 2
        if nums[mid] == target:
            if mid == len(nums) - 1 or nums[mid] < nums[mid + 1]:
                return mid
            else:
                low = mid + 1
        elif nums[mid] < target:
            low = mid + 1
        else:
            high = mid - 1
    return -1


def main():
    """
    Main function - an example from LeetCode problem to show the working.
    This code ran successfully on LeetCode and passed all test cases.
    """
    nums1 = [5, 7, 7, 8, 8, 10]
    target1 = 8
    print(searchRange(nums1, target1))  # returns [3, 4]
    nums2 = []
    target2 = 0
    print(searchRange(nums2, target2))  # returns [-1, -1]


if __name__ == "__main__":
    main()
