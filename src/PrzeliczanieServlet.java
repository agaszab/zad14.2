import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PipedWriter;
import java.io.PrintWriter;
import java.io.Writer;
import java.util.Arrays;

@WebServlet("/PrzeliczanieServlet")
public class PrzeliczanieServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setCharacterEncoding("UTF-8");
        request.setCharacterEncoding("UTF-8");
        response.setContentType("text/html");
        String tekst=request.getParameter("tekst");
        String[] tab = tekst.split(" ");
        String wyrazy= Arrays.toString(tab);
        int ileSlow=tab.length;

        String tekstBezSpacji = tekst.replaceAll("\\s", "");
        int bezSpacji=tekstBezSpacji.length();

        int ileWszystkich=tekst.length();
        PrintWriter writer = response.getWriter();
        boolean palindrom=czyPalindrom(tekstBezSpacji);


        request.setCharacterEncoding("UTF-8");
        response.setCharacterEncoding("UTF-8");

        writer.println(tekst);

        writer.println("Ilość słów:"+ileSlow );
        writer.println("Ilość znaków:"+ileWszystkich );
        writer.println("Ilość znaków bez spacji:"+bezSpacji );
        writer.println("Palindrom:"+palindrom );

    }



    boolean czyPalindrom(String tekstBezSpacji)
    {
        StringBuffer sb=new StringBuffer(tekstBezSpacji);
        sb.reverse();
        String revers=sb.toString();
        if(revers.equals(tekstBezSpacji)) return true;
        else
            return false;
    }
}
