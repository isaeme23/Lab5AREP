package com.arep;

import java.io.IOException;

import static spark.Spark.*;

public class SparkWebServer {
    public static void main(String... args) throws IOException {
        port(getPort());
        get("hello", (req,res) -> "Hello Docker!");
        get("sin", (req,res) -> getSin(Double.parseDouble(req.queryParams("num"))));
        get("cos", (req,res) -> getCos(Double.parseDouble(req.queryParams("num"))));
        get("palindromo", (req,res) -> getPali(req.queryParams("word")));
        get("vector", (req, res) -> getMagnitude(Double.parseDouble(req.queryParams("a")), Double.parseDouble(req.queryParams("b"))));
        get("index", (req, res) -> getHtml());
    }

    private static int getPort() {
        if (System.getenv("PORT") != null) {
            return Integer.parseInt(System.getenv("PORT"));
        }
        return 4567;
    }

    private static double getSin(double num){
        return Math.sin(num);
    }

    private static double getCos(double num){
        return Math.cos(num);
    }

    private static String getPali(String pali){
        String ilap = new StringBuilder(pali).reverse().toString();
        if (pali.equals(ilap)){
            return "Es Palindromo";
        } else {
            return "No es palindromo";
        }
    }

    private static String getMagnitude(double a, double b) {
        return "Magnitud: "+(Double) Math.sqrt(Math.pow(a, 2)+Math.pow(b, 2));
    }

    private static String getHtml(){
        String response = "\r\n <!DOCTYPE html>\n" +
                "<html>\n" +
                "    <head>\n" +
                "        <title>LabAREP</title>\n" +
                "        <meta charset=\"UTF-8\">\n" +
                "        <meta name=\"viewport\" content=\"width=device-width, initial-scale=1.0\">\n" +
                "    </head>\n" +
                "    <body>\n" +
                "        <h1>Form Sin</h1>\n" +
                "        <h2>Hi, put the number</h2>\n" +
                "        <form action=\"/movie\">\n" +
                "            <label for=\"name\">Name:</label><br>\n" +
                "            <input type=\"text\" id=\"name\" name=\"name\" value=\"0.98\"><br><br>\n" +
                "            <input type=\"button\" value=\"Search\" onclick=\"loadGetSin()\">\n" +
                "        </form> \n" +
                "        <div id=\"sinrespmsg\"></div>\n" +
                "\n" +
                "        <script>\n" +
                "            function loadGetSin() {\n" +
                "                let nameVar = document.getElementById(\"name\").value;\n" +
                "                const xhttp = new XMLHttpRequest();\n" +
                "                xhttp.onload = function() {\n" +
                "                    document.getElementById(\"sinrespmsg\").innerHTML =\n" +
                "                    this.responseText;\n" +
                "                }\n" +
                "                xhttp.open(\"GET\", \"/sin?num=\"+nameVar);\n" +
                "                xhttp.send();\n" +
                "            }\n" +
                "        </script>\n" +
                "\n" +
                "        <h1>Form Cos</h1>\n" +
                "        <h2>Hi, put the number</h2>\n" +
                "        <form action=\"/movie\">\n" +
                "            <label for=\"cos\">Name:</label><br>\n" +
                "            <input type=\"text\" id=\"cos\" name=\"cos\" value=\"0.98\"><br><br>\n" +
                "            <input type=\"button\" value=\"Search\" onclick=\"loadGetCos()\">\n" +
                "        </form> \n" +
                "        <div id=\"cosrespmsg\"></div>\n" +
                "\n" +
                "        <script>\n" +
                "            function loadGetCos() {\n" +
                "                let nameVar = document.getElementById(\"cos\").value;\n" +
                "                const xhttp = new XMLHttpRequest();\n" +
                "                xhttp.onload = function() {\n" +
                "                    document.getElementById(\"cosrespmsg\").innerHTML =\n" +
                "                    this.responseText;\n" +
                "                }\n" +
                "                xhttp.open(\"GET\", \"/cos?num=\"+nameVar);\n" +
                "                xhttp.send();\n" +
                "            }\n" +
                "        </script>\n" +
                "\n" +
                "        <h1>Form Palindrome</h1>\n" +
                "        <h2>Hi, put the word</h2>\n" +
                "        <form action=\"/movie\">\n" +
                "            <label for=\"pali\">Name:</label><br>\n" +
                "            <input type=\"text\" id=\"pali\" name=\"pali\" value=\"sedes\"><br><br>\n" +
                "            <input type=\"button\" value=\"Search\" onclick=\"loadGetPali()\">\n" +
                "        </form> \n" +
                "        <div id=\"palirespmsg\"></div>\n" +
                "\n" +
                "        <script>\n" +
                "            function loadGetPali() {\n" +
                "                let nameVar = document.getElementById(\"pali\").value;\n" +
                "                const xhttp = new XMLHttpRequest();\n" +
                "                xhttp.onload = function() {\n" +
                "                    document.getElementById(\"palirespmsg\").innerHTML =\n" +
                "                    this.responseText;\n" +
                "                }\n" +
                "                xhttp.open(\"GET\", \"/palindromo?word=\"+nameVar);\n" +
                "                xhttp.send();\n" +
                "            }\n" +
                "        </script>\n" +
                "\n" +
                "        <h1>Form Vector Magnitude</h1>\n" +
                "        <h2>Hi, put the word</h2>\n" +
                "        <form action=\"/movie\">\n" +
                "            <label for=\"name1\">Name1:</label><br>\n" +
                "            <input type=\"text\" id=\"name1\" name=\"name1\" value=\"1\"><br><br>\n" +
                "            <label for=\"name2\">Name2:</label><br>\n" +
                "            <input type=\"text\" id=\"name2\" name=\"name2\" value=\"1\"><br><br>\n" +
                "            <input type=\"button\" value=\"Search\" onclick=\"loadGetVector()\">\n" +
                "        </form> \n" +
                "        <div id=\"vecrespmsg\"></div>\n" +
                "\n" +
                "        <script>\n" +
                "            function loadGetVector() {\n" +
                "                let nameVar = document.getElementById(\"name1\").value;\n" +
                "                let nameVar1 = document.getElementById(\"name2\").value;\n" +
                "                const xhttp = new XMLHttpRequest();\n" +
                "                xhttp.onload = function() {\n" +
                "                    document.getElementById(\"vecrespmsg\").innerHTML =\n" +
                "                    this.responseText;\n" +
                "                }\n" +
                "                xhttp.open(\"GET\", \"/vector?a=\"+nameVar+\"&b=\"+nameVar1);\n" +
                "                xhttp.send();\n" +
                "            }\n" +
                "        </script>\n" +
                "\n" +
                "    </body>\n" +
                "</html>";
        return response;
    }
}
