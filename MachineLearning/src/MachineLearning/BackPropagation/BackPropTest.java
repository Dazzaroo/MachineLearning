package MachineLearning.BackPropagation;

import MachineLearning.DataSet.*;

public class BackPropTest {
   public BackPropTest() {
	   
   }
   public void RunTest() {
	   TrainingSet ts = new TrainingSet(2, 1, 4);
	   ts.InputRecords[0][0] = 0.0;
	   ts.InputRecords[0][1] = 1.0;
	   ts.OutputRecords[0][0] = 1.0;
	   ts.InputRecords[1][0] = 1.0;
	   ts.InputRecords[1][1] = 0.0;
	   ts.OutputRecords[1][0] = 1.0;
	   ts.InputRecords[2][0] = 0.0;
	   ts.InputRecords[2][1] = 0.0;
	   ts.OutputRecords[2][0] = 0.0;
	   ts.InputRecords[3][0] = 1.0;
	   ts.InputRecords[3][1] = 1.0;
	   ts.OutputRecords[3][0] = 0.0;
	  /* ts.InputRecords[0][0] = 0.0;
	   ts.InputRecords[0][1] = 0.0;
	   ts.InputRecords[1][0] = 1.0;
	   ts.InputRecords[1][1] = 0.0;
	   ts.InputRecords[2][0] = 0.0;
	   ts.InputRecords[2][1] = 1.0;
	   ts.InputRecords[3][0] = 1.0;
	   ts.InputRecords[3][1] = 1.0;
	   ts.OutputRecords[0][0] = 0.0;
	   ts.OutputRecords[1][0] = 1.0;
	   ts.OutputRecords[2][0] = 1.0;
	   ts.OutputRecords[3][0] = 0.0;*/
	   
	   FeedForwardNetTrainer trainer = new FeedForwardNetTrainer(ts, 2);
	   trainer.Train();
   }
   
}
