package MachineLearning;

public class ErrorMeasure {
	boolean HasLearned;
	double  Error;
	
	ErrorMeasure(boolean hasLearned, double Error) {
		this.HasLearned = hasLearned;
		this.Error = Error;
	}
}
