def solution(brown, yellow):
    brown -= 4
    brown //= 2
    
    # 3 , 2 / 2, 1 / 5, 20
    garo = 0
    sero = 0
    for i in range(garo, brown):
        print(i)
        if(i * (brown - i) == yellow):
            sero = brown - i
            garo = i
            break
            
    answer = [sero + 2, garo + 2]
    
    return answer