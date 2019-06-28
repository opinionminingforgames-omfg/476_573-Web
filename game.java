package game;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;

import weka.core.Instances;

public class game {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println("Game Evaluation");
		
		String stopWords = ".\\Dataset\\stopwords.txt";
		String dictionaryWords = ".\\Dataset\\dictionary.txt";
		String dataset = ".\\Dataset\\dataset.txt";
		String feature = ".\\Dataset\\feature.txt";
		
		DataProcessor pro = new DataProcessor();
		
		pro.ReadStopWords(stopWords);
		pro.ReadDictionary(dictionaryWords);
		pro.ReadData(dataset);
		pro.PreProcessor();
		pro.CreateFeatureVector();
		pro.WriteFeatureVectorToFile(feature);
		
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
			
			Classification objClassification = new SVM();
			objClassification.MakeClasification(data);
			
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
