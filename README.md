# Leetcode
- **169** problems from [techinterviewhandbook](https://www.techinterviewhandbook.org/grind75?weeks=4&hours=40&mode=all&order=topics&grouping=topics#)
- Plus some interesting problems

## Validation pre-coding
- If the input is String type, what is the character set?
  - If the character set is lower case english letter, then an array of length 26 could be enough. 
  - If lower case letter is the same as upper case one.
- If the input has duplicate values?
  - Tree nodes with same value
  - Array elements with same value
- If input has positive-only values? Or what is the range?
  - It could affect how to choose the initial value if input has a negative value.
- If values in the dictionary could be reused?
- If the input (array/tree) could be modified?
- If the input (array) is sorted?
- If there are time/space complexity requirements
- What are return values on special cases?
## Methods
### Math
```
Math.ceil(3.4);     // Output: 4.0
Math.floor(3.4);    // Output: 3.0
Math.pow(2,3);      // Output: 8.0
Math.log10(100);    // Output: 2.0
```
### Character
```
Character.isDigit('1');
Character.isLetter('a');
Character.isLetterOrDigit('a');
Character.getNumericValue('1'); // Return int: 1
```
### String
```
// Basics
"ABc".substring(1, 2);            // Output: "B" 
"ABc".contains("B");              // Output: true
"ABc".toLowerCase();              // Output: "abc"
"ABc".toUpperCase();              // Output: "ABC"
" ABC ".trim();                   // Output: "ABC"
"ABC".startsWith("A");            // Output: true
"ABC".endsWith("BC");             // Output: true
String[] a = ",,,".split(",");    // a.length == 0 (Note: trailing empty strings will be discarded)
String[] a = "a,,b,".split(",");  // a.length == 3 with trailing empty string discarded.
String[] a = ",a,,b,".split(","); // a.length == 4 (Note: An empty leading substring is added)
String[] a = ",,,".split(",", -1);// a.length == 4

// Comparison
String x = "abc";
String y = x;
x == y;     // Output: true because "==" checks if two variables point to same memory location.
x.equals(y) // Output: true because "equals" checks the content of two objects.

// Reverse
new StringBuilder(s).reverse().toString();
```
### Integer
```
Integer.toString(123).toCharArray();               // Break down an integer to digits
Integer.parseInt(new String(new char[]{'1','2'}))  // Create an integer from digits
```
## Data Structures
### Arrays
```
Arrays.sort(T[] a, Comparator<? super T> c) // To use comparator, the array must be Object type, but not primitive 
Arrays.sort(int[] a)                        // In ascending numerical order, and can only be.
Arrays.stream(a).boxed()
    .sorted(Collections.reverseOrder())
    .mapToInt(Integer::intValue).toArray()  // Reverse int[] a

Arrays.toString(new int[]{1,2,3});          // Output: "[1, 2, 3]"
```
### StringBuilder
```
// Returns StringBuilder which supports method chaining
append();
reverse(); 
deleteCharAt(int index);

charAt(int index);              // Returns char
setCharAt(int index, char ch);  // Returns void                    

// Returns String
substring(int start);
substring(int start, int end);
toString();
```
### Deque
```
// Methods to throw exception if fails
addFirst(e);
addLast(e);
removeFirst();
removeLast();
getFirst();
getLast();
```
### Map
```
// Initialization
Map<Character, Integer> dict = Map.of('I', 1, 'V', 5, 'X', 10);

Map<Integer, Integer> map = new HashMap<>();
if (!map.containsKey(1)) {
    map.put(1, 0);
}
map.computeIfAbsent(1, x -> 0); // Better

map.entrySet();                 // Returns: Set<Map.Entry<K, V>>
map.keySet();                   // Returns: Set<K>
map.values();                   // Returns: Collections<V>

map.remove(Object key);         // Remove the mapping for a key
```
### List
```
// Initialization
List<Integer> list = List.of(1, 2, 3);          // Immutable; Non-null supported
List<Integer> list = Arrays.asList(1, 2, null); // Mutable; Null supported
List<Integer> newList = new ArrayList<>(list);

List<Integer> list = new ArrayList<>();
list.add(null);  // This works
list.add(1, 10); // Add 10 at index 1
list.remove(1);  // Remove item at index 1, but not working if inited with List.of()
list.set(1, 10); // Set item to 10 at index 1

// Convert list to array
List<int[]> list = new ArrayList<>();                               // Assume dimension is n by 2
int[][] iArray = list.toArray(new int[list.size()][2]);             // Can only be converted to Object type array

List<Integer> list = List.of(1,3,4);
Integer[] arr = list.toArray(new Integer[list.size()]);
int[] arr = list.stream().mapToInt(Integer::intValue).toArray();    // Primitive type array conversion
```
### Set
```
// Initialization
Set<String> set = new HashSet<>(Arrays.asList("a", "b", "c"));

Set<Integer> set = new HashSet<>();
set.iterator().next(); // It will return an item in the list (or exception if empty).
```
### TreeSet
This implementation provides guaranteed log(n) time cost for the basic operations (add, remove and contains).
```
TreeSet<Integer> ts = new TreeSet<>();
ts.ceiling(1);          // Returns the least element in this set greater than or equal to the given element, or null if there is no such element.
ts.floor(1);            // Returns the greatest element in this set less than or equal to the given element, or null if there is no such element.
```
### TreeMap
```
TreeMap<Integer, Integer> map = new TreeMap<>();

map.ceilingEntry(1);
map.ceilingKey(1); // Returns the least key greater than or equal to the given key, or null if there is no such key.
map.higherKey(1);  // Returns the least key strictly greater than the given key, or null if there is no such key.

map.floorKey(1);   // Returns the greatest key less than or equal to the given key, or null if there is no such key.
map.lowerKey(1);   // Returns the greatest key strictly less than the given key, or null if there is no such key.
```
### Queue
```
// Methods to throw exception if fails
add()
remove()
element()
```
From javadoc:
Queue implementations generally do not allow insertion of null elements, although some implementations, such as LinkedList, do not prohibit insertion of null. Even in the implementations that permit it, null should not be inserted into a Queue, as null is also used as a special return value by the poll method to indicate that the queue contains no elements.
### PriorityQueue
- O(log(n)) time for the enqueing and dequeing methods (**offer, poll**).
- Linear time for the remove(Object) and contains(Object) methods.
- Constant time for the retrieval methods (**peek**, element, and size).

With comparator
```
Book b = new Book(12);
b.getCost(); // return 12
PriorityQueue<T> pq = new PriorityQueue<>((book1, book2) -> Integer.compare(book1.getCost(), book2.getCost())); // Sort books in cost increasing order
```
## Concepts
### Static, Final
- "static" is used to define a class variable whose value is shared among all objects of the class.
  - Example: `ClassName.VARIABLE_NAME`
- Without it, it is called an instance variable which keeps a copy of data for a single object.
  - Example: `this.variableName`
- "final"
  - When using like "static final", it will give a constant for the class.
    - It has to be initialized explicitly (during declaration usually)
    - Example: `private final static int b = 2;`
  - When using alone, it will give a constant for the instance.
    - It has to be initialized either during declaration or in constructor.
### Why to use Deque over Stack?
Stack is a subclass of Vector which is synchronized which means it has locks involved on operations which cause overhead. If a thread-safe implementation is not needed, then we could use Deque which is faster. Array deques are not thread-safe; in the absence of external synchronization, they do not support concurrent access by multiple threads.
