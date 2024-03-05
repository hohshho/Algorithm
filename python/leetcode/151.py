class Solution(object):
    def reverseWords(self, s):
        arr = s.split()
        result = ""
        
        for part in arr:
            result = part + " " + result

        return result[:-1]