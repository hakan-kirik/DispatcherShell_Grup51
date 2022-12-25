import java.awt.Color;

public class SpecialProcess implements ISpecialProcess {
	private ProcessBuilder process;
	private int pid;
	private Priority priority;
	private int burstTime;
	private int destinationTime;
	private Color color;
	private Statement statement;

	public SpecialProcess(int pid, Priority priority, int burstTime, int destinationTime) {

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
	public int getDestinationTime() {
		// TODO Auto-generated method stub
		return 0;
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
