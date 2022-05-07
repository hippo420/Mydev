import java.io.IOException;
import java.nio.file.*;
import java.util.ArrayList;
import java.util.List;

public class extractFilePath {

    public static List<String> freader() throws IOException
    {
        List<String> files = new ArrayList<String>();
        try(DirectoryStream<Path> stream =Files.newDirectoryStream(Paths.get(Constants.PATH)))
        {
            for(Path file : stream){
                files.add(Constants.PATH+file.getFileName());
            }
        }catch (IOException | DirectoryIteratorException ex)
        {
            System.out.println("오류..."+ex);
        }

        return files;
    }
}
