
// binary search the left most and then the right most idx of target
// time = o(logN) + o(logN) = o(2logN) = o(logN)
// space = o(1)
func searchRange(nums []int, target int) []int {
    leftIdx := -1
    left := 0
    right := len(nums)-1
    for left <= right {
        mid := left+(right-left)/2
        if nums[mid] == target {
            leftIdx = mid
            right = mid-1
        } else if target < nums[mid] {
            right = mid-1
        } else {
            left = mid+1
        }
    }
    if leftIdx == -1 {return []int{-1,-1}}
    rightIdx := -1
    left = leftIdx
    right = len(nums)-1
    for left <= right {
        mid := left + (right-left)/2
        if target >= nums[mid] {
            if target == nums[mid] {rightIdx = mid}
            left = mid+1
        } else if target < nums[mid]{
            right = mid-1
        }
    }
    return []int{leftIdx, rightIdx}
}


// sorted = binary search to find a position target
// then using two ptrs to expand left and right window
// time = o(n). worst case the whole array is filled with target number, then 
// leftPtr and rPtr visit ALL elements
// space = o(1)
// func searchRange(nums []int, target int) []int {
//     left := 0
//     right := len(nums)-1
//     for left <= right {
//         mid := left + (right-left)/2
//         if nums[mid] == target {
//             lPtr := mid
//             rPtr := mid
//             for lPtr-1 >= 0 && nums[lPtr-1] == target {
//                 lPtr--
//             }
//             for rPtr+1 < len(nums) && nums[rPtr+1] == target {
//                 rPtr++
//             }
//             return []int{lPtr, rPtr}
//         } else if target > nums[mid] {
//             left = mid+1
//         } else {
//             right = mid-1
//         }
//     }
//     return []int{-1,-1}
// }


// linear scan
// brute force
// time = o(n)
// space = o(1)
// func searchRange(nums []int, target int) []int {
//     ans := []int{-1,-1}
//     for i := 0; i < len(nums); i++ {
//         if nums[i] == target {
//             if ans[0] == -1 {
//                 ans[0] = i
//                 ans[1] = i                
//             } else {
//                 ans[1] = i
//             }
//         }
//     }
//     return ans
// }
