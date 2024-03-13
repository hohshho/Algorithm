def solution(answers):
    result = []
    # 학생 별 정답 갯수
    answerCnts = [0, 0, 0]
    # 학생 별 정답
    studentsAnswers = [[1,2,3,4,5], [2,1,2,3,2,4,2,5], [3,3,1,1,2,2,4,4,5,5]]
    # 학생 별 정답 유지 index
    studentIndexs = [0, 0, 0]
    
    for answer in answers:
        for studentIndex, answerIndex in enumerate(studentIndexs):
            if studentsAnswers[studentIndex][answerIndex] == answer:
                answerCnts[studentIndex] += 1
            nextIndex = answerIndex + 1
            studentIndexs[studentIndex] = 0 if len(studentsAnswers[studentIndex]) == nextIndex else nextIndex

    maxCnt = max(answerCnts)
    
    for i in range(0, 3):
        if(maxCnt == answerCnts[i]):
            result.append(i + 1)
    return result