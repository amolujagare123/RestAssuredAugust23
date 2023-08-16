package payload.sampleUser;

public class PayLoadCreateUser {

    public static String getCreateUserPayLoad()
    {
        return "   {\n" +
                 "    \"name\": \"Avinash\",\n" +
                    "    \"job\": \"Test Lead\"\n" +
                    "}" ;
    }

    public static String getCreateUserPayLoad(String name,String job)
    {
       /* return "   {\n" +
                "    \"name\": \""+name+"\",\n" +
                "    \"job\": \""+job+"\"\n" +
                "}" ;*/

       /* return "   {\n" +
                "    \"name\": \"+name+\",\n" +
                "    \"job\": \"+job+\"\n" +
                "}" ;*/

        return String.format("{\n" +
                        "    \"name\": \"%s\",\n" +
                        "    \"job\": \"%s\"\n" +
                        "}",
                name, job);

    }

}
