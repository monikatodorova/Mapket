package PipeAndFilter;

public class ToLowerCase implements Filter<String> {

    @Override
    public String execute(String input) {

        String[] rez = input.split(",");
        StringBuilder sb = new StringBuilder();

        if(rez.length < 3) {
            return input;
        }

        for(int i=0; i< rez.length; i++) {
            if(i==3 && rez[i]!="") {
                sb.append(rez[i].toLowerCase()+",");
            } else {
                sb.append(rez[i]+",");
            }
        }

        return sb.toString();
    }

}
