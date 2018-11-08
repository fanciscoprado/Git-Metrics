//Francisco Prado
package sample;
import java.io.*;



public class wc {
	public long ccount;
	public long wcount;
	public long lcount;
	static public long total_ccount = 0;
	static public long total_wcount = 0;
	static public long total_lcount = 0;
	public String filename;
	public boolean skipped = false;

	public long getCcount() {
		return ccount;
	}

	public void setCcount(long ccount) {
		this.ccount = ccount;
	}

	public long getWcount() {
		return wcount;
	}

	public void setWcount(long wcount) {
		this.wcount = wcount;
	}

	public long getLcount() {
		return lcount;
	}

	public void setLcount(long lcount) {
		this.lcount = lcount;
	}

	public String getFilename() {
		return filename;
	}

	public void setFilename(String filename) {
		this.filename = filename;
	}

	public void counter(String string, File file) throws IOException {
		filename = string;

		try {
		FileReader fr = new FileReader(file);
		ccount=wcount=lcount=0;
		while (getword (fr))
			;
		if(lcount == 0 && ccount != 0)
			lcount ++;
		//report(ccount, wcount, lcount, string, " ");
		total_ccount += ccount;
		total_lcount += lcount;
		total_wcount += wcount;
		fr.close();
		}
		catch(Exception e){
			System.out.println("Skipping "+string);
			skipped = true;


		}
	}
	//checks if current item is a valid character. If it is it increas wcount and goes on to count ccount
	private boolean getword(FileReader fr) throws IOException {
		// TODO Auto-generated method stub
		int c;
		int word = 0;


		while ((c = fr.read()) != -1) {
			if (isword (c)) {
				wcount ++;
				break;
			}
			COUNT (c);
			}

		for (; c != -1; c = fr.read()) {
			COUNT (c);
			if (!isword (c))
				break;
		}
		return c != -1;
	}

	private void COUNT(int c) {
		// TODO Auto-generated method stub
			ccount ++;
		if ((c) == 10)
			lcount++;

	}
	//checks if current item is a balnk space
	@SuppressWarnings("deprecation")
	private static boolean isword(int c) {
		// TODO Auto-generated method stub
		return !Character.isSpace((char) c);
	}
	//Prints out word, line, character count
	private static void report(long c, long w, long l, String s, String arg) {
		System.out.print(" ");
		if(arg.equals("-l")){
			System.out.println(l + " " + s);
		}
		else if(arg.equals("-w")) {
			System.out.println(w + " " + s);
		}
		else if (arg.equals("-c")) {
			System.out.println(c + " " + s);
		}
		else
			System.out.println(l + " " + w +" "+ c + " " + s);
	}
	//Report Usage
	private static void reportUsage() {
		System.out.println("Usage:");
		System.out.println(" wc -l <filename> will print the line count of a file");
		System.out.println(" wc -c <filename> will print the character count");
		System.out.println(" wc -w <filename> will print the word count");
		System.out.println(" wc <filename> will print all of the above");
	}




}
