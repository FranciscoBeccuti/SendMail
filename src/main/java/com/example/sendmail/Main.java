package com.example.sendmail;

public class Main {
    public static void main(String[] args) {

        System.out.println("email sent? " +new SendMail("to@gmail.com","from@gmail.com","password","smtp.gmail.com", "Hello World!", "","Lorem ipsum dolor sit amet, consectetur adipiscing elit,",false).sendMail() );
        System.out.println("email sent? " +new SendMail("to@gmail.com","from@gmail.com","password","smtp.gmail.com", "Hello World! HTML FORMAT","", "\n" +
                "<h2>Header Level 2</h2>\n" +
                "\n" +
                "<ol>\n" +
                "   <li>Lorem ipsum dolor sit amet, consectetuer adipiscing elit.</li>\n" +
                "   <li>Aliquam tincidunt mauris eu risus.</li>\n" +
                "</ol>",true).sendMail());

        System.out.println("email sent? " +new SendMail("to@gmail.com","from@gmail.com","password","smtp.gmail.com", "Hello World! HTML FORMAT and attach","/attached.txt", "\n" +
                "<h2>Header Level 2</h2>\n" +
                "\n" +
                "<ol>\n" +
                "   <li>Lorem ipsum dolor sit amet, consectetuer adipiscing elit.</li>\n" +
                "   <li>Aliquam tincidunt mauris eu risus.</li>\n" +
                "</ol>",true).sendMail());
    }
}
