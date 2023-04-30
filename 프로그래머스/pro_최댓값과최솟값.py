def solution(s):
    answer = ''
    arr = list(map(int, s.split()))
    arr.sort()
    
    return str(arr[0]) + " " + str(arr[-1])