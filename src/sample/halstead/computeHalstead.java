package sample.halstead;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.StreamTokenizer;
import java.util.ArrayList;
import java.util.List;

public class computeHalstead {

    private List<String> Operators = new ArrayList<>();
    private List<String> Operands = new ArrayList<>();

    public void compute(File currentFile)throws Exception
    {
        codeList codes = new codeList();
        vocabularyList vocabs = new vocabularyList();
        codes.setCodeList(currentFile);
        vocabs.setVocabList("HalLib");
        categorizeElements(codes, vocabs);
    }

    private void categorizeElements(codeList code, vocabularyList vocab)
    {
        int operandIndex = -1;
        int vocabIndex;

        for(int i = 0; i < code.getCodeList().size(); i++){
            vocabIndex = vocab.isOperator(code.getCodeList().get(i));
            if(vocabIndex > -1){
                if(vocab.getVocabList().get(vocabIndex).getPrefixFlag()){           //checks if the operator is prefixed
                    Operators.add(code.getCodeList().get(i));
                    Operands.add(code.getCodeList().get(i+1));
                    operandIndex = i+1;
                } else if(vocab.getVocabList().get(vocabIndex).getSuffixFlag()){    //checks if the operator is suffixed
                    Operators.add(code.getCodeList().get(i));
                    if(i-1 != operandIndex)
                        Operands.add(code.getCodeList().get(i-1));
                    operandIndex = i;
                } else {                                                            //else operator is infixed
                    Operators.add(code.getCodeList().get(i));
                    Operands.add(code.getCodeList().get(i+1));
                    if(i-1 != operandIndex)
                        Operands.add(code.getCodeList().get(i-1));
                    operandIndex = i+1;
                }
            }
        }
    }

    //Another test, another main
    public static void main(String[] args)throws Exception{
        computeHalstead test = new computeHalstead();
        File testFile = new File("src/sample/halstead/halstead.java");
        test.compute(testFile);
        System.out.println(test.Operators.size());
        System.out.println(test.Operands.size());
    }
}
