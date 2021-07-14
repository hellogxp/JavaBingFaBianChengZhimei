package ThreadLocal;

/**
 * @author chopin
 * @version 1.0
 * @description: TODO
 * @date 2021/7/14 22:07
 */
public class ThreadLocalTest {
    private static ThreadLocal<String> threadLocal = new ThreadLocal<>();

    private static void remove() {
        threadLocal.remove();
    }

    public static void main(String[] args) {
        Thread threadA = new Thread(new Runnable() {
            @Override
            public void run() {
                threadLocal.set("LocalA variable");
                System.out.println("ThreadA's local variable: " + threadLocal.get());
                remove();
                System.out.println("ThreadA's local variable after remove: " + threadLocal.get());
            }
        });

        Thread threadB = new Thread(new Runnable() {
            @Override
            public void run() {
                threadLocal.set("LocalB variable");
                System.out.println("ThreadB's local variable: " + threadLocal.get());
                remove();
                System.out.println("ThreadB's local variable after remove: " + threadLocal.get());
            }
        });

        threadA.start();
        threadB.start();
    }
}