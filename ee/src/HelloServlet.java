import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;


public class HelloServlet extends HttpServlet {
    private Folders folders;
    @Override
    public void init() throws ServletException {
        folders = new Folders();
        folders.addFolders();
        super.init();
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        resp.getWriter().write("Hello, world");
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String s = "<html>" +
                "<body>";
        PrintWriter pw = resp.getWriter();
        String folderName = (String) req.getParameter("folderName");
        if(folders.getFolder().contains(folderName)){
            ArrayList<String> files = folders.findFile(folderName);
            if(files.isEmpty()){
                s += "No files found in this folder." + "<br>";
            }
            else{
                s += "<h3>" + folderName + " : " + "</h3>";
                for(String str : files){
                    s += str + "<br>";
                }
            }
        }
        else {
            s += "No find folder with name - " + folderName + "<br>";
        }
        s += "<a href=" + "/" + ">Back</a>" +
                "</body>" +
                "</html>";
        pw.write(s);
    }
}


