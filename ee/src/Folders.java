import java.io.File;
import java.util.ArrayList;

public class Folders {
    private ArrayList<String> folder;
    private String path;

    public Folders(){
        folder = new ArrayList<>();
        path = "C:/Users/armag/IdeaProjects/Servlet/myFolders";
    }

    public void addFolders(){
        File fileFolder = new File(path);
        File[] listOfFiles = fileFolder.listFiles();
        for (int i = 0; i < listOfFiles.length; i++) {
            if (listOfFiles[i].isDirectory()) {
                folder.add(listOfFiles[i].getName());
            }
        }
    }

    public ArrayList<String> getFolder() {
        return folder;
    }

    public String getPath() {
        return path;
    }

    public ArrayList<String> findFile(String folderName){
        ArrayList<String>files = new ArrayList<>();
        String tmp_path = path + "/" + folderName;
        File fileFolder = new File(tmp_path);
        File[] listOfFiles = fileFolder.listFiles();
        for (int i = 0; i < listOfFiles.length; i++) {
            if (listOfFiles[i].isFile()) {
                files.add(listOfFiles[i].getName());
            }
        }
        return files;
    }
}
