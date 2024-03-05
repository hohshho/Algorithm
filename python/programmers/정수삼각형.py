def solution(triangle):
    answer = 0
    triDepth = len(triangle)
    dp = [[0 for _ in range(triDepth)] for _ in range(triDepth)]
    
    for idx, value in enumerate(triangle):
        if idx == 0:
            dp[0][0] = triangle[0][0]
            answer = dp[0][0]
            continue
        for idx2 in range(0, idx + 1):
            if idx2 == 0:
                dp[idx][idx2] = dp[idx-1][0] + triangle[idx][idx2]
            elif idx2 == idx:
                dp[idx][idx2] = dp[idx-1][idx-1] + triangle[idx][idx2]
            else:
                dp[idx][idx2] = triangle[idx][idx2] + \
                                max(dp[idx-1][idx2 -1], dp[idx-1][idx2])
            answer = max(answer, dp[idx][idx2])
        
    return answer