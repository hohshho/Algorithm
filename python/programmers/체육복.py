# 전체 학생 수, 도난당한 학생번호, 여분의 체육복 가져온 학생 번호
def solution(n, lost, reserve):
    lostCnt = 0
    
    lost.sort()
    reserve.sort()

    temp = []
    for lostClothStudentIdx in lost:
        # 여분의 체육복 가져온 학생 중 도난 당한 학생 처리
        if lostClothStudentIdx in reserve:
            reserve.remove(lostClothStudentIdx)
            temp.append(lostClothStudentIdx)
            continue
    
    for i in temp:
        lost.remove(i)
    
    for lostClothStudentIdx in lost:
        # 이전 번호 학생부터 처리
        if checkIdx(n, lostClothStudentIdx - 1, "prev"):
            if lostClothStudentIdx - 1 in reserve:
                reserve.remove(lostClothStudentIdx - 1)
                continue
                
        # 다음 번호 학생
        if checkIdx(n, lostClothStudentIdx + 1, "next"):
            if lostClothStudentIdx + 1 in reserve:
                reserve.remove(lostClothStudentIdx + 1)
                continue
                
        # 빌릴 수 없는 경우
        lostCnt += 1
    
    return n - lostCnt

def checkIdx(n, idx, check):
    if check == "prev":
        return True if idx >= 1 else False
    if check == "next":
        return True if idx <= n else False