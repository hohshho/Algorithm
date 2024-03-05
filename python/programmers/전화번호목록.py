def solution(phone_book):
    answer = True
    phoneSet = set()
    
    phone_book.sort(key=lambda x : len(x))
    
    for phone in phone_book:
        if phone not in phoneSet:
            phoneSet.add(phone)
        for i in range(1, len(phone) + 1):
            if phone[0:i - 1] in phoneSet:
                print(phone[0:i])
                answer = False

    return answer