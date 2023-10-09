package draft;

import java.io.File;

public class DeleteFolderExample {
    public static void main(String[] args) {
        String folderPath = "C:\\Users\\Galfest\\Desktop\\Acer";

        deleteFolder(folderPath);
    }

    public static void deleteFolder(String path) {
        File folder = new File(path);

        if (folder.exists()) {
            // Проверяем, является ли файл или папка
            if (folder.isFile()) {
                folder.delete();
                System.out.println("Файл успешно удален.");
            } else {
                // Получаем список всех файлов и папок в папке
                File[] files = folder.listFiles();

                if (files != null) {
                    for (File file : files) {
                        // Рекурсивно удаляем все файлы и подпапки
                        deleteFolder(file.getAbsolutePath());
                    }
                }

                // Удаляем пустую папку
                folder.delete();
                System.out.println("Папка успешно удалена.");
            }
        } else {
            System.out.println("Файл или папка не существует.");
        }
    }
}
