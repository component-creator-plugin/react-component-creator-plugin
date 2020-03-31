package fabs.util;

import com.intellij.openapi.vfs.VirtualFile;

import java.io.*;
import java.util.Scanner;

public class FileUtils {

    /**
     * Get the file content
     *
     * @param fileName
     * @return
     */
    public String getContent(String fileName) throws FileNotFoundException {
        StringBuilder result = new StringBuilder("");
        ClassLoader classLoader = getClass().getClassLoader();
        InputStream resourceStream = classLoader.getResourceAsStream(fileName);
        InputStreamReader i = new FileReader(fileName);
        Scanner scanner = new Scanner(i);

        while (scanner.hasNextLine()) {
            String line = scanner.nextLine();
            result.append(line).append("\n");
        }

        scanner.close();
        return result.toString();
    }

    public void writeFile(String content, VirtualFile destinationFile) throws IOException {
        destinationFile.setBinaryContent(content.getBytes());
    }
}
