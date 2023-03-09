import random

def sort(lst):
    l = len(lst) - 1
    b = 0
    for s in range(l + 1):
        for i in range(s, l + 1):
            if lst[i] < lst[b]:
                b = i
        tmp = lst[s]
        lst[s] = lst[b]
        lst[b] = tmp
        b = s + 1

my_list = [random.randint(1, 50) for _ in range(10)]
sort(my_list)
print(my_list)
