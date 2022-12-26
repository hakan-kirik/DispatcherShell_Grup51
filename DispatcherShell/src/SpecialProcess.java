import java.awt.Color;

public class SpecialProcess implements ISpecialProcess {
	private ProcessBuilder process;
	private int pid;
	private Priority priority;
	private int burstTime;
	private int waitingTime;
	private Color color;
	private Statement statement;

	public SpecialProcess(int pid, Priority priority, int burstTime) {
		this.pid=pid;
		this.priority=priority;
		this.burstTime=burstTime;
		this.waitingTime=0;
		this.color=Colors.getInstance().getColor(pid);
		process=new ProcessBuilder("java","-jar","./Process.jar",String.valueOf(pid));
		
	}

	@Override
	public void decreasePriority() {
		if(this.priority==Priority.Highest) {
			this.priority=Priority.Medium;
		}else if(this.priority==Priority.Medium) {
			this.priority=Priority.Lowest;
		}else if(this.priority==Priority.RealTime) {
			this.priority=Priority.Highest;
		}

	}

	@Override
	public void decreaseBurstTime() {
		this.burstTime--;

	}

	@Override
	public boolean increaseWaitingTime() {
		this.waitingTime++;
		return this.waitingTime>20 ?  false : true;
		
	}

	@Override
	public void resetWaitingTime() {
		this.burstTime=0;
		
	}

	@Override
	public int getPid() {
		
		return this.pid;
	}

	@Override
	public Priority getPriority() {
		
		return this.priority;
	}

	@Override
	public int getBurstTime() {
		
		return this.burstTime;
	}

	@Override
	public ProcessBuilder getProcessBuilder() {
		
		return this.process;
	}

	@Override
	public Color getColor() {
		return this.color;
	}

	@Override
	public Statement getStatement() {
		
		return this.statement;
	}

	@Override
	public void setStatement(Statement statement) {
		this.statement=statement;

	}

}
