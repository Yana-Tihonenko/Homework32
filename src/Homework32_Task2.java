import javax.imageio.IIOException;
import java.io.*;
import java.util.ArrayList;
import java.util.HashMap;

public class Homework32_Task2 {
    //В файловую систему одного суперкомпьютера проник вирус,
    // который сломал контроль за правами доступа к файлам. Для каждого файла известно,
    // с какими действиями можно к нему обращаться:
    //запись W,
    //чтение R,
    //запуск X.
    //Файл files.txt
    //В первой строке содержится число N — количество файлов, содержащихся в данной файловой системе.
    //В следующих N строчках содержатся имена файлов и допустимых с ними операций, разделенные пробелами.
    //Файл operations.txt
    //Далее указано чиcло M — количество запросов к файлам.
    //В последних M строках указан запрос вида Операция Файл.
    //К одному и тому же файлу может быть применено любое колличество запросов.
    //Вам требуется восстановить контроль над правами доступа к файлам.
    //Файл results.txt
    //Ваша программа для каждого запроса должна будет выводить
    // Файл: Операция: OK, если над файлом выполняется допустимая операция,
    // или же Файл: Операция: Access denied, если операция недопустима.
    public static void main(String[] args) {

        File files = new File("resourse/file.txt");
        File operations = new File("resourse/operations.txt");
        String resultLine;
        try {
            FileWriter resultFile = new FileWriter("resourse/result.txt");
            BufferedReader brOperationFile = new BufferedReader(new FileReader(operations));
            HashMap<String, ArrayList<String>> permissionFromFile = createPermissionFromFile(files);
            HashMap<String, String> mapingPermission = mapingPermission();
            int n = Integer.parseInt(brOperationFile.readLine());
            for (int i = 0; i < n; i++) {
                HashMap <String,String> parsingLineFromOperationFile = parsingLine(brOperationFile.readLine());
                String operationFromOperationFile = mapingPermission.get(parsingLineFromOperationFile.keySet());
                ArrayList<String> operationFromPermissionFile = permissionFromFile.get(parsingLineFromOperationFile.values());
                if (operationFromPermissionFile.contains(operationFromOperationFile)) {
                     resultLine = parsingLineFromOperationFile.keySet() + ": " + parsingLineFromOperationFile.values() + ": OK";
                } else {
                     resultLine = parsingLineFromOperationFile.keySet() + ": " + parsingLineFromOperationFile.values() + ":  Access denied";
                }
                resultFile.write(resultLine + "\n");
            }
            resultFile.close();
        } catch (IIOException e) {
            System.err.println(e.getMessage());
        } catch (IOException e) {
            throw new RuntimeException(e);
        }


    }

    public static HashMap<String, ArrayList<String>> createPermissionFromFile(File inputFile) {
        HashMap<String, ArrayList<String>> result = new HashMap<>();
        try {
            BufferedReader br = new BufferedReader(new FileReader(inputFile));
            int n = Integer.parseInt(br.readLine());
            for (int i = 0; i < n; i++) {
                ArrayList<String> permission = new ArrayList<>();
                String nameFile;
                String line = br.readLine().trim();
                int delimiter = line.indexOf(' ');
                if (delimiter == -1) {
                    nameFile = line;
                } else {
                    nameFile = line.substring(0, delimiter);
                }
                int delimiterNext = delimiter;
                while (delimiterNext > 0) {
                    delimiterNext = line.indexOf(' ', delimiter + 1);
                    if (delimiterNext == -1) {
                        permission.add(line.substring(delimiter));
                    } else {
                        permission.add(line.substring(delimiter, delimiterNext));
                    }
                    delimiter = delimiterNext;
                }
                result.put(nameFile, permission);
            }
        } catch (IOException e) {
            System.err.println(e.getMessage());
        }
        return result;
    }

    public static HashMap<String, String> mapingPermission() {
        HashMap<String, String> result = new HashMap<>();
        result.put("read", "r");
        result.put("write", "w");
        result.put("execute", "x");
        return result;
    }

    public static HashMap<String, String> parsingLine(String line) {
        HashMap<String, String> result = new HashMap<>();
        int delimiter = line.indexOf(' ');
        String operation = line.substring(0, delimiter);
        String nameFile = line.substring(delimiter + 1);
        result.put(operation, nameFile);
        return result;
    }


}
