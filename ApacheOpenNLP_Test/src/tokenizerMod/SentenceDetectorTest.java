package tokenizerMod;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;

import opennlp.tools.sentdetect.SentenceDetectorME;
import opennlp.tools.sentdetect.SentenceModel;
import opennlp.tools.util.InvalidFormatException;

public class SentenceDetectorTest {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println("Sentence detector test");
		
        try {
            new SentenceDetectorTest().sentenceDetect();
        } catch (IOException e) {
            e.printStackTrace();
        }
		
	}
	
	public void sentenceDetect() throws InvalidFormatException, IOException{
	
		 //define test paragraph
		 String paragraph = "The document defines the technical specification for the XXX NLP Notepad Tool. The XXX is a desktop tool aiming to be a simple, fast and easy to use notepad with NLP functionality which give the user limited yet powerful abilities to process, analyse and present natural text. The tool attempts to increase language intelligibility and provide enhanced search and output visualization options. \r\n"
		 		+ "";
		
		 //refer to the ml model
	     InputStream is = new FileInputStream("C:\\ApacheOpenNLP\\OpenNLP_Models\\opennlp-en-ud-ewt-sentence-1.0-1.9.3.bin");
	     SentenceModel model = new SentenceModel(is);
	     
	     //load model
	     SentenceDetectorME sdetector = new SentenceDetectorME(model);
	     
	     //detect sentences in paragraph
	     String sentences[] = sdetector.sentDetect(paragraph);
	     
	     //print sentences
	        for(int i=0;i<sentences.length;i++){
	            System.out.println("Sentence: " + sentences[i]);
	        }
	     
        is.close();
        
	}
	
}



