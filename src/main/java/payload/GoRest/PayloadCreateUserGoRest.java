package payload.GoRest;

public class PayloadCreateUserGoRest {


    public static  String getGoRestCreateUerPayload()
    {
        return  "{\n" +
                " \"name\": \"Niteen\",\n" +
                " \"email\": \"niteen@gmail.com\",\n" +
                " \"gender\": \"male\",\n" +
                " \"status\": \"active\"\n" +
                "}";
    }

    public static  String getGoRestCreateUerPayload(String name,String email,String gender,String status)
    {
        /*return  "{\n" +
                " \"name\": \""+name+"\",\n" +
                " \"email\": \""+email+"\",\n" +
                " \"gender\": \""+gender+"\",\n" +
                " \"status\": \""+status+"\"\n" +
                "}";*/


        return  String.format("{\n" +
                " \"name\": \"%s\",\n" +
                " \"email\": \"%s\",\n" +
                " \"gender\": \"%s\",\n" +
                " \"status\": \"%s\"\n" +
                "}",name,email,gender,status);
    }

}
