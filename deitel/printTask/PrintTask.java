import java.security.SecureRandom;

public class PrintTask implements Runnable{
  private static final SecureRandom random = new SecureRandom();
  private final int sleepTime;
  private final String taskName;

  public PrintTask(String taskName){
    this.taskName = taskName;

    sleepTime = random.nextInt(5000);
  }

  public void run(){
    try{
      System.out.printf("%s going to sleep for %d milliseconds.%n", taskName, sleepTime);
      Thread.sleep(sleepTime);
    }
    catch(InterruptedException exception){
      exception.printStackTrace();
      Thread.currentThread().interrupt();
    }

    System.out.printf("%s done sleeping%n", taskName);
  }



}
