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
        categorizeElements(codes, vocab);
        //COMPARE ELEMENTS CALL
        //needs to do a lot more than this
        //it needs a vocab list from vocab constructor
        //it needs to compare elements from the codeList to the vocab list and delegate operator or operand status
        //      to individual elements -- or call another method to that.
        //this class as a whole needs to be able to calculate n1, n2, N1 and N2
        //calculating secondary and tertiary stats will likely be this classes job as well
    }

    private void categorizeElements(codeList uncategorizedCode, vocabularyList definitions)
    {
        for(int i = 0; i < uncategorizedCode.getCodeList().size(); i++){
            if(definitions.isOperator(uncategorizedCode.getCodeList().get(i))){
                if(definitions.getVocabList().get(i).getPrefixFlag()){
                    //its a prefix do prefix stuff
                } else if(definitions.getVocabList().get(i).getSuffixFlag()){
                    //its a suffix do suffix stuff
                } else {
                    //its infix do infix stuff
                }
            }
        }
    }

    /*public void countN()
    {
        int operandIndex = -1;

        for (int i = 0; i < this.codeList.size(); i++) {
            for (String s : FULL_OPERATOR) {
                if(this.codeList.get(i).equals(s)){
                    if(this.codeList.get(i).equals("~")){                                               //~ is in front of operand
                        operatorList.add(this.codeList.get(i));
                        operandList.add(this.codeList.get(i+1));
                        operandIndex = i+1;
                    } else if(this.codeList.get(i).equals("++") || this.codeList.get(i).equals("--")){  //behind operand
                        operatorList.add(this.codeList.get(i));
                        if(i-1 != operandIndex)
                            operandList.add(this.codeList.get(i-1));
                    } else {                                                                            //operands on either side
                        operatorList.add(this.codeList.get(i));
                        operandList.add(this.codeList.get(i+1));
                        if(i-1 != operandIndex)
                            operandList.add(this.codeList.get(i-1));
                        operandIndex = i+1;
                    }
                }
            }
        }
        N1 = operatorList.size();
        N2 = operandList.size();
        Set<String> uniqueOperator = new HashSet<>(operatorList);
        Set<String> uniqueOperand = new HashSet<>(operandList);
        nOne = uniqueOperator.size();
        nTwo = uniqueOperand.size();
    }*/

    //Another test, another main
    public static void main(String[] args)throws Exception{
        computeHalstead test = new computeHalstead();
        File testFile = new File("src/sample/wc.java");
        test.compute(testFile);
    }
}
