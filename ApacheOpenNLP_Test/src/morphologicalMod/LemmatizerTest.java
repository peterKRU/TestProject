package morphologicalMod;

import opennlp.tools.langdetect.*;
import opennlp.tools.lemmatizer.DictionaryLemmatizer;
import opennlp.tools.postag.POSModel;
import opennlp.tools.postag.POSTaggerME;

import java.io.*;

public class LemmatizerTest {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println("Lemmatizer test");
		
		try {
			
			//test sentence
			String[] tokens = new String[]{"Most", "large", "birds", "have", "problems","."};
			
			// Parts-Of-Speech Tagging
			// reading parts-of-speech model to a stream
			InputStream posModelIn = new FileInputStream("C:\\ApacheOpenNLP\\OpenNLP_Models\\opennlp-en-ud-ewt-pos-1.0-1.9.3.bin");
            
			// loading the parts-of-speech model from stream
            POSModel posModel = new POSModel(posModelIn);
			
            // initializing the parts-of-speech tagger with model
            POSTaggerME posTagger = new POSTaggerME(posModel);
			
            // Tagger tagging the tokens
            String tags[] = posTagger.tag(tokens);
            
            // loading the dictionary to input stream
            InputStream dictLemmatizer = new FileInputStream("C:\\ApacheOpenNLP\\OpenNLP_Models\\en-lemmatizer.dict.txt");
            
            // loading the lemmatizer with dictionary
            DictionaryLemmatizer lemmatizer = new DictionaryLemmatizer(dictLemmatizer);
            
            // finding the lemmas
            String[] lemmas = lemmatizer.lemmatize(tokens, tags);
            
            //printing results
            System.out.println("\nPrinting lemmas for the given sentence...");
            System.out.println("WORD -POSTAG : LEMMA");
            for(int i=0;i< tokens.length;i++){
                System.out.println(tokens[i]+" -"+tags[i]+" : "+lemmas[i]);
            }
            
		} 
		
		catch(FileNotFoundException e) {
			 e.printStackTrace();
		}
		
		catch(IOException e) {
			e.printStackTrace();
		}
		
		
	}

}
