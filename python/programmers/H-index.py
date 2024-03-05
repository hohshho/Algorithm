def solution(citations):
    answer = 0
    citations.sort(reverse=True)  # 인용 횟수를 내림차순으로 정렬
    
    for i, citation in enumerate(citations):
        if citation >= i + 1:  # 인용 횟수가 논문의 수보다 많은 경우
            answer = i + 1  # 현재까지의 최대 h-index 업데이트
        else:
            break  # 더 이상 h-index를 만족하는 조건이 아니므로 반복문 종료
    
    return answer
