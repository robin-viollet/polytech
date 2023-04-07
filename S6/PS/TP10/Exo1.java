import java.lang.management.ManagementFactory;
import java.lang.ProcessHandle;

public class Exo1 {
	public static void main(String[] args){
		System.out.println(ManagementFactory.getRuntimeMXBean().getName());
		System.out.println(ProcessHandle.current().pid());
	}
}
