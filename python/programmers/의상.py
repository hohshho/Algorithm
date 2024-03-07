def solution(clothes):
    answer = 1
    clothesMap = {}
    indexMap = {}
    indexCnt = 0
    for i in range(0, len(clothes)):
        cloth = clothes[i]
        if cloth[1] not in indexMap:
            indexMap[cloth[1]] = indexCnt
            indexCnt += 1
        
        if indexMap[cloth[1]] not in clothesMap:
            clothesMap[indexMap[cloth[1]]] = []
        clothesMap[indexMap[cloth[1]]].append(cloth[0])

    for values in clothesMap.values():
        answer *= len(values) + 1
        
    return answer - 1