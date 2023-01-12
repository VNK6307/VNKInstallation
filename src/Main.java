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
        installationLog.append(createDir(gamesFolders, gamesPath));

        List<String> srcFolders = new ArrayList<>();
        srcFolders.add("main");
        srcFolders.add("test");
        String srcPath = "E:\\Java\\Netology\\Projects\\JavaCore\\1.3_Input-Output\\Games\\src\\";
        installationLog.append(createDir(srcFolders, srcPath));

        List<String> resFolders = new ArrayList<>();
        resFolders.add("drawables");
        resFolders.add("vectors");
        resFolders.add("icons");
        String resPath = "E:\\Java\\Netology\\Projects\\JavaCore\\1.3_Input-Output\\Games\\res\\";
        installationLog.append(createDir(resFolders, resPath));

        List<String> mainFiles = new ArrayList<>();
        mainFiles.add("Main.java");
        mainFiles.add("Utils.java");
        String mainPath = "E:\\Java\\Netology\\Projects\\JavaCore\\1.3_Input-Output\\Games\\src\\main";
        installationLog.append(createFile(mainFiles, mainPath));

        List<String> tempFiles = new ArrayList<>();
        tempFiles.add("temp.txt");
        String tempPath = "E:\\Java\\Netology\\Projects\\JavaCore\\1.3_Input-Output\\Games\\temp";
        installationLog.append(createFile(tempFiles, tempPath));

        String outPath = "E:\\Java\\Netology\\Projects\\JavaCore\\1.3_Input-Output\\Games\\temp\\temp.txt";
        writeLogs(installationLog, outPath);
    }// main

    public static StringBuilder createDir(List<String> titles, String path) {
        StringBuilder sb = new StringBuilder();
        for (String title : titles) {
            File dir = new File(path + title);
            if (dir.mkdir()) {
                System.out.println("Папка " + title + " успешно создана.");
                sb.append("Папка ").append(title).append(" успешно создана.\n");
            } else {
                System.out.println("Папка " + title + " не была создана.");
                sb.append("Папка ").append(title).append(" не была создана.\n");
            }
        }
        return sb;
    }// createDir

    public static StringBuilder createFile(List<String> titles, String path) throws IOException {
        StringBuilder sb = new StringBuilder();
        for (String title : titles) {
            File file = new File(path, title);
            try {
                if (file.createNewFile()) {
                    System.out.println("Файл " + title + " успешно создан.");
                    sb.append("Файл ").append(title).append(" успешно создан.\n");
                } else {
                    System.out.println("Файл " + title + " не был создан.");
                    sb.append("Файл ").append(title).append(" не был создан.\n");
                }
            } catch (Exception exception) {
                System.out.println(exception.getMessage());
            }
        }
        return sb;
    }// createFile

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