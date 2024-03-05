class Solution(object):
    def moveZeroes(self, nums):
        """
        :type nums: List[int]
        :rtype: None Do not return anything, modify nums in-place instead.
        """
        if(len(nums) < 2):
            return nums

        index = 0
        cur = 0

        while(index < len(nums)):
            if(nums[index] == 0):
                index += 1
                continue
    
            if(index != cur):
                nums[cur] = nums[index]
                nums[index] = 0
    
            cur += 1
            index += 1

        return nums