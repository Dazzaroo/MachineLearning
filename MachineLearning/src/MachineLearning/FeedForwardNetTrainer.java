package MachineLearning;

public class FeedForwardNetTrainer {
	FeedForwardNet FFN;
	
	FeedForwardNetTrainer(TrainingSet ts, int noHiddens) {
		FFN = new FeedForwardNet(ts.NoInputs, ts.NoOutputs, noHiddens);
	}
	
    void Train() {
    	
    }
}
