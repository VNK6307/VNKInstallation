import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) throws IOException {
        StringBuilder installationLog = new StringBuilder();

        List<String> gamesFolders = new ArrayList<>();
        gamesFolders.add("src");
        gamesFolders.add("res");
        gamesFolders.add("savegames");
        gamesFolders.add("temp");
        String gamesPath = "E:\\Java\\Netology\\Projects\\JavaCore\\1.3_Input-Output\\Games\\";
        for (String title : gamesFolders) {
            StringBuilder temp = createDir(title, gamesPath);
            installationLog.append(temp);
        }

        List<String> srcFolders = new ArrayList<>();
        srcFolders.add("main");
        srcFolders.add("test");
        String srcPath = "E:\\Java\\Netology\\Projects\\JavaCore\\1.3_Input-Output\\Games\\src\\";
        for (String title : srcFolders) {
            StringBuilder temp = createDir(title, srcPath);
            installationLog.append(temp);
        }

        List<String> resFolders = new ArrayList<>();
        resFolders.add("drawables");
        resFolders.add("vectors");
        resFolders.add("icons");
        String resPath = "E:\\Java\\Netology\\Projects\\JavaCore\\1.3_Input-Output\\Games\\res\\";
        for (String title : resFolders) {
            StringBuilder temp = createDir(title, resPath);
            installationLog.append(temp);
        }

        List<String> mainFiles = new ArrayList<>();
        mainFiles.add("Main.java");
        mainFiles.add("Utils.java");
        String mainPath = "E:\\Java\\Netology\\Projects\\JavaCore\\1.3_Input-Output\\Games\\src\\main";
        for (String title : mainFiles) {
            StringBuilder temp = createFile(title, mainPath);
            installationLog.append(temp);
        }

        List<String> tempFiles = new ArrayList<>();
        tempFiles.add("temp.txt");
        String tempPath = "E:\\Java\\Netology\\Projects\\JavaCore\\1.3_Input-Output\\Games\\temp";
        for (String title : tempFiles) {
            StringBuilder temp = createFile(title, tempPath);
            installationLog.append(temp);
        }

        String outPath = "E:\\Java\\Netology\\Projects\\JavaCore\\1.3_Input-Output\\Games\\temp\\temp.txt";
        writeLogs(installationLog, outPath);
    }// main

    public static StringBuilder createDir(String title, String path) {
        File dir = new File(path + title);
        if (dir.mkdir()) {
            System.out.println("Папка " + title + " успешно создана");
            return new StringBuilder("Папка " + title + " успешно создана\n");
        } else {
            System.out.println("Папка " + title + " не была создана");
            return new StringBuilder("Папка " + title + " не была создана\n");
        }
    }

    public static StringBuilder createFile(String title, String path) throws IOException {
        File file = new File(path, title);
        try {
            if (file.createNewFile()) {
                System.out.println("Файл " + title + " успешно создан");
                return new StringBuilder("Файл " + title + " успешно создан\n");
            } else {
                System.out.println("Файл " + title + " не был создан");
                return new StringBuilder("Файл " + title + " не был создан\n");
            }
        } catch (Exception exception) {
            System.out.println(exception.getMessage());
        }
        return null;
    }

    public static void writeLogs(StringBuilder logs, String file) {
        try (FileWriter writer = new FileWriter(file, false)) {
            writer.write(String.valueOf(logs));
            writer.flush();
            System.out.println("Информация о ходе установки записана в файл.");
        } catch (IOException e) {
            System.out.println(e.getMessage());
        }
    }
}// class