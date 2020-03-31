import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

@WebServlet(name = "DiscountServlet",urlPatterns = "/discount")
public class DiscountServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String product_description=request.getParameter("product");
        float price=Float.parseFloat(request.getParameter("price"));
        float discount=Float.parseFloat(request.getParameter("discount"));
        double discount_amount= (price * (discount/100));
        double discount_price=price-discount_amount;

        PrintWriter writer=response.getWriter();
        writer.println("<html>");
        writer.println("<h1>Product description: "+product_description+"</h1>");
        writer.println("<h1>price :"+price+"</h1>");
        writer.println("<h1>Discount Percent :"+discount+"</h1>");
        writer.println("<h1>Discount Amount :"+discount_amount+"</h1>");
        writer.println("<h1>Discount price :"+discount_price+"</h1>");
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }
}
