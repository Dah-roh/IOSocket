package org.example.HTTPServerSun;

import com.sun.net.httpserver.HttpExchange;
import com.sun.net.httpserver.HttpHandler;

import java.io.IOException;
import java.io.OutputStream;

public class HomePage implements HttpHandler {
    @Override
    public void handle(HttpExchange exchange) throws IOException {
        //outputstream to write to our httpexchange message body
        OutputStream outputStream = exchange.getResponseBody();

        //our html response in string format
        StringBuilder response = new StringBuilder();
        response.append("<html>");
        response.append("<body>");
        response.append("<b>");
        response.append("<h1>");
        response.append("Welcome Home");
        response.append("</h1>");
        response.append("<a href = /aboutus>");
        response.append("<style>");
        response.append("body {");
        response.append("background-color: yellow;");
        response.append("}");
        response.append("h1 {");
        response.append("color: darkorange;");
        response.append("}");
        response.append("</style>");
        response.append("\r\n About Us");
        response.append("</a>");
        response.append("</b>");
        response.append("</body>");
        response.append("<html>");
        String stringMessage = response.toString();

        //response code and data length signified for header purposes
        exchange.sendResponseHeaders(200, stringMessage.length());

        //serving our html page via output stream
        outputStream.write(stringMessage.getBytes());

        //flushing data from stream
        outputStream.flush();

        //closing stream
        outputStream.close();

    }
}
