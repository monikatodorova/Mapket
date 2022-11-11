package PipeAndFilter;

public class FirstLetterCapital implements Filter<String> {

    @Override
    public String execute(String input) {

        int needed = 9;
        String[] rez = input.split(",");
        StringBuilder sb = new StringBuilder();

        for(int i=0; i<rez.length; i++) {
            if(i != 3) {
                sb.append(rez[i] + ",");
            } else {
                StringBuilder word = new StringBuilder();
                for(int j=0; j<rez[3].length(); j++) {
                    if(j==0) word.append(Character.toUpperCase(rez[3].charAt(0)));
                    else word.append(rez[3].charAt(j));
                }
                sb.append(word+",");
            }
        }
        int len = rez.length+1;
        while(len < needed) {
            sb.append(",");
            len++;
        }
        return sb.toString();

    }

}
