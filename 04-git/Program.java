
// Print Hello <name>
public class Program {

    public void print_name(String _name){
        System.out.println("Hello, " + _name);
    }

    public static void main(String[] args) {

        Program program = new Program();
        // Prints "Hello, World" to the terminal window.
        program.print_name("Kasia");
    }

}
