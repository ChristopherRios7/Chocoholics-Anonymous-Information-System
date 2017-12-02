/**
 * Created by christopherrios on 12/2/17.
 */

import java.io.*;

/**
 * Parent class for all Reports.
 */
public abstract class Report {
    public File file;

    //Get the line break symbol for the OS
    protected static final String newLine = System.lineSeparator();

    public abstract void generateReport() throws IOException;
}