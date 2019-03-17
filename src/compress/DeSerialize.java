package compress;

import java.io.File;
import java.io.FileReader;
import java.util.List;

import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;


public class DeSerialize {
    protected String archivesPath;
    protected String projectPath;

    public void DeSerialize(String archivesPath, String projectPath, String projectName) throws  Exception {
   // public void DeSerialize() throws  Exception {
        String from;
        String to;
        ArchiverController archiverController = new ArchiverController();
        this.projectPath = projectPath;
        this.archivesPath = archivesPath;

        FileReader reader = null;
        JSONObject jsb = null;
        try {
            reader = new FileReader(archivesPath+projectName+"\\package.io");
            JSONParser jsonParser = new JSONParser();
            jsb = (JSONObject) jsonParser.parse(reader);
        } catch (Exception e) {
            throw new Exception(e);
        } finally {
            if (reader != null)
                reader.close();
        }

        List<String> Folders = (List<String>) jsb.get("Folders");
        List<String> Files = (List<String>) jsb.get("Files");
        new File(projectPath+projectName).mkdirs();
        int i = 0, j = 0;
        for (String item : Folders) {
            if (i > 1) {
                new File(projectPath + projectName + "\\" + item.replace(projectName+"\\", "")).mkdirs();
            }
            i++;
        }
        for (String item : Files){
            from = archivesPath+projectName+"\\"+j+".io";
            to = projectPath+projectName+"\\"+item.replace(projectName+"\\", "");
            archiverController.ArchiverController(from, to, false);
            j++;
        }
    }
/*
    public void setProjectPath (String projectPath){
        this.projectPath = projectPath;
    }

    public void setArchivesPath(String archivesPath) {

    }

*/
}