pub fn bin_search(array: &[i32], search: i32) -> Option<usize> {
    if array.is_empty() {
        return None;
    }
    bin_search_rec(array, search, 0, array.len() - 1)
}

fn bin_search_rec(array: &[i32], search: i32, low: usize, high: usize) -> Option<usize> {
    let middle = (low + high) / 2;
    let element = array[middle];
    if element == search {
        return Some(middle);
    }
    if high <= low {
        return None;
    }
    if element < search {
        return bin_search_rec(array, search, middle + 1, high);
    }
    bin_search_rec(array, search, low, middle - 1)
}

#[cfg(test)]
mod test {
    use super::bin_search;

    #[test]
    fn test_missing() {
        assert_eq!(bin_search(&[1, 2, 3], 4), None);
    }

    #[test]
    fn test_middle() {
        assert_eq!(bin_search(&[1, 2, 3], 2), Some(1));
    }

    #[test]
    fn test_left() {
        assert_eq!(bin_search(&[1, 2, 3], 1), Some(0));
    }

    #[test]
    fn test_right() {
        assert_eq!(bin_search(&[1, 2, 3], 3), Some(2));
    }

    #[test]
    fn test_empty() {
        assert_eq!(bin_search(&[], 1), None);
    }

    #[test]
    fn test_single() {
        assert_eq!(bin_search(&[1], 1), Some(0));
    }

    #[test]
    fn test_single_missing() {
        assert_eq!(bin_search(&[1], 2), None);
    }
}

fn main() {}