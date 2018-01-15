package xdean.java9.base;

public class TestProcessHandle {
  public static void main(String[] args) {
    ProcessHandle.allProcesses()
        .filter(ProcessHandle::isAlive)
        .filter(ph -> ph.pid() == 9008)
        .forEach(ph -> {
          printProcess(ph);
          System.out.println(ph.destroy());
        });
  }

  private static void printProcess(ProcessHandle ph) {
    System.out.println(ph.pid() + ", " + ph.info());
  }
}
