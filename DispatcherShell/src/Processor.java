import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Processor implements IProcessor {
	private ISpecialProcess currentProcess;

	public Processor() {

	}

	private void runProcess(ISpecialProcess process, int currentTime, String message) {
	try {
		ProcessBuilder pb = process.getProcessBuilder();
		pb.command(String.valueOf(currentTime));
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
		pb.command().remove(pb.command().size()-1);
		p.destroyForcibly();
	} catch (Exception e) {
		// TODO: handle exception
	}
	}

	@Override
	public void run(ISpecialProcess process, int currentTime) {
			if(this.currentProcess!=process) {
				if(currentProcess.getStatement()==Statement.Terminated) {
					System.out.println("currentprocess sonlandi");//bu ifade gecici olarak yazildi
					this.runProcess(process, currentTime, "Process basladi");
				}else {
					System.out.println("currentprocess askiya alındi");//bu ifade gecici olarak yazildi
					this.runProcess(process, currentTime,"Process basladi");
					
				}
			}else {
				this.runProcess(process, currentTime, "Yürütülüyor");
			}

	}

}