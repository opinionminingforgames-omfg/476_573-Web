package game;

import weka.classifiers.Evaluation;
import weka.classifiers.bayes.NaiveBayes;
import weka.core.Instances;

public class BayesClassification extends Classification {

	public void MakeClasification(Instances data)
	{
		Instances test = new Instances(data);
		Instances train = new Instances(data);
		int numOffData = data.numInstances();
		int step = numOffData / 10;
		for(int j=0; j < 10; j++)
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
					train.add(data.instance(i));
			}
			NaiveBayes nb = new NaiveBayes();
		
			try {
				nb.buildClassifier(train);
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
			Evaluation testData = null;
			try {
				testData = new Evaluation(test);
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			double a[] = null;
			try {
				a = testData.evaluateModel(nb, test);
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
			testDataSize = test.numInstances();
			
			for(int i=0; i<testDataSize; i++)
			{
				double realResult = test.instance(i).classValue();
				if(realResult == a[i])
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
		System.out.println("NAIVE BAYES CLASSIFIER");
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
