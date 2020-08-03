public class HelloWorld {
    public String sayHi(String input) {
        String firstLetter = input.substring(0,1);
        String remainLetter = input.substring(1);
        String output = firstLetter.toUpperCase() + remainLetter;
        return "Hello"+" "+output;
    }
    public String sayHi(){
        return "Hello World";
    }
}
