package Model;

import java.io.*;

public class Model {
    private String text;

    public void loadFile(File file) {
        try {
            BufferedReader reader = new BufferedReader(new FileReader(file));
            StringBuilder content = new StringBuilder();
            String line;
            while ((line = reader.readLine()) != null) {
                content.append(line).append("\n");
            }
            reader.close();
            text = content.toString();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void saveFile(File file, String content) {
        try {
            BufferedWriter writer = new BufferedWriter(new FileWriter(file));
            writer.write(content);
            writer.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public String getText() {
        return text;
    }
}