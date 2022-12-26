import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Processor implements IProcessor {
	private ISpecialProcess currentProcess;

	public Processor() {

	}

	private void runProcess(ISpecialProcess process, int currentTime, String message) {
	try {
		ProcessBuilder pb = process.getProcessBuilder();
		pb.command(process.getPriority().toString());
		pb.command().add(message);
		Process p = pb.start();
		BufferedReader in = new BufferedReader(new InputStreamReader(p.getInputStream()));
		String s = "";
		while((s = in.readLine()) != null){
		    System.out.println(s);
		}
		pb.command().remove(pb.command().size()-1);
		pb.command().remove(pb.command().size()-1);
		p.destroyForcibly();
	} catch (Exception e) {
		// TODO: handle exception
	}
	}

	@Override
	public void run(ISpecialProcess process, int currentTime) {
		

	}

}