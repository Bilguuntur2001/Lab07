public class Main {
    public static void main(String[] args) {
        try {
            CLIParser parser = new CLIParser(args);

            if (parser.hasHelp()) {
                HelpPrinter.print();
                return;
            }

            FlashcardApp app = new FlashcardApp(parser);
            app.run();
        } catch (Exception e) {
            System.out.println("Error: " + e.getMessage());
        }
    }
}