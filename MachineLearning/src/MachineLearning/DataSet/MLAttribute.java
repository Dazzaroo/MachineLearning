package MachineLearning.DataSet;

import java.util.*;

public class MLAttribute {
	String AttributeName;
	int AttributeValueCount = 0;
	Map<String, Integer> AttributeValueList = new HashMap<String, Integer>();
	
	public MLAttribute(String attributeName) {
		this.AttributeName = attributeName;
		this.AttributeValueCount = 0;
	}
	
	public void AddValue(String value) {
		if (!AttributeValueList.containsKey(value)) {
			AttributeValueList.put(value, AttributeValueCount);
			AttributeValueCount++;
		}
	
	}

}
