import java.io.File;
import java.io.IOException;
import java.net.Socket;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardCopyOption;

import static java.nio.file.Files.*;

public class Main {

    static File dirFrom = new File("/Users/nasenka/Downloads/Cat");
    static File dirTo = new File("/Users/nasenka/Desktop/");

    public static void main(String[] args) throws InterruptedException, IOException {


        if (!dirFrom.exists()) {
            System.out.println("Путь не существует, папка, которую нужно скопировать не существует");
        }
        else {
            copyDir(dirFrom, dirTo);
        }
    }


    private static void copyDir(File sourcePath, File targetPath) throws IOException {
        targetPath = new File(targetPath.getAbsoluteFile() + "/" + sourcePath.getName());
        targetPath.mkdir();
        File[] sourceFiles = sourcePath.listFiles();
        if (sourceFiles != null)
            for (File sourceFile : sourceFiles) {
                if (sourceFile.isFile()) {
                    Files.copy(sourceFile.toPath(), targetPath.toPath().resolve(sourceFile.getName()), StandardCopyOption.REPLACE_EXISTING);
                }
                else {
                    copyDir(sourceFile,targetPath);
                }

            }


    }
}
