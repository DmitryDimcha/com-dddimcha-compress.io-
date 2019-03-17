package compress;

import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;

public class Serialize {
    protected String folders;
    protected String files;
    protected String projectName;
    protected String archiveLocation;

    public void Serialize () throws IOException {
        FileWriter fileWriter = new FileWriter(archiveLocation+projectName+"\\package.io");
        PrintWriter printWriter = new PrintWriter(fileWriter);
        printWriter.printf("{\"Project\": \"%s\", \"Folders\": %s,  \"Files\": %s}", projectName, folders, files);
        printWriter.close();
    }

    public void setArchiveLocation(String archiveLocation) {
        this.archiveLocation = archiveLocation;
    }

    public void setFiles(String files) {
        this.files = files;
    }

    public void setFolders(String folders) {
        this.folders = folders;
    }

    public void setProjectName(String projectName) {
        this.projectName = projectName;
    }
}
