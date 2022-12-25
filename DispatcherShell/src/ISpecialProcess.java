import java.awt.Color;

public interface ISpecialProcess {
	void decreasePriority();
	void decreaseBurstTime();
	int getPid();
	Priority getPriority();
	int getBurstTime();
	int getDestinationTime();
	Color getColor();
	Statement getStatement();
	void setStatement(Statement statement);
}