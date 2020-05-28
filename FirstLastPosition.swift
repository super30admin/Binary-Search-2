//Not working for all test cases

class Solution {
  func searchRange(_ nums: [Int], _ target: Int) -> [Int] {

      
      if nums.count == 1 && nums[0] == target{
          return [0,0]
      }
      
      //find element index
      var numbers = nums
      var index = numbers.count/2
      var targetIndex = -1 
      while index >= 0 && numbers.count>1 {
          if numbers[index] == target {
              targetIndex = index
              break
          } else if numbers[index] > target {
              numbers = Array(0..<(numbers.count/2))
          } else {
              numbers = Array((numbers.count/2)..<numbers.count)
          }
          print(numbers)
          index = numbers.count/2
      }
      
      if targetIndex == -1 {
          return [-1,-1]
      }
      
      //find left position
       var startingPosition = targetIndex
       while startingPosition > 0 {
          if nums[startingPosition] != target {
              startingPosition = startingPosition + 1  
              break
          }
          startingPosition = startingPosition - 1  
       }
      
      //find right position
      var endingPosition = targetIndex
      while endingPosition < nums.count {
          if nums[endingPosition] != target {
              endingPosition = endingPosition - 1
              break
          }
          endingPosition = endingPosition + 1
      }
      return [startingPosition,endingPosition]
  }

    
}