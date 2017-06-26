package MachineLearning.DataSet;

public class TrainingSet {
	public int RecordCount;
	public int NoInputs;
	public int NoOutputs;
	
	public double[][] InputRecords;
	public double[][] OutputRecords;

	public TrainingSet(int NoInputs, int NoOutputs, int RecordCount) {
	   this.NoInputs = NoInputs;
	   this.NoOutputs = NoOutputs;
	   this.RecordCount = RecordCount;
	   InputRecords = new double[RecordCount][NoInputs];
	   OutputRecords = new double[RecordCount][NoOutputs];
	}
	
	void TrainingSet(String fileName) {

	}
	
}
