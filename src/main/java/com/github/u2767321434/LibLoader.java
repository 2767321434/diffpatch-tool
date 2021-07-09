package com.github.u2767321434;

import org.apache.commons.io.FileUtils;

import java.io.File;
import java.io.FileInputStream;
import java.io.InputStream;
import java.net.URL;

public class LibLoader {
    public static void loadLib(String libName) {
        String resourcePath = "" + libName;
        String folderName = System.getProperty("java.io.tmpdir") +File.separator+ "lib"+File.separator;
        File folder = new File(folderName);
        folder.mkdirs();
        File libFile = new File(folder, libName);
        if (libFile.exists()) {
           libFile.delete();
        }
            try {
                InputStream resourceIn = LibLoader.class.getResourceAsStream(libName);
                FileUtils.copyInputStreamToFile(resourceIn,libFile);
                resourceIn.close();
                System.load(libFile.getAbsolutePath());
            } catch (Exception e) {
                e.printStackTrace();
                throw new RuntimeException("Failed to load required lib", e);
            }

    }
    
    public static String getPath(String fileName){
    	String filePath="/"+fileName;
    	  String folderName = System.getProperty("java.io.tmpdir") + File.separator+"lib"+ File.separator;
          File folder = new File(folderName);
          folder.mkdirs();
          File libFile = new File(folder, fileName);
          if (libFile.exists()) {
          		filePath=libFile.getAbsolutePath();
          	
          } else {
              try {
                  URL resource = LibLoader.class.getResource(fileName);
                  System.out.println(resource.getFile());
                  InputStream in = new FileInputStream(resource.getFile());
                  FileUtils.copyInputStreamToFile(in,libFile);
                  in.close();
                  filePath=libFile.getAbsolutePath();
              } catch (Exception e) {
                  e.printStackTrace();
                  throw new RuntimeException("Failed to load required lib", e);
              }
          }
          return filePath;
    }
    
 
    
}    
