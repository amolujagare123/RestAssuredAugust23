package payload.ChatServer;

public class PayloadCreateUserChatServer {

    public static String getChatServerCreateUerPayload()
    {
        return  "{\n" +
                "  \"username\": \"rahul555\",\n" +
                "  \"password\": \"rahul123\",\n" +
                "  \"email\": \"rahul@example.org\",\n" +
                "  \"name\": \"Rahul\",\n" +
                "  \"surname\": \"XYZ\",\n" +
                "  \"chat_nickname\": \"r123\",\n" +
                "  \"departments\": [\n" +
                "    1,\n" +
                "    2\n" +
                "  ],\n" +
                "  \"departments_read\": [\n" +
                "    2\n" +
                "  ],\n" +
                "  \"department_groups\": [\n" +
                "    1\n" +
                "  ],\n" +
                "  \"user_groups\": [\n" +
                "    1\n" +
                "  ]\n" +
                "}" ;
    }

    public static String getChatServerCreateUerPayload(String username,String password,String email,
    String name,String surname,String nickName)
    {
        return  String.format("{\n" +
                "  \"username\": \"%s\",\n" +
                "  \"password\": \"%s\",\n" +
                "  \"email\": \"%s\",\n" +
                "  \"name\": \"%s\",\n" +
                "  \"surname\": \"%s\",\n" +
                "  \"chat_nickname\": \"%s\",\n" +
                "  \"departments\": [\n" +
                "    1,\n" +
                "    2\n" +
                "  ],\n" +
                "  \"departments_read\": [\n" +
                "    2\n" +
                "  ],\n" +
                "  \"department_groups\": [\n" +
                "    1\n" +
                "  ],\n" +
                "  \"user_groups\": [\n" +
                "    1\n" +
                "  ]\n" +
                "}" ,username,password,email,name,surname,nickName);
    }

}
