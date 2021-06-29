package CreateThread;

import java.util.concurrent.Callable;
import java.util.concurrent.FutureTask;

/**
 * @Description: TODO
 * @Author chopin
 * @Date 2021/6/28 11:43 PM
 * @Version 1.0
 */
public class CallableWay implements Callable<String> {
    @Override
    public String call() throws Exception {
        return "hello world";
    }

    public static void main(String[] args) {
        FutureTask<String> futureTask = new FutureTask<>(new CallableWay());
        new Thread(futureTask).start();

        try {
            String result = futureTask.get();
            System.out.println(result);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}