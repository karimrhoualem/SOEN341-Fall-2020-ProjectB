package co.tdude.soen341.projectb.Reader;

import java.io.*;
import java.util.logging.Logger;

/**
 * Class Reader
 * @author David Molina (40111257)
 */
public class Reader implements IReader {
    private BufferedReader bfReader;

    @Override
    public char read() throws IOException {
        int nextChar = bfReader.read();
        return (nextChar == -1) ? '\0' : (char) nextChar;
    }

    /**
     * Constructor of Reader
     * @param asmFile: The assembly file to be read
     */
    public Reader(File asmFile) {
        try {
            this.bfReader = new BufferedReader(new FileReader(asmFile));
        } catch (FileNotFoundException e) {
            Logger.getLogger("").severe("File not found: " + asmFile.getAbsolutePath());
        }
    }

    /**
     * Close the reader
     * @throws IOException: In case an error occurs
     */
    public void closeReader () throws IOException {
        bfReader.close();
    }
}
