# java-learning

Java 8 - 18 functionalities with examples

## Java 8

1. Lambda expression
2. Functional Interface (default method and static method)
3. Stream - `stream()`, `forEach()`, `filter()`, `map()`, `sorted()`, `distinct()`, `sorted(Comparator.reverseOrder())`
   , `sorted(CustomComparator-example)`
4. Intermediate Operations - Performed on streams and always return Stream <T>. `distinct()`, `filter()`, `flatMap()`
   , `generate()`, `iterate()`, `limit()`, `map()`, `of()`, `peek()`, `skip()`, `sorted()`, `mapToDouble()`
   , `mapToInt()`, `mapToLong()`
5. Terminal Operations - Performed on streams and always return anything (or void) other than Stream. `toArray()`
   , `reduce()`, `noneMatch()`, `max()`, `min()`, `noneMatch()`
   , `flatMapToDouble()`, `flatMapToInt()`, `flatMapToLong()`, `forEach()`, `forEachOrdered()`, `findAny()`
   , `findFirst()`, `allMatch()`, `anyMatch()`, `count()`, `collect()`
6. Function Descriptor : Functional descriptor of an Interface is the method type of the single abstract method of the interface.
7. Java DateTime API
8. CompletableFuture
9. Optional class
10. Collectors class
11. Concurrency Enhancements

## Miscellaneous example from

- Accumulate names into a List

```
List<String> list = people.stream()
                           .map(Person::getName)
                           .collect(Collectors.toList());
```

- Accumulate names into a TreeSet

```
Set<String> set = people.stream()
                        .map(Person::getName)
                        .collect(Collectors.toCollection(TreeSet::new));

```

- Convert elements to strings and concatenate them, separated by commas

```
String joined = things.stream()
                      .map(Object::toString)
                      .collect(Collectors.joining(", "));
```

- Compute sum of salaries of employee

```
int total = employees.stream()
                     .collect(Collectors.summingInt(Employee::getSalary));
```

- Group employees by department

```
Map<Department, List<Employee>> byDept = employees.stream()
                                                  .collect(Collectors.groupingBy(Employee::getDepartment));
```

- Compute sum of salaries by department

```
Map<Department, Integer> totalByDept = employees.stream()
                                                .collect(Collectors.groupingBy(Employee::getDepartment, Collectors.summingInt(Employee::getSalary)));
```           

- Partition students into passing and failing

```
Map<Boolean, List<Student>> passingFailing = students.stream()
                                                     .collect(Collectors.partitioningBy(s -> s.getGrade() >= PASS_THRESHOLD));
```