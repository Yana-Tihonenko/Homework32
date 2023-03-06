import javax.imageio.IIOException;
import java.io.*;
import java.util.HashMap;
import java.util.Map;

public class Homework32_Task1 {
    public static void main(String[] args) {
        //Напишите программу создания небольшого словаря сленговых программерских выражений,
        // чтобы она потом по запросу возвращала значения из этого словаря.
        //Формат входных данных
        //Файл dict.txt
        //В первой строке задано одно целое число n — количество слов в словаре.
        //В следующих n строках записаны слова и их определения, разделенные двоеточием и символом пробела.
        //Ввод с клавиатуры
        //В первой строке записано целое число m — количество поисковых слов, чье определение нужно вывести.
        //В следующих m строках записаны сами слова, по одному на строке.
        //Формат выходных данных
        //Для каждого слова, независимо от регистра символов, если оно присутствует в словаре,
        // необходимо вывести на экран его определение.
        //Если слова в словаре нет, программа должна вывести "Не найдено", без кавычек.

    }

    public static Map<String, String> createDictionaryDevelop(File inputFile) {
        Map<String, String> resultMap = new HashMap<>();
        try {
            BufferedReader br = new BufferedReader(new FileReader(inputFile));
            int n = Integer.parseInt(br.readLine());
            for (int i = 0; i < n; i++) {
                String line = br.readLine();
                int delimiter = line.indexOf(':');
                resultMap.put(line.substring(0, delimiter), line.substring(delimiter + 2));
            }
            br.close();
        } catch (NumberFormatException | FileNotFoundException | IndexOutOfBoundsException e) {
            System.err.println(e.getMessage());
            return resultMap;
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        return resultMap;
    }

}