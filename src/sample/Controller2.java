package sample;

import java.io.IOException;

public class Controller2 extends Controller {
    @Override
    public void onClick() throws IOException {
        MultiGitRepo multiGitRepo = new MultiGitRepo();
        multiGitRepo.start(dataToCollect,getURL());
        ResultBox box = new ResultBox();
        System.out.println("This is scene 2");
        box.display(multiGitRepo.getDataColectedList(),multiGitRepo.getCommiterList());
    }
}
