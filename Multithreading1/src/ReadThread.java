import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.nio.file.Files;
import java.util.*;

public class ReadThread implements Runnable {

    String path;
    String line;
    String[] valuesFile;
    String[] values;
    File file;

    public ReadThread(String name) {
        path = name;
    }

    @Override
    public void run() {

        try {
            // ������ �����
            BufferedReader bufferedReader = new BufferedReader(new FileReader(path));
            // ������ ������ ������
            line = bufferedReader.readLine();

            // ���������� ������ �� �����
            valuesFile = line.split(";");
            // �� ������� ����� �� ������� ������ ������ ������� ����
            for(String s : valuesFile) {
                file = new File("D:\\" + s + ".csv");
                file.createNewFile();
            }

            // ������ ��������� ������ �� �����
            while((line = bufferedReader.readLine()) != null) {

                values = line.split(";");

                // ������ � ����� (��� ��������)
                for(int i = 0; i < values.length; i++) {
                    FileWriter fileWriter = new FileWriter(new File("D:\\" + valuesFile[i] + ".csv"), true);
                    fileWriter.append(values[i]).append(";");
                    fileWriter.close();
                }

            }

            // ��������������� ������ ��� ���������� ��������
            for (String s : valuesFile) {
                BufferedReader fileReader = new BufferedReader(new FileReader("D:\\" + s + ".csv"));
                line = fileReader.readLine();
                String[] a = line.split(";");
                Set<String> temp = new LinkedHashSet<String>(Arrays.asList(a));
                String[] result = temp.toArray(new String[0]);
                fileReader.close();
                FileWriter fileWriter = new FileWriter(new File("D:\\" + s + ".csv"));
                fileWriter.flush();
                for (String f : result) {
                    fileWriter.append(f).append(";");
                }
                fileWriter.close();


            }

            bufferedReader.close();
        } catch(Exception e) {
            e.printStackTrace();
        }
    }
}
