public class Service {

    private String privateMessage(){
        return "Hello World!";
    }

    public static String staticMessage(){
        return "This is static message.";
    }

    public final String finalMessage(){
        return "This is final Message!";
    }
}
