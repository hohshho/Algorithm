class Solution(object):
    def __init__(self):
        self.answer = []
        self.phone = [[],
            [],['a','b','c'],['d','e','f'],\
            ['g','h','i'],['j','k','l'],['m','n','o'],\
            ['p','q','r','s'],['t','u','v'],['w','x','y','z']\
        ]

    def letterCombinations(self, digits):
        """
        :type digits: str
        :rtype: List[str]
        """
        digitsArr = list(digits)

        self.makeWord(0, "", digitsArr)

        return self.answer

    def makeWord(self, cnt, saveWord, digitsArr):
        if(cnt == len(digitsArr)):
            if(len(digitsArr) == 0):
                return
            self.answer.append(saveWord)
            return

        pushNum = int(digitsArr[cnt])

        for cur in self.phone[pushNum]:
            self.makeWord(cnt + 1, saveWord + cur, digitsArr)
            