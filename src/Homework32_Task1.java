import java.io.*;
import java.util.ArrayList;
import java.util.HashMap;


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
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        File inputFile = new File("resourse/dict.txt");
        HashMap<String, String> dictionaryDevelop = createDictionaryDevelop(inputFile);
        int countWordFormClient = 0;
        try {
            countWordFormClient = Integer.parseInt(br.readLine());
        } catch (IOException e) {
            System.err.println(e.getMessage());
        }
        ArrayList<String> dataFromClients = processingDataFromClients(br, countWordFormClient);
        ArrayList<String> resultSearch = searchByDefinition(dataFromClients, dictionaryDevelop);
        printArraylist(resultSearch);
    }

    public static HashMap<String, String> createDictionaryDevelop(File inputFile) {
        HashMap<String, String> resultMap = new HashMap<>();
        try {
            BufferedReader br = new BufferedReader(new FileReader(inputFile));
            int n = Integer.parseInt(br.readLine());
            for (int i = 0; i < n; i++) {
                String line = br.readLine().toLowerCase();
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

    public static ArrayList<String> searchByDefinition(ArrayList<String> keyWords, HashMap<String, String> dictionaryDevelop) {
        ArrayList<String> result = new ArrayList<>();
        if (keyWords.isEmpty()) {
            return result;
        }
        if (dictionaryDevelop.isEmpty()) {
            result.add("Not found");
            return result;
        }
        for (String elementArray : keyWords) {
            result.add(dictionaryDevelop.getOrDefault(elementArray, "Not found"));
        }
        return result;
    }

    public static void printArraylist(ArrayList<String> arrayList) {
        for (String print : arrayList) {
            System.out.println(print);
        }
    }

    public static ArrayList<String> processingDataFromClients(BufferedReader br, int n) {
        ArrayList<String> result = new ArrayList<>();
        try {
            for (int i = 0; i < n; i++) {
                String inputWord = br.readLine().toLowerCase();
                result.add(inputWord);
            }
        } catch (IOException e) {
            System.err.println(e.getMessage());
        }
        return result;
    }

}