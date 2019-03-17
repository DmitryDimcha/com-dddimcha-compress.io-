package compress;

import com.google.gson.Gson;
import org.apache.commons.io.FileUtils;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.nio.file.*;
import java.nio.file.attribute.BasicFileAttributes;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Enumeration;

public class DirectoryRemaper {

//TODO: Serialize project information to JSON file, pack and unpack project
    ArrayList<String> projectFiles = new ArrayList<>();
    ArrayList<String> archiveDirectory = new ArrayList<>();
    protected String projectsLocation;
    protected String archiveLocation;
    protected String projectName;

    //List all elements by step
    public void DisctribeAndArchive (ArrayList<String> projectFiles) throws IOException {
        ArchiverController archiverController = new ArchiverController();
        // Get the Enumeration object
        Enumeration<String> e = Collections.enumeration(projectFiles);
        // Enumerate through the ArrayList elements
        int i = 0;
        while(e.hasMoreElements()) {
            //Compress all file in directory and relocate to new path
            //@Refacroting
            archiverController.setArchiveLocation(archiveLocation);
            archiverController.setProjectsLocation(projectsLocation);
            archiverController.ArchiverController(projectsLocation + e.nextElement(), archiveLocation +projectName+"\\"+ i+".io", true);
            //Controller(projectsLocation + e.nextElement(), archiveLocation + i+".io", true);
            i++;
        }

    }


    //Collect all files and dirs from project compress it and move to zip place
    public void ProjectDesctiptor(String projectsLocation, String archiveLocation, final String projectName )  {
            try {
                Serialize serialize = new Serialize();
                this.projectsLocation = projectsLocation;
                this.archiveLocation = archiveLocation;
                this.projectName = projectName;
            Path startPath = Paths.get(projectsLocation);
            final String path = projectsLocation;
            final ArrayList<String> projectFiles = new ArrayList<>();
            final ArrayList<String> archiveDirectory = new ArrayList<>();

            Files.walkFileTree(startPath, new SimpleFileVisitor<Path>() {
                @Override
                public FileVisitResult preVisitDirectory(Path dir, BasicFileAttributes attrs) {
                    archiveDirectory.add(dir.toString().replace(path, ""));
                    return FileVisitResult.CONTINUE;
                }

                @Override
                public FileVisitResult visitFile(Path file, BasicFileAttributes attrs) {
                    projectFiles.add(file.toString().replace(path, ""));
                    return FileVisitResult.CONTINUE;
                }

                @Override
                public FileVisitResult visitFileFailed(Path file, IOException e) {
                    return FileVisitResult.CONTINUE;
                }
            });
                String files = new Gson().toJson(projectFiles);
                String directory = new Gson().toJson(archiveDirectory);
                (new File(archiveLocation+projectName)).mkdirs();
               // JSONCreator(directory, files);

                //@REFACTORED: Devidet class for many
                serialize.setArchiveLocation(archiveLocation);
                serialize.setProjectName(projectName);
                serialize.setFiles(files);
                serialize.setFolders(directory);
                serialize.Serialize();

                DisctribeAndArchive(projectFiles);
                File file = new File(projectsLocation);
               // FileUtils.deleteDirectory(file);

        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void setProjectsLocation (String projectsLocation){
        this.projectsLocation = projectsLocation;
    }
    public void setArchiveLocation(String archiveLocation) {
        this.archiveLocation = archiveLocation;
    }
    public void setProjectName (String projectName){
        this.projectName= projectName;
    }
}

