package org.example.HTTPServerSun;

import com.sun.net.httpserver.HttpExchange;
import com.sun.net.httpserver.HttpHandler;

import java.io.IOException;
import java.io.OutputStream;

public class AboutUs implements HttpHandler {
    @Override
    public void handle(HttpExchange exchange) throws IOException {
        OutputStream outputStream = exchange.getResponseBody();
        StringBuilder response = new StringBuilder();
        response.append("<html>");
        response.append("<body style = \"background-color: yellow;\">");
        response.append("<b>");
        response.append("About our voluminous art gallery");
        response.append("<a href = />");
        response.append("\r\n HomePage");
        response.append("</a>");
        response.append("</b>");
        response.append("<img src="+ "https://i.pinimg.com/originals/df/e8/a0/dfe8a0663289449e6c127e92ac40da53.jpg " +" />");
        response.append("</body>");
        response.append("<html>");
        String stringMessage = response.toString();
        exchange.sendResponseHeaders(200, stringMessage.length());
        outputStream.write(stringMessage.getBytes());
        outputStream.flush();
        outputStream.close();

    }
}
