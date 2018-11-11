package jcsprout;

import lombok.Synchronized;

/**
 * @author created by glinlf
 * @date 2018/11/11
 * @remark 多线程相关
 */
public class JThread {

    public static void main(String[] args) {

        synchronized (JThread.class) {
            System.out.println("hello synchroized!");
        }
    }

    // 重检查锁的单例模式
    /**
     * 关键字volatile 保证内存的可见性 和执行的顺序性（了防止指令重排）
     * <p>
     * 当然也可以使用synchrosized和lock实现 只是开消息较大。
     * 作用
     * 1。了防止指令重排
     * 2。控制停止线程的标记
     */
    private static volatile JThread jThread;

    public JThread() {
    }

    public static JThread getSingeleInstance() {
        if (jThread == null) {
            synchronized (JThread.class) {
                if (jThread == null) {
                    jThread = new JThread();
                }
            }
        }
        return jThread;
    }


    // 控制停止线程的标记
    /**
     * 这里如果没有用 volatile 来修饰 flag ，
     * 就有可能其中一个线程调用了 stop()方法修改了 flag 的值并不会立即刷新到主内存中，
     * 导致这个循环并不会立即停止。
     */
    private volatile boolean flag;

    private void run() {
        new Thread(new Runnable() {
            @Override
            public void run() {
                while (flag) {
                    getSingeleInstance();
                }
            }
        });
    }

    private void stop() {
        flag = false;
    }

    // 总结：volatile 关键字只能保证可见性，顺序性，不能保证原子性。
}
