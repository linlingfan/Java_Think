/**
 * @author created by glinlf
 * @date 2018/9/2
 * @remark
 */
public interface UserService {


    /**
     * java8 新特性 接口静态方法
     *
     * @return
     */
    static String staticMethod() {
        return "static";
    }

    /**
     * 接口默认方法
     *
     * @return
     */
    default String defaultMethod() {
        return "default";
    }

}
