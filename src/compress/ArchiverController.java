package compress;

public class ArchiverController {
    protected String projectsLocation;
    protected String archiveLocation;

    //This metod is made for compress/decomress file by path
    public void ArchiverController (String projectsLocation, String  archiveLocation, boolean compress) {
        try {
            this.projectsLocation = projectsLocation;
            this.archiveLocation = archiveLocation;

            CompressController compressController = new CompressController();
            compressController.setPath(projectsLocation);
            compressController.setDestination( archiveLocation);
            if (compress) {
                compressController.Compress();
            } else {
                compressController.Decompress();
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }



    public void setProjectsLocation (String projectsLocation){
        this.projectsLocation = projectsLocation;
    }
    public void setArchiveLocation(String archiveLocation) {
        this.archiveLocation = archiveLocation;
    }

}
