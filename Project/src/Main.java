
import org.eclipse.egit.github.core.client.GitHubClient;
import org.eclipse.egit.github.core.service.GitHubService;
import org.eclipse.jgit.api.*;
import org.eclipse.jgit.api.errors.GitAPIException;
import org.eclipse.jgit.util.FileUtils;

import java.io.IOException;
import org.eclipse.egit.github.*;
import java.io.File;
import java.io.IOException;
import java.nio.file.*;
import java.nio.file.attribute.BasicFileAttributes;
import java.util.LinkedList;
import java.util.Scanner;


public class Main {

    public static void main(String[] args) throws GitAPIException, IOException {
        String name = "";
        Scanner scan = new Scanner(System.in);
        System.out.println("Enter temp folder naem");
        name = scan.next();
        System.out.println("enter repo url. Be sure url ends with .git");
        String url = scan.next();
        File folder = new File("temp/" + name);
        Git git = Git.cloneRepository()
                .setURI(url)
                .setDirectory(folder)
                .call();

        File[] listOfFiles = folder.listFiles();


        LinkedList<wc> list = new LinkedList<wc>();

        for (File file : listOfFiles) {
            String fname = file.getName();
            wc temp = new wc();
            temp.counter(fname, "temp/" + name);
            list.add(temp);


        }
        Print print = new Print();
        print.results(list);
        git.getRepository().close(); // Close all the things!
        git.close(); // Close all the things!

        removeall(folder);
    }



   private static void removeall(File folder){

        File[] listOfFiles = folder.listFiles();
        try {
            for (File temp : listOfFiles) {
                if (!temp.delete()) {
                    //System.out.println(temp.getName());
                    removeall(temp);
                }
                if (temp.delete()) {
                    System.out.println("deletet" + temp.getName());
                }

            }
        }catch (Exception e){
            System.out.println("could not delet");
            folder.setWritable(true);
            folder.delete();
        }
        folder.delete();

    }
}
