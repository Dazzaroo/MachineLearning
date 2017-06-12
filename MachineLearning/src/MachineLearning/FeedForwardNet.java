package MachineLearning;

public class FeedForwardNet {
	int NoInputs;
	int NoHiddens;
	int NoOutputs;
	
	double MAX_INIT_WEIGHT;
	
	double InputHiddenWeights[][];
	double HiddenBias[];
	double HiddenOutputWeights[][];
	double OutputBias[];
	double InputActivation[];
	double OutputActivation[];
	double HiddenActivation[];
	
	double n = 0.1;
	
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
	}
	
	double Squash(double value) {
		return (1/ ( 1 + Math.exp(-value)));
	}
	
	void ForwardPassTrain(double[] input, double[] output) {
		double delta;
		ForwardPass(input);
		
		for (int i=0; i<NoInputs; i++) {
			delta = (output[i] - OutputActivation[i] )  * OutputActivation[i] * ( 1 - OutputActivation[i]);
			for (int j=0; j < NoHiddens; j++) {
				HiddenOutputWeights[j][i] += n * HiddenOutputWeights[j][i] * delta;
			}
			OutputBias[i] += n * OutputBias[i] * delta;
		}
		for (int i=0; i <NoHiddens; i++) {
			for (int j=0; j < NoInputs; j++) {
				//delta = 
			}
		}
		
	}
	
	void ForwardPass(double[] input) {
	
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
	}
	
	boolean ForwardPassError(double[] input, double[] output, out error) {
	    double error = 0.0;
		ForwardPass(input);
	    for (int i=0; i< NoOutputs; i++) {
	    	
	    }
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
