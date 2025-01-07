// createDir 这个方法不知道该放哪里？这个方法是多余的吧？
// 什么时候使用final？

import java.util.ArrayList;
import java.util.List;

public class FileSystem3338 {
    public static void main(String[] args) {
        Directory dir1 = new Directory("d1");
        Directory dir2 = new Directory("d2");

        File file1 = new File("f1");

        dir1.checkEmpty(); // true
        dir1.addFile(file1);
        dir1.checkEmpty(); // false
        dir1.addDirectory(dir2);
        dir1.checkEmpty(); // false

    }
    
}

class Directory {
    private String name;
    private List<File> files;
    private List<Directory> directories;

    public Directory(String name){
        this.name = name;
        this.files = new ArrayList<>();
        this.directories = new ArrayList<>();
    }

    public String getName(){
        return name;
    }

    public List<File> getFiles(){
        return files;
        // return new ArrayList<>(files);  // 返回副本以保护封装
    }

    public List<Directory> getDirectories(){
        return directories;
        // return new ArrayList<>(directories);  // 返回副本以保护封装
    }

    
    public void createDir(String dirname){
        Directory dir = new Directory(dirname);
        // directories.add(dir);
    }

    public void addDirectory(Directory dir){
        directories.add(dir);
        System.out.println("Adding directory " + dir.getName() + " to " + name);
    }

    public void addFile(File file){
        files.add(file);
        System.out.println("Adding file " + file.getName() + " to " + name);
    }

    public void checkEmpty(){
        if(files.isEmpty() && directories.isEmpty()){
            System.out.println("true, Directory is empty");
        } else {
            System.out.println("false, Directory is not empty");
        }
    }

}

class File {
    private String name;

    public File(String name){
        this.name = name;
    }

    public String getName(){
        return name;
    }
}

