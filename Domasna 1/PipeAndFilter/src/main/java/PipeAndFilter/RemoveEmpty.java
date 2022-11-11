package PipeAndFilter;

public class RemoveEmpty implements Filter<String> {

    @Override
    public String execute(String input) {

        String[] rez = input.split(",");

        if(rez.length == 3) {
            return "";
        }

        if(rez[3].equals("")) {
            return "";
        }

        return input;
    }
}
