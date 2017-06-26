package MachineLearning.BackPropagation;

public class ErrorMeasure {
	boolean HasLearned;
	double  Error;
	
	public ErrorMeasure(boolean hasLearned, double Error) {
		this.HasLearned = hasLearned;
		this.Error = Error;
	}
}
