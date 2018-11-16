package sample;

import java.io.*;

public class countSourceLines
{
    int getSourceLines(File name) throws IOException
    {
        Reader readf = new FileReader(name);
        StreamTokenizer st = new StreamTokenizer(readf);
        st.slashSlashComments(false);
        st.slashStarComments(false);
        st.commentChar('/');
        st.eolIsSignificant(true);
        int lines = 0;
        while(st.nextToken() != st.TT_EOF)
        {
            if(st.nextToken() == st.TT_EOL)
            {
                lines++;
            }
        }
        return lines;
    }
}
