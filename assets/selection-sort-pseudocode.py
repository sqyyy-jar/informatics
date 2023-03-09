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

my_list = [5, 4, 3, 2, 1]
sort(my_list)
print(my_list)
