import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
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

    }

    public static HashMap<String, ArrayList<String>> createPermissionFromFile(File inputFile) {
        HashMap<String, ArrayList<String>> result = new HashMap<>();
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

        return result;
    }

}
