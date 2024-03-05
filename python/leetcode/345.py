# sol 1. 완탐
# class Solution(object):
#     def reverseVowels(self, s):
#         """
#         :type s: str
#         :rtype: str
#         """
#         arr = list(s)
#         stack = []
#         case = ['a','e','i','o','u']
#         # case = ["a","e","i","o","u"]
#         result = ""

#         for i in arr:
#             if(i.lower() in case):
#                 stack.append(i)

#         for i in arr:
#             add = i
#             if(i.lower() in case):
#                 add = stack.pop()
#             result += add

#         return result
    
# sol 2. 투포인터
    
class Solution(object):
    def reverseVowels(self, s):
        """
        :type s: str
        :rtype: str
        """
        arr = list(s)
        stack = []
        case = ['a','e','i','o','u']
        # case = ["a","e","i","o","u"]

        start = 0
        end = len(arr) - 1
        left = ""
        right = ""
        flag = True
        
        while(end >= start):
            if(flag):
                if(arr[start].lower() in case):
                    flag = False
                else:
                    left += arr[start]
                start += 1
            else:
                if(arr[end].lower() in case):
                    right = arr[start - 1] + right
                    left += arr[end]
                    flag = True
                else:
                    right = arr[end] + right
                end -= 1
        
        if(len(s) != (len(left) + len(right))):
            right = arr[start - 1] + right

        return left + right
        
        
