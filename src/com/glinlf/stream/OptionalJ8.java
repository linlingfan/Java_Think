package com.glinlf.stream;

import java.util.Optional;

/**
 * @author created by glinlf
 * @date 2018/9/6
 * @remark
 */
public class OptionalJ8 {

    public static void main(String[] args) {

        Optional<User> optional = Optional.ofNullable(null); // 可能为空的值或者某个类型的值

        System.out.println(optional);
        System.out.println(optional.isPresent());        // 是否为null
        System.out.println(optional.orElse(null)); // null 则返回null
        System.out.println(optional.orElseGet(() -> new User(2, "llf", 25))); // null则返回 构建的值


        User user = new User(1, "glinlfl", 24);
        Optional<User> userOptional = Optional.of(user);

        System.out.println(userOptional);
        System.out.println(userOptional.orElseGet(() -> new User()));
        System.out.println(userOptional.isPresent());
        System.out.println(userOptional.map(item -> new User(item.getId(), "llf", 25)).orElse(null)); // map()方法可以将现有的Opetional实例的值转换成新的值
        System.out.println(userOptional.map(item -> item.getAge()).orElse(null)); // map()方法可以将现有的Opetional实例的值转换成新的值

    }
}
