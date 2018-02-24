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

        String tekst=request.getParameter("tekst");
        String[] tab = tekst.split("\\s");
        int ileSlow=Arrays.toString(tab).length();

        String tekstBezSpacji = tekst.replaceAll("\\s", "");
        int bezSpacji=tekstBezSpacji.length();

        int ileWszystkich=tekst.length();

        boolean palindrom=czyPalindrom(tab) ;
        PrintWriter writer = response.getWriter();
        writer.println(tekst);

        writer.println("Ilość słów:"+ileSlow );
        writer.println("Ilość znaków:"+bezSpacji );
        writer.println("Ilość znaków bez spacji:"+ileWszystkich );
        writer.println("Palindrom:"+palindrom );
    }



    boolean czyPalindrom(String tab[])
    {
    int j=tab.length;
        for(int i=0; i<=j/2; i++)
            if(tab[i].equals(tab[j-i]))
                return false;

        return true;
    }

}
