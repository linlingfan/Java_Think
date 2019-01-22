package com.glinlf.stream;

import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Objects;
import java.util.function.Consumer;
import java.util.function.Predicate;
import java.util.function.Supplier;

/**
 * @author created by glinlf
 * @date 2018/9/2
 * @remark
 */
public class Java8Test {

    private static UserService userService = new UserServiceImpl();

    @Test
    public void testDefault() {
        // default方法可以被子接口继承亦可被其实现类所调用
        // default方法被继承时，可以被子接口覆写
        System.out.println(userService.defaultMethod());
    }

    @Test
    public void testStatic() {
        // 实现类无法调用 static 方法 只有本类直接调用
        System.out.println(UserService.staticMethod());
    }

    @Test
    public void testPredicate() {
        Predicate<String> predicate = s -> s.length() > 0;
        System.out.println(predicate.test("123"));
        System.out.println(predicate.negate().test("123")); // 反向 非test
        Predicate<Boolean> p1 = Objects::nonNull;
        Predicate<Boolean> p2 = Objects::isNull;
        System.out.println(p1.test(null));
        System.out.println(p2.test(null));
        System.out.println(p1.and(p2).test(null));
        Predicate<User> p3 = o -> o instanceof User;
        System.out.println(p3.test(new User()));

    }

    @Test
    public void supplierTest() {

        Supplier<User> supplier = User::new;
        supplier.get().setName("123");
        System.out.println(supplier.get().getName());
    }

    @Test
    public void testConsumer() {
        Supplier<User> supplier = User::new;
        Consumer<User> consumer = item -> System.out.println("hello");
        consumer.accept(supplier.get());
//        consumer.andThen(sysUser -> supplier.get().setLoginPwd("asd"));
    }

    @Test
    public void testSortList() {
        List<Integer> integers = new ArrayList<>();
        integers.add(2);
        integers.add(1);
        integers.add(3);
        integers.add(5);
        System.out.println(integers.get(0));
        integers.sort(new Comparator<Integer>() {
            @Override
            public int compare(Integer o1, Integer o2) {
                int result = o2 - o1;
                return result;
            }
        });
        System.out.println(integers.toString());
    }

    public void testStream() {
        List<Integer> list = new ArrayList(){

        };
    }

}
