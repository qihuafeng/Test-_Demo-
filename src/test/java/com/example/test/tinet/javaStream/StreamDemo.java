package com.example.test.tinet.javaStream;

import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.Stream;

/**
 * @Author ShineQi
 * @Date 2020/11/19 20:56
 */
public class StreamDemo {

    //    https://blog.csdn.net/y_k_y/article/details/84633001
          /*  1. 不是数据结构，不会保存数据。
              2. 不会修改原来的数据源，它会将操作后的数据保存到另外一个对象中。（保留意见：毕竟peek方法可以修改流中元素）
              3. 惰性求值，流在中间处理过程中，只是对操作进行了记录，并不会立即执行，需要等到执行终止操作的时候才会进行实际的计算。*/
    //常见方式    1 Arrays.stream()   2 Collections.stream()  3 stream.of()
               /* books.stream()
                        .filter(b -> ! "葵花宝典".equals(b.getTitle())) 书名葵花宝典
                        .sorted((b1, b2) -> b2.getPages().compareTo(b1.getPages()))  根据page降序排列
                        .limit(3)  取前三条
                         .map(Book::getAuthor)   作者名字   方法引用  class:method
                         .distinct()   去重
                         .forEach(System.out::println);
                 }
*/
//    2. 流的中间操作
//    2.1 筛选与切片
//    filter：过滤流中的某些元素
//    limit(n)：获取n个元素
//    skip(n)：跳过n元素，配合limit(n)可实现分页
//    distinct：通过流中元素的 hashCode() 和 equals() 去除重复元素

//    2.2 映射
//    map：接收一个函数作为参数，该函数会被应用到每个元素上，并将其映射成一个新的元素。
      //将每个元素转成一个新的且不带逗号的元素
      //Stream<String> s1 = list.stream().map(s -> s.replaceAll(",", ""));
//    flatMap：接收一个函数作为参数，将流中的每个值都换成另一个流，然后把所有流连接成一个流。

//    2.3 排序
//    sorted()：自然排序，流中元素需实现Comparable接口
//    sorted(Comparator com)：定制排序，自定义Comparator排序器

//    2.4 消费
//    peek：如同于map，能得到流中的每一个元素。但map接收的是一个Function表达式，有返回值；而peek接收的是Consumer表达式，没有返回值。


//    3. 流的终止操作
//    3.1 匹配、聚合操作
//    allMatch：接收一个 Predicate 函数，当流中每个元素都符合该断言时才返回true，否则返回false
//    noneMatch：接收一个 Predicate 函数，当流中每个元素都不符合该断言时才返回true，否则返回false
//    anyMatch：接收一个 Predicate 函数，只要流中有一个元素满足该断言则返回true，否则返回false
//    findFirst：返回流中第一个元素
//    findAny：返回流中的任意元素
//    count：返回流中元素的总个数
//    max：返回流中元素最大值
//    min：返回流中元素最小值

//    3.3 收集操作
//    collect：接收一个Collector实例，将流中元素收集成另外一个数据结构。

//    Student s1 = new Student("aa", 10,1);
//    Student s2 = new Student("bb", 20,2);
//    Student s3 = new Student("cc", 10,3);
//    List<Student> list = Arrays.asList(s1, s2, s3);

//    装成list
//    List<Integer> ageList = list.stream().map(Student::getAge).collect(Collectors.toList()); // [10, 20, 10]
//    转成set
//    Set<Integer> ageSet = list.stream().map(Student::getAge).collect(Collectors.toSet()); // [20, 10]
//    //转成map,注:key不能相同，否则报错
//    Map<String, Integer> studentMap = list.stream().collect(Collectors.toMap(Student::getName, Student::getAge)); // {cc=10, bb=20, aa=10}
    public static void main(String[] args) {

        List<String> stringList = new ArrayList<>();
        stringList.add("张三");
        stringList.add("Jerry");
        stringList.add("Tom");
        stringList.add("李华");
        stringList.add("明明");




        Student stuA = new Student(1, "A", "M", 184);
        Student stuB = new Student(2, "B", "G", 163);
        Student stuC = new Student(3, "C", "M", 175);
        Student stuD = new Student(4, "D", "G", 158);
        Student stuE = new Student(5, "E", "M", 170);
        List<Student> list = new ArrayList<>();
        list.add(stuA);
        list.add(stuB);
        list.add(stuC);
        list.add(stuD);
        list.add(stuE);

        list.stream().filter(ls -> !ls.getName().equals("D"))
                .sorted((o1,o2)-> (int) (o1.getHeight()-o2.getHeight()))
                .map(item -> item.getName().toLowerCase())
                .distinct()
                .limit(5)
                .collect(Collectors.toList())
                .forEach(System.out::println);


//        List<Student> list1 = (List<Student>) list.stream()
//                .filter(student -> student.getSex().equals("G"));
//
//        System.out.println(list.toString());
//        System.out.println(list1.toString());

        // 打印结果
        // 1  2  3  4  5
        Stream.concat(Stream.of(1, 2, 3), Stream.of(4, 5))
                .forEach(integer -> System.out.print(integer + "  "));
        // 打印结果：1，2，3
        Stream.of(1,2,3,1,2,3)
                .distinct()
                .forEach(System.out::println);
        // 打印结果：4，5
        Stream.of(1, 2, 3, 4, 5)
                .filter(item -> item > 3)
                .forEach(System.out::println);

        // 打印结果
        // A, B, HELLO
        Stream.of("a", "b", "hello")
                .map(item-> item.toUpperCase())
                .forEach(System.out::println);
        // 打印结果
        // 10，20，30
        Stream.of(1, 2, 3)
                .flatMap(integer -> Stream.of(integer * 10))
                .forEach(System.out::println);
        // 打印结果
        // accept:1
        //  1
        //  accept:2
        //  2
        //  accept:3
        //  3
        //  accept:4
        //  4
        //  accept:5
        //  5
        Stream.of(1, 2, 3, 4, 5)
                .peek(integer -> System.out.println("accept:" + integer))
                .forEach(System.out::println);
        // 打印结果
        // 3,4,5
        Stream.of(1, 2, 3,4,5)
                .skip(2)
                .forEach(System.out::println);
        // 打印结果
        // 1，2，3,4,5
        Stream.of(5, 4, 3, 2, 1)
                .sorted()
                .forEach(System.out::println);
        // 打印结果
        // 5, 4, 3, 2, 1
        Stream.of(1, 2, 3, 4, 5)
                .sorted()
                .forEach(System.out::println);

        // 打印结果
        // 1,2
        Stream.of(1, 2, 3,4,5)
                .limit(2)
                .forEach(System.out::println);

        // 打印结果
        // 1，2，3,4,5
        Stream.of(5, 4, 3, 2, 1)
                .sorted()
                .forEach(System.out::println);

        List<Map<String,Object>> mapList = new ArrayList<>();
        Map<String, Object> map1 = new HashMap<>();
        map1.put("Hello","你好");
        map1.put("Hello2","你好");

        Map<String, Object> map2 = new HashMap<>();
        map1.put("Hello3","你好");
        map1.put("Hello4","你好");

        mapList.add(map1);
        mapList.add(map2);




    }


}
