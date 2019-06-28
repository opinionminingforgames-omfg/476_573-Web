package game;

import weka.classifiers.Evaluation;
import weka.classifiers.functions.SMO;
import weka.core.Instances;

public class SVM extends Classification {
	public void MakeClasification(Instances data)
	{
		Instances test = new Instances(data);
		Instances train = new Instances(data);
		int numOffData = data.numInstances();
		int step = numOffData / 5;
		
		for(int j=0; j < 5; j++)
		{ 
			right = 0;
			wrong = 0;
			test.delete();
			train.delete();
			for(int i=0; i<step; i++)
			{
				test.add(data.instance((j * step) + i));
			}
			for(int i=0; i<numOffData; i++)
			{
				if(i < j * step || i >= ((j+1) * step))
				{
					train.add(data.instance(i));
				}
			}
			
			SMO smoClass = new SMO();
			
			try {
				smoClass.buildClassifier(data);
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
			Evaluation testData = null;
			try {
				testData = new Evaluation(data);
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			try {
				testData.evaluateModel(smoClass, data);
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		    
		    testDataSize = test.numInstances();
		    right = 0;
		    wrong = 0;
		    
		    for (int i = 0; i < test.numInstances(); i++) 
		    {
		    	double clsLabel = -1;
				try {
					clsLabel = smoClass.classifyInstance(test.instance(i));
				} catch (Exception e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
		    	if(test.instance(i).classValue() == clsLabel)
		    		right++;
		    	else
		    		wrong++;
		    	
	    	}
		    precision = testData.precision(0);
			recall = testData.recall(0);
			fMeasure = testData.fMeasure(0);
			PrintResult(j);
		}
	}
	public void PrintResult(int index)
	{
		System.out.println("*************************");
		System.out.println("*************************");
		System.out.println("SVM");
		System.out.println("Cross Validation : " + index);
		System.out.print("Right Result Number: ");
		System.out.println(right);
		
		System.out.print("Wrong Result Number: ");
		System.out.println(wrong);
		
		System.out.print("Right Result %: ");
		System.out.println((right/(double)testDataSize)*100);
		
		System.out.print("Precision: ");
		System.out.println(precision);
		
		System.out.print("Recall: ");
		System.out.println(recall);
		
		System.out.print("F-Measure: ");
		System.out.println(fMeasure);
		
		System.out.println("*************************");
		System.out.println("*************************");
		System.out.println("");
	}
}
