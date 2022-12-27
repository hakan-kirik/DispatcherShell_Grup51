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

	}

	@Override
	public void decreasePriority() {
		// TODO Auto-generated method stub

	}

	@Override
	public void decreaseBurstTime() {
		// TODO Auto-generated method stub

	}

	@Override
	public boolean increaseWaitingTime() {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public void resetWaitingTime() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public int getPid() {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public Priority getPriority() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public int getBurstTime() {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public ProcessBuilder getProcessBuilder() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Color getColor() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Statement getStatement() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void setStatement(Statement statement) {
		// TODO Auto-generated method stub

	}

}
