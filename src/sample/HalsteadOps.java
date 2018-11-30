package sample;

import java.io.FileReader;
import java.io.IOException;
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
    char[] javasplit= {'~','!','#','%','^','&','*','(',')','-','+','=','{','}','[',']',':',';','\"','\'','?','|'};
    public int getDistinctOperator() throws IOException {
        Reader readf = new FileReader("src/sample/Halstead.java");
        StreamTokenizer st = new StreamTokenizer(readf);
        st.wordChars('a','z');
        st.wordChars('!','}');
        st.wordChars(47,57);
        st.wordChars(0,1);
        st.slashSlashComments(true);
        st.slashStarComments(true);
        st.commentChar('/');


        while(st.nextToken() != st.TT_EOF)
        {
            boolean contain = false;
            String temp = st.sval;
            if(!(temp == null))
            {
                contain =  containsAny(temp, javasplit);
            }
            if(contain)
            {
                System.out.println(temp);
            }
            else
            {
                System.out.println(temp);
            }


        }
        return 0;
    }
    public int getTotalOperator()
    {
        return 0;
    }
    public static boolean containsAny(String str, char[] searchChars)
    {
        if (str == null || str.length() == 0 || searchChars == null || searchChars.length == 0)
        {
            return false;
        }
        for(int i = 0; i < str.length(); i++)
        {
            char ch = str.charAt(i);
            for(int j = 0; j < searchChars.length; j++)
            {
                if (searchChars[j] == ch)
                {
                    return true;
                }
            }
        }
        return false;
    }
}
