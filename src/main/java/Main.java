/**
 * The Main class contains the main method to demonstrate the execution of MyExecutor's exec method.
 */
public class Main {
    /**
     * The main method to demonstrate the execution of MyExecutor's exec method.
     *
     * @param args The command line arguments (not used in this context).
     */
    public static void main(String[] args) {
        String text = "One Two, 3, la four, five what? One Two, 3, la four, five. wha ";
        StringBuilder s = new StringBuilder(text);

        try {
            System.out.println(MyExecutor.exec(new StringBuilder(s)));
        } catch (RuntimeException e) {
            System.out.println(e.getMessage());
        }
    }
}
