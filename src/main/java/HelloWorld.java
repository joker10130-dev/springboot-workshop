public class HelloWorld {
    public String sayHi(String input) {
        String output = input.substring(0, 1).toUpperCase() + input.substring(1);
        return "Hello"+" "+output;
    }
    public String sayHi(){
        return "Hello World";
    }
}
