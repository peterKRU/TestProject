package tokenizerMod;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
 
import opennlp.tools.tokenize.TokenizerME;
import opennlp.tools.tokenize.TokenizerModel;

public class WordTokenizerTest {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		System.out.println("Word Tokenizer Test");
		
		InputStream modelIn = null;
		
        try {
            modelIn = new FileInputStream("C:\\ApacheOpenNLP\\OpenNLP_Models\\opennlp-en-ud-ewt-tokens-1.0-1.9.3.bin");
            TokenizerModel model = new TokenizerModel(modelIn);
            TokenizerME tokenizer = new TokenizerME(model);
            String tokens[] = tokenizer.tokenize("The core purpose of the program is to provide a simple and straightforward way for the user to process natural language by using core NLP tools and to visualize the output in a coherent manner.");
            double tokenProbs[] = tokenizer.getTokenProbabilities();
             
            System.out.println("Token\t: Probability\n-------------------------------");
            for(int i=0;i<tokens.length;i++){
                System.out.println(tokens[i]+"\t: "+tokenProbs[i]);
            }
        }
        
        catch (IOException e) {
            e.printStackTrace();
        }
        
        finally {
        	if(modelIn != null) {
                try {
                    modelIn.close();
                }
                catch (IOException e) {
                }
        	}
        }
		
	}

}
