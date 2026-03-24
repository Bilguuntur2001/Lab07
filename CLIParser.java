public class CLIParser {
    private String file;
    private boolean help = false;

    public CLIParser(String[] args) {
        if (args.length == 0) {
            throw new IllegalArgumentException("File name required");
        }

        file = args[0];

        for (String arg : args) {
            if (arg.equals("--help")) {
                help = true;
            }
        }
    }

    public boolean hasHelp() {
        return help;
    }

    public String getFile() {
        return file;
    }
}
