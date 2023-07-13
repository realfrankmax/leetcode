# leetcode
**169** problems from [techinterviewhandbook](https://www.techinterviewhandbook.org/grind75?weeks=4&hours=40&mode=all&order=topics&grouping=topics#)

## Note
### Initialization
```
List<Integer> list = List.of(1, 2, 3); // Immutable; Non-null supported
List<Integer> list = Arrays.asList(1, 2, null); // Mutable; Null supported
Set<String> set = new HashSet<>(Arrays.asList("a", "b", "c"));

List<Integer> newList = new ArrayList<>(list);

Map<Character, Integer> dict = Map.of('I', 1, 'V', 5, 'X', 10);

// Convert list to array
List<int[]> list = new ArrayList<>(); // Assume dimension is n by 2
int[][] iArray = list.toArray(new int[list.size()][2]);

List<Integer> list = List.of(1,3,4);
Integer[] arr = list.toArray(new Integer[list.size()]);
int[] arr = list.stream().mapToInt(Integer::intValue).toArray();
```
### Sort
```
Arrays.sort(T[] a, Comparator<? super T> c) // the array must be object type, but not primitive 
```
### Reverse a string
```
new StringBuilder(s).reverse().toString();
```
### Map: add if absent
```
Map<Integer, Integer> map = new HashMap<>();
if (!map.containsKey(1)) {
    map.put(1, 0);
}
map.computeIfAbsent(1, x -> 0); // Better
```
