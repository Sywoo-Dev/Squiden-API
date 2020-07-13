package fr.sywoo.api.utils;

import java.io.*;
import java.nio.file.Files;
import java.nio.file.Path;

public class FileUtils {

    public void copyFolder(File source, File destination){
        try{
            if(source.isDirectory()){

                if(!destination.exists()){
                    destination.mkdir();
                }

                String[] childrens = source.list();
                for(int i = 0; i < childrens.length; i++){
                    copyFolder(new File(source, childrens[i]), new File(destination, childrens[i]));
                }

            } else {
                InputStream in = new FileInputStream(source);
                OutputStream out = new FileOutputStream(destination);

                byte[] buf = new byte[1024];
                int len;
                while((len = in.read(buf)) > 0){
                    out.write(buf, 0, len);
                }
                in.close();
                out.close();
            }
        } catch (IOException e){
            e.printStackTrace();
        }
    }

    public void deleteFolder(File source){
        try {
            Files.walk(source.toPath()).filter(Files::isRegularFile).map(Path::toFile).forEach(File::delete);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

}
