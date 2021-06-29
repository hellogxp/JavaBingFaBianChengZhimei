package CreateThread;

/**
 * @Description: TODO
 * @Author chopin
 * @Date 2021/6/28 10:55 PM
 * @Version 1.0
 */
public class ThreadWay extends Thread{
    public String userName;

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public static void main(String[] args) {
        ThreadWay thread0 = new ThreadWay();
        ThreadWay thread1 = new ThreadWay();
        thread0.setUserName("Edinburgh");
        thread1.setUserName("Oxford");
        thread0.start();
        thread1.start();
    }

    @Override
    public void run() {
        System.out.println(this.getName() + " " + this.getUserName() + " Create thread extending Thread");
    }
}