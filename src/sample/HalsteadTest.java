package sample;
import java.io.IOException;
import java.io.*;
import java.io.StreamTokenizer;
public class HalsteadTest
{
    public static void main(String[] args)throws IOException
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

        /*so far splits everything into tokens based on whitespace*/
    }
}
