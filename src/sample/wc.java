//Francisco Prado
package sample;
import java.io.*;



public class wc {
	private long ccount;
	private long wcount;
	private long lcount;

	public String filename;

	public boolean isSkipped() {
		return skipped;
	}

	private boolean skipped = false;
	

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

			while (getword(fr))
				;
			if (lcount == 0 && ccount != 0)
				lcount++;

			fr.close();


			} catch (Exception e) {
			System.out.println("Skipping " + string);
			skipped = true;
			}


	}
	//checks if current item is a valid character. If it is it increas wcount and goes on to count ccount
	private boolean getword(FileReader fr) throws IOException {
		// TODO Auto-generated method stub
		int c;

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

	//add it under here





}
