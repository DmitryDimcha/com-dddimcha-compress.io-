package compress;

public class Main {

    public void Zip (String dir, String target, String projectName){
        //String dir = "D:\\test — копия\\";
        //String target = "D:\\tes2\\";
        //String projectName = "test";
        DirectoryRemaper directoryRemaper = new DirectoryRemaper();
        directoryRemaper.setArchiveLocation(target+projectName);
        directoryRemaper.setProjectsLocation(dir);
        directoryRemaper.setProjectName(projectName);
        directoryRemaper.ProjectDesctiptor(dir, target, projectName);
    }

    public void UnZip (String dir, String target, String projectName) throws Exception {
        DeSerialize deSerialize = new DeSerialize();
        //deSerialize.setArchivesPath("D:\\tes2\\");
        //deSerialize.setProjectPath("D:\\test");
        deSerialize.DeSerialize(target, dir, projectName);
    }
}
