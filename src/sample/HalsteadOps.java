package sample;

import java.io.FileReader;
import java.io.Reader;
import java.io.StreamTokenizer;

public class HalsteadOps
{
    /*special case words for java operators*/
    String[] javaOperators= {"!","!=","%","%=","&","&&","||","&=","(",")","{","}","[","]","*","*=","+","++","+=",",",
            "-","--","-=->",".","...","/","/=",":","::","<","<<","<<=","<=","=","==",">",">=",">>",">>>",">>=>>>=","?",
            "^","^=","|","|=","~",";","=&","\"","\'","#","##","~","break","case",
            "continue","default","do","if","else","enum","for","goto","if","new", "return","asm","operator","private",
            "protected","public","sizeof","struct","switch","union","while", "this","namespace","using","try","catch",
            "throw","throws","finally","strictfp","instanceof","interface", "extends","implements","abstract","concrete",
            "const_cast","static_cast","dynamic_cast","reinterpret_cast", "typeid","template","explicit","true","false",
            "typename","const","friend","volatile","transient","final", "auto","extern","register","static","typedef",
            "virtual,", "mutable","inline","add","remove"};
    String[] CPlusOperators = {"!","!=","%","%=","&","&&","||","&=","(",")","{","}","[","]","*","*=","+","++","+=",",",
            "-","--","-=","->",".","...","/","/=",":","::","<","<<","<<=","<=","=","==",">",">=",">>",">>=","?","^","^=",
            "|","|=","~",";","=&","\"","\'","#","##","~","break","case","continue","default","do","if","else","enum",
            "for","goto","if","new","return","asm","operator","private","protected","public","sizeof","struct","switch",
            "union","while","this","namespace","using,","try","catch","throw","abstract","concrete","const_cast","static_cast",
            "dynamic_cast","reinterpret_cast","typeid","template","explicit","true","false","typename","const","friend","volatile",
            "final","auto","extern","register","static","typedef","virtual","mutable","inline"};
    public int getDistinctOperator()
    {
        Reader readf = new FileReader("src/sample/Halstead.java");
        StreamTokenizer st = new StreamTokenizer(readf);
        st.wordChars('a','z');
        st.wordChars('!','}');
        st.slashSlashComments(true);
        st.slashStarComments(true);
        st.commentChar('/');


        while(st.nextToken() != st.TT_EOF)
        {
            String temp = st.sval;
            System.out.println(temp);


        }
        return 0;
    }
    public int getTotalOperator()
    {
        return 0;
    }
}
