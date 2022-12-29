package uc2fileoperation;

import java.io.File;

public class FileOperation {

    public static boolean deletFile(File contentToDelete) {
        File[] content  = contentToDelete.listFiles();


        if(content != null) {
            for(File file : content) {
                deletFile(file);
            }
        }
        return contentToDelete.delete();
    }
}
