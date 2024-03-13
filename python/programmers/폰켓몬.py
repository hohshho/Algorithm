def solution(nums):
    numLen = len(nums) // 2 
    nums = set(nums) 
    return min(len(nums), numLen) 