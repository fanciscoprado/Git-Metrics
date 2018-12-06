package sample.halstead;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.StreamTokenizer;
import java.util.ArrayList;
import java.util.List;

public class computeHalstead {

    List<String> Operators = new ArrayList<>();
    List<String> Operands = new ArrayList<>();

    public void compute(File currentFile)throws Exception
    {
        codeList codes = new codeList();
        vocabularyList vocab = new vocabularyList();
        codes.setCodeList(currentFile);
        vocab.setVocabList("HalLib");
        categorizeElements(codes.getCodeList(), vocab.getVocabList());
        //COMPARE ELEMENTS CALL
        //needs to do a lot more than this
        //it needs a vocab list from vocab constructor
        //it needs to compare elements from the codeList to the vocab list and delegate operator or operand status
        //      to individual elements -- or call another method to that.
        //this class as a whole needs to be able to calculate n1, n2, N1 and N2
        //calculating secondary and tertiary stats will likely be this classes job as well
    }

    private void categorizeElements(ArrayList<String> uncategorizedCode, ArrayList<halsteadOperator> definitions)
    {

    }

    //Another test, another main
    public static void main(String[] args)throws Exception{
        computeHalstead test = new computeHalstead();
        File testFile = new File("src/sample/wc.java");
        test.compute(testFile);
    }
}
