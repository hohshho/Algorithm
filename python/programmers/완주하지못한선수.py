def solution(participant, completion):
    answer = ''
    
    players = dict()
    
    for person in participant:
        cnt = 1
        if person in players:
            cnt = players.get(person) + 1
        players[person] = cnt
    
    for person in completion:
        if person in players:
            if players[person] == 1:
                players.pop(person)
            else:
                players[person] = players[person] - 1
            
    for person in players:
        answer = person
    
    return answer