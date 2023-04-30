def solution(a, b):
    arr = ['FRI','SAT','SUN','MON','TUE','WED','THU']
    return arr[(change(a, b) - change(1, 1))%7]

def change(month, day):
    ans = 0
    
    for i in range(1, month):
        if i==2 : ans = ans+29
        elif (i<=7 and i%2==0): ans = ans+30
        elif (i<=7 and i%2!=0): ans = ans+31
        elif (i>=8 and i%2==0): ans = ans+31
        elif (i>=8 and i%2!=0): ans = ans+30

    return ans+day

# 다른 사람 코드
def getDayName(a,b):
    month = [31, 29, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31]
    day = ['FRI', 'SAT', 'SUN', 'MON', 'TUE', 'WED', 'THU']
    return day[(sum(month[:a-1])+b-1)%7]
