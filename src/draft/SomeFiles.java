package draft;

import java.io.File;
import java.util.List;

public class SomeFiles {


    public static void main(String[] args) {

        String path = "C:\\Program Files (x86)";
        searchFile(path);

    }


    public static void searchFile(String path){
        File file = new File(path);
        File[] files = file.listFiles();
        int count = 0;
//        List[] list = new List[]; // Дописать вывод списка файлов в файл.
        for (File somefile : files){
            count++;
            System.out.println(somefile.getName());
        }
        System.out.println(count);

    }
}
