package bookexercise.tree.chapter04;

import java.nio.file.DirectoryStream;
import java.nio.file.FileSystems;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

public class EX4_10 {
  
  public static void main(String[] args) {
    listRootDirectories();
    
    listDirectory("E:\\");
  } // end main()
  
  public static void listDirectory(String p) {
    Path path = Paths.get(p);
    try (DirectoryStream<Path> stream = Files.newDirectoryStream(path)) {
      for (Path file: stream) {
        System.out.println(file.getFileName());
      } // end for
    } catch (Exception e) {
      e.printStackTrace();
    } // end catch
  } // end listDirectory()
  
  public static void listRootDirectories() {
    Iterable<Path> dirs  = FileSystems.getDefault().getRootDirectories();
    for (Path name: dirs) {
      System.out.println(name);
    } // end for
  } // end listRootDirectories()

}
