package MachineLearning;

public class FeedForwardNet {
	int NoInputs;
	int NoHiddens;
	int NoOutputs;
	
	double MAX_INIT_WEIGHT = 0.1;
	double OUTPUT_TOLERANCE = 0.1;
	
	double InputHiddenWeights[][];
	double HiddenBias[];
	double HiddenOutputWeights[][];
	double OutputBias[];
	double InputActivation[];
	double OutputActivation[];
	double HiddenActivation[];
	double OutputDelta[];
	double HiddenDSum[];
	double HiddenDelta[];
	
	double N = 0.1;
	
	FeedForwardNet(int noInputs, int noOutputs, int noHiddens) {
		NoHiddens = noHiddens;
		this.NoInputs = noInputs;
		this.NoOutputs = noOutputs;
		
		InputHiddenWeights = new double[NoInputs][NoHiddens];
		HiddenBias = new double[NoHiddens];
		
		HiddenOutputWeights = new double[NoHiddens][NoOutputs];
		OutputBias = new double[NoOutputs];
		
		InputActivation = new double[NoInputs];
		OutputActivation = new double[NoOutputs];
		HiddenActivation = new double[NoHiddens];
		
		OutputDelta = new double[NoOutputs];
		HiddenDSum = new double[NoHiddens];
		HiddenDelta = new double[NoHiddens];
		
		Randomize();
	}
	
	double Squash(double value) {
		return (1/ ( 1 + Math.exp(-value)));
	}
	
	ErrorMeasure ForwardPassTrain(double[] input, double[] output) {

		ErrorMeasure errorMeasure;
		errorMeasure = ForwardPass(input, output);
		
		/* Calculate Output/Hidden deltas */
		for (int i=0; i<NoOutputs; i++) {
			OutputDelta[i] = (output[i] - OutputActivation[i] )  * OutputActivation[i] * ( 1 - OutputActivation[i]);
		}
			
		for (int j=0; j < NoHiddens; j++) {
			HiddenDSum[j] = 0.0;
			for (int i=0; i<NoOutputs; i++) {
				HiddenDSum[j] += OutputDelta[i] * HiddenOutputWeights[j][i];
			
			}
			HiddenDelta[j] = HiddenActivation[j] * ( 1 - HiddenActivation[j]) * HiddenDSum[j] ;
		}
			
		/* Train Weights */
		for (int i=0; i<NoOutputs; i++) {
			for (int j=0; j <NoHiddens; j++) {
				HiddenOutputWeights[j][i] += N * HiddenOutputWeights[j][i] * OutputDelta[i];
			}
			OutputBias[i] += N * OutputBias[i] * OutputDelta[i];
		}
		
		for (int i=0; i <NoHiddens; i++) {
			for (int j=0; j < NoInputs; j++) {
				InputHiddenWeights[j][i] += N * InputHiddenWeights[j][i] * HiddenDelta[i];
			}
			HiddenBias[i] += N * HiddenBias[i] * HiddenDelta[i];
		}
		return (errorMeasure);
	}
	
	ErrorMeasure ForwardPass(double[] input, double[] output) {
	
		SetInputActivation(input);
		
		double weightSum;
	
		for (int i=0; i<NoHiddens; i++) {
			weightSum = 0.0;
			for (int j=0; j<NoInputs; j++) {
				weightSum += InputActivation[j] * InputHiddenWeights[j][i];
			}
			weightSum += HiddenBias[i];
			HiddenActivation[i] = Squash(weightSum);
		}
		
		for (int i=0; i<NoOutputs; i++) {
			weightSum = 0.0;
			for (int j=0; j<NoHiddens; j++) {
				weightSum += HiddenActivation[j] * HiddenOutputWeights[j][i];	
			}
			weightSum += OutputBias[i];
			OutputActivation[i] = Squash(weightSum);
		}
		return ForwardPassError(input, output);
	}
	
	ErrorMeasure ForwardPassError(double[] input, double[] output) {
	    ErrorMeasure errorMeasure;
		double sumError = 0.0;
	    double localError;
	    boolean hasLearned = true;
	
	    for (int i=0; i< NoOutputs; i++) {
	    	localError = Math.abs(output[i] - OutputActivation[i]);
	    	if (localError > OUTPUT_TOLERANCE)
	    		hasLearned = false;
	    	sumError += localError;
	    }
	    errorMeasure = new ErrorMeasure(hasLearned, sumError);
	    return(errorMeasure);
	    
	}
	
	void SetInputActivation(double[] input) {
		for (int i=0; i< NoInputs; i++) {
			  InputActivation[i] = input[i];
		}	
	}
	double GetRandomWeight() {
		double val = ((Math.random() * MAX_INIT_WEIGHT * 2) - MAX_INIT_WEIGHT);
		return (double)val;
	}
	
	void Randomize() {
		for (int i=0; i<NoHiddens; i++) {
			for (int j=0; j<NoInputs; j++) {
				InputHiddenWeights[j][i] = GetRandomWeight();
			}
			HiddenBias[i] = GetRandomWeight();
		}
		for (int i=0; i<NoOutputs; i++) {
			for (int j=0; j<NoHiddens; j++) {
				HiddenOutputWeights[j][i] = GetRandomWeight();
			}
			OutputBias[i] = GetRandomWeight();
		}
	}

}
