import random

def sort(lst):
    l = len(lst)
    for s in range(l):
        b = s
        for i in range(s, l):
            if lst[i] < lst[b]:
                b = i
        tmp = lst[s]
        lst[s] = lst[b]
        lst[b] = tmp

print('Started')
my_list = [random.randint(1, 50) for _ in range(100000)]
print('List created')
sort(my_list)
print('List sorted')
print(my_list)
