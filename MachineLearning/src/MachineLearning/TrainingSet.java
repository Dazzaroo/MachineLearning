package MachineLearning;

public class TrainingSet {
	int RecordCount;
	public int NoInputs;
	public int NoOutputs;
	
	double[][] InputRecords;
	double[][] OutputRecords;

	TrainingSet(int NoInputs, int NoOutputs, int RecordCount) {
	   this.NoInputs = NoInputs;
	   this.NoOutputs = NoOutputs;
	   this.RecordCount = RecordCount;
	   InputRecords = new double[RecordCount][NoInputs];
	   OutputRecords = new double[RecordCount][NoOutputs];
	}
	
	void TrainingSet(String fileName) {

	}
	
}
