package game;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;

import weka.core.Instances;

public class ML {

	String stopWords = ".\\Dataset\\stopwords.txt";
	String dictionaryWords = ".\\Dataset\\dictionary.txt";
	String dataset = ".\\Dataset\\dataset.txt";
	String feature = ".\\Dataset\\feature.txt";
	String featureTest = ".\\Dataset\\featureTest.txt";
	
	DataProcessor pro;
	Classification objClassification;
	
	public ML()
	{
		pro = new DataProcessor();
		objClassification = new SVM();
	}
	
	public void Init()
	{
		pro.ReadStopWords(stopWords);
		pro.ReadDictionary(dictionaryWords);
		pro.ReadData(dataset);
		pro.PreProcessor();
		pro.CreateFeatureVectorForData(feature);
		
		// Classification
		File file = new File(feature);
		BufferedReader reader = null;
		try {
			reader = new BufferedReader(
			        new FileReader(file));
		
			Instances data;
		
		
			data = new Instances(reader);
			reader.close();
			
			data.setClassIndex(data.numAttributes() - 1);
			
			
			objClassification.Train(data);
			
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public String GetValue(String test)
	{
		String classValue = "";
		
		pro.CreateFeatureVectorForTest(test, featureTest);
		
		// Classification
		File file = new File(featureTest);
		BufferedReader reader = null;
		try {
			reader = new BufferedReader(
			        new FileReader(file));
		
			Instances data;
		
		
			data = new Instances(reader);
			reader.close();
			
			data.setClassIndex(data.numAttributes() - 1);
			
			classValue = objClassification.TestInstance(data);
			
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return classValue;
		
	}
	
	public String GetValue(ArrayList<String> test)
	{
		String classValue = "";
		
		pro.CreateFeatureVectorForTest(test, featureTest);
		
		// Classification
		File file = new File(featureTest);
		BufferedReader reader = null;
		try {
			reader = new BufferedReader(
			        new FileReader(file));
		
			Instances data;
		
		
			data = new Instances(reader);
			reader.close();
			
			data.setClassIndex(data.numAttributes() - 1);
			
			classValue = objClassification.TestInstance(data);
			
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return classValue;
		
	}
	
}
