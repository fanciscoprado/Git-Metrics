package sample;

import java.io.*;

public class countSourceLines
{
    public int getCommentLines(File name) throws IOException
    {
        int sourceLines = getSourceLines(name);
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
        readf.close();
        return lines-sourceLines;
    }
    public int getSourceLines(File name) throws IOException
    {
        Reader readf = new FileReader(name);
        StreamTokenizer st = new StreamTokenizer(readf);
        st.slashSlashComments(true);
        st.slashStarComments(true);
        st.eolIsSignificant(true);
        int lines= 0;
        while(st.nextToken() != st.TT_EOF)
        {
            if(st.nextToken() == st.TT_EOL)
            {
                lines++;
            }
        }
        readf.close();
        return lines;
    }
}
