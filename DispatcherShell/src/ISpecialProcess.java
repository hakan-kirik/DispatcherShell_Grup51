import java.awt.Color;

public interface ISpecialProcess {
	void decreasePriority();
	void decreaseBurstTime();
	int getPid();
	Priority getPriority();
	int getBurstTime();
	Color getColor();
	Statement getStatement();
}