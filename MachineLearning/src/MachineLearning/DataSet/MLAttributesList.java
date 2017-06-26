package MachineLearning.DataSet;

import java.util.*;

public class MLAttributesList {

	int MLAttributeCount = 0;
	List<MLAttribute> MLAttributeList = new ListArray<MLAttribute>;
	public MLAttributesList() {
		// TODO Auto-generated constructor stub
	}
	
	public void AddAttribute(String attributeStr) {
		boolean found = false;
		for (int i=0; i<MLAttributeList.size(); i++) {
		   MLAttribute attribute = MLAttributeList.get(i);
		   if (attribute.AttributeName == attributeStr) {
			  found = true;
			  break;
		   }
		}
		if (!found) {
			MLAttribute attr = new MLAttribute(attributeStr);
			MLAttributeList.add(attr);
		}
	}
	/*public void AddAttribute(MLAttribute attribute) {
		if (!MLAttributeList.containsKey(attribute)) {
			MLAttributeList.put(attribute, MLAttributeCount);
			MLAttributeCount++;
		}
	}*/

}
