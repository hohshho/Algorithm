import math

primeNumbers = []
numberList = set()
maxSize = 0

def solution(numbers):
    global primeNumbers
    answer = 0
    numberArray = list(numbers)
    visited = [False] * len(numberArray)
    
    makeNumberList(numberArray, 0, visited, "")
    
    if(maxSize not in [0, 1]):
        makePrimeNumbers()
        for n in numberList:
            if(primeNumbers[n]):
                answer += 1
    
    return answer

def makePrimeNumbers():
    global primeNumbers
    
    primeNumbers = [True for _ in range(0, maxSize + 2)]
    # primeNumbers = [True] * (maxSize + 1)
    primeNumbers[0] = False
    primeNumbers[1] = False
    for i in range(2, int(math.sqrt(maxSize) + 1)):
        if primeNumbers[i]:
            for j in range(i*i, maxSize + 1, i):
                primeNumbers[j] = False

def makeNumberList(numberArray, cnt, visited, word):
    global numberList
    global maxSize
    
    if(cnt == len(numberArray)):
        maxSize = max(int(word), maxSize)
        if int(word) not in numberList:
            numberList.add(int(word))
            
        return
    
    for i in range(0, len(numberArray)):
        if visited[i]:
            continue
            
        if cnt > 0 and int(word) not in numberList:
            numberList.add(int(word))
            
        visited[i] = True
        makeNumberList(numberArray, cnt + 1, visited, word + str(numberArray[i]))
        visited[i] = False
    return
    