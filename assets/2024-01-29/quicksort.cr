def quickSort(links : Int, rechts : Int, feld : Array, depth : Int)
  i = links
  j = rechts - 1
  if rechts > links
    pivot = feld[rechts]
    while i < j
      while feld[i] < pivot && i < rechts
        i += 1
      end
      while feld[j] > pivot && j > links
        j -= 1
      end
      if i < j
        tmp = feld[i]
        feld[i] = feld[j]
        feld[j] = tmp
      end
    end
    tmp = feld[i]
    feld[i] = feld[rechts]
    feld[rechts] = tmp
    printf("    " * depth)
    puts("#{feld}")
    quickSort(links, i - 1, feld, depth + 1)
    quickSort(i + 1, rechts, feld, depth + 1)
  end
end

# array = [3, 5, 2, 7, 8, 6, 1, 9, 3, 4]
array = [3, 3, 3]
quickSort(0, array.size - 1, array, 0)