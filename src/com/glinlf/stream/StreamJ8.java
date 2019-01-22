package com.glinlf.stream;

import com.google.common.base.Strings;

import java.util.*;
import java.util.stream.Collectors;

/**
 * @author created by glinlf
 * @date 2018/9/6
 * @remark
 */
public class StreamJ8 {

    public static void main(String[] args) {

        Arrays.asList(1, 2, 3, 4, 5, 6).forEach(item -> {
            System.out.println(item);
        });

//        String str[] = new String[10];
        String s[] = {"2", "3", "4", null,};

        Collection<String> strings = Arrays.asList(s);

        int total = strings
                .stream()
//                .filter(item -> item != null && item != "")  // 过滤值为null和空字符串
                .filter(item -> !Strings.isNullOrEmpty(item))  // 过滤值为null和空字符串
                .mapToInt(Integer::valueOf)    // 方法引用
                .sum();
        System.out.println(total);

        List<Integer> list = Arrays.asList(0, 1, 2, 4, 5, null);
        boolean isAllEqZero = list
                .stream()
                .filter(item -> item != null) // 过滤null
//                .filter(item -> item > 0)     // 过滤小于等于0的值
//                .allMatch(item -> item > 0);  // 是否全部大于0
                .anyMatch(item -> item == 0);  // 是否有一个等于0

        System.out.println(isAllEqZero);

        Collection<User> users = Arrays.asList(
                new User(1, "llf", 22),
                new User(2, "llf", 23),
                new User(3, "fzy", 24),
                new User(4, "fzy", 25)
        );
        ((List<User>) users).sort(new Comparator<User>() {
            @Override
            public int compare(User o1, User o2) {
                return o2.getAge() - o1.getAge();
            }
        });
        System.out.println(users);

        users.stream()
                .filter(item -> item.getAge() > 22)
                .forEach(val -> System.out.println(val));

        // com.glinlf.stream 并行处理 parallel()
        // parallel方法并行处理所有的users，并使用reduce方法计算最终的结果
        int avgage = users
                .stream()
                .parallel()
//                .mapToInt(com.glinlf.stream.User::getAge)
                .map(user -> user.getAge())
                .reduce(0, Integer::sum) / users.size();
//                .sum()/users.size();
        System.out.println(avgage);

        // 并行执行 分类操作
        final Map<String, List<User>> groupUser = users
                .stream()
                .collect(Collectors.groupingBy(User::getName));
        System.out.println(groupUser);

        // 并发执行

//        users.com.glinlf.stream().parallel();
//        users.parallelStream();
    }

}
