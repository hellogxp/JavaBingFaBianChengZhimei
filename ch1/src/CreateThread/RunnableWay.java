package CreateThread;

/**
 * @Description: TODO
 * @Author chopin
 * @Date 2021/6/28 10:35 PM
 * @Version 1.0
 */
public class RunnableWay implements Runnable{
  private String userName;
  final String password = "123";

  public String getUserName() {
    return userName;
  }

  public void setUserName(String userName) {
    this.userName = userName;
  }

  @Override
    public void run() {
        System.out.println(Thread.currentThread().getName() + " " + this.getUserName() + " Create thread implementing runnable");
    }

    public static void main(String[] args) {
      RunnableWay runnable = new RunnableWay();
      runnable.setUserName("London");
      new Thread(runnable).start();
      new Thread(runnable).start();
    }
}