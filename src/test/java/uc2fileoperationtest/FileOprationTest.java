package uc2fileoperationtest;

import static junit.framework.Assert.assertTrue;


import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.stream.IntStream;

import org.testng.annotations.Test;
import uc2fileoperation.FileOperation;

public class FileOprationTest {

    private static String HOME = "C:\\Users\\wasee\\IdeaProjects\\untitled1";
    private static String PLAY_WITH_IO = "TempPlayGround";

    @Test
    public void givenPathWhenCheckedFileThenConfirm() throws IOException {

        Path filePath = Paths.get(HOME);
        assertTrue(Files.exists(filePath));
        System.out.println(filePath);

        Path opratePath = Paths.get(HOME + "/" + PLAY_WITH_IO);
        if (Files.exists(opratePath))
            FileOperation.deletFile(opratePath.toFile());
        assertTrue(Files.notExists(opratePath));

        // Create a directory
        Files.createDirectory(opratePath);
        assertTrue(Files.exists(opratePath));

        // Create Empty File
        IntStream.range(1, 10).forEach(cntr -> {
            Path tempFile = Paths.get(opratePath + "/temp" + cntr);
            assertTrue(Files.notExists(tempFile));
            try {
                Files.createFile(tempFile);
            } catch (IOException e) {
            }
            assertTrue(Files.exists(tempFile));
        });


        System.out.println("Files.list");
        Files.list(opratePath).filter(Files::isRegularFile).forEach(System.out::println);
        System.out.println("Files.newDirectory");
        Files.newDirectoryStream(opratePath).forEach(System.out::println);
        System.out.println("Files.newDirectory with temp");
        Files.newDirectoryStream(opratePath, path -> path.toFile().isFile() && path.toString().contains("temp"))
                .forEach(System.out::println);
    }

}
