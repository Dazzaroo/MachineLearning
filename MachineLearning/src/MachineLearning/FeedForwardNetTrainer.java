package MachineLearning;

public class FeedForwardNetTrainer {
	FeedForwardNet FFN;
	TrainingSet ts;
	
	FeedForwardNetTrainer(TrainingSet ts, int noHiddens) {
		FFN = new FeedForwardNet(ts.NoInputs, ts.NoOutputs, noHiddens);
		this.ts = ts;
	}
	
    void Train() {
    	boolean hasLearned = false;
    	ErrorMeasure errorMeasure;
    	double totalError;
    	int count = 0;
    	
    	while(!hasLearned && count < 10) {
    		totalError = 0.0;
    		hasLearned = true;
    		count ++;
    		for (int i=0; i<ts.RecordCount; i++) {
    			errorMeasure = FFN.ForwardPassTrain(ts.InputRecords[i], ts.OutputRecords[i]);
    			totalError += errorMeasure.Error;
    			if (!errorMeasure.HasLearned)
    				hasLearned = false;
    		}
    		System.out.println("Error = " + Double.toString(totalError));
    	}
    }
}
