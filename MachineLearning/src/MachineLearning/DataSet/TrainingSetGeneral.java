package MachineLearning.DataSet;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;

public class TrainingSetGeneral {
	public int RecordCount;
	public int NoInputs;
	public int NoOutputs;
	
	public void TrainingSetGeneral() {
		
	}
	
	public void LoadFile(String fileName) {
		try(BufferedReader br = new BufferedReader(new FileReader(fileName))) {
		    StringBuilder sb = new StringBuilder();
		    String line = br.readLine();
		    String[] inputs;
		    String[] noInputOutputs;
		    String[] attributes;
		    noInputOutputs = line.split("\\s+");
		    NoInputs = Integer.valueOf(noInputOutputs[0]);
		    NoOutputs = Integer.valueOf(noInputOutputs[1]);
		    attributes = line.split("\\s+");
	
			for (String item : attributes) {
			    System.out.println(item);
			}
		    line = br.readLine();
		    while (line != null) {
		        sb.append(line);
		        sb.append(System.lineSeparator());
		        line = br.readLine();
		        inputs = line.split("\\s+");
		        AddInputLine(inputs);
		    }
		    //String everything = sb.toString();
		}	
	}
	
	public void AddInputLine(String[] inputLine) {
		
	}

}
