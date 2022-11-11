package PipeAndFilter;

import java.io.*;
import java.util.Scanner;

public class PipeAndFilterProblem {
    public static void main(String[] args) throws FileNotFoundException {

        Pipe<String> pipe = new Pipe<>();

        ToLowerCase toLowerCase = new ToLowerCase();
        FirstLetterCapital firstLetterCapital = new FirstLetterCapital();
        RemoveEmpty removeEmpty = new RemoveEmpty();

        pipe.addFilter(toLowerCase);
        pipe.addFilter(firstLetterCapital);
        pipe.addFilter(removeEmpty);

        Scanner scanner = new Scanner(new File("C:\\Users\\monik\\Desktop\\Mapket\\Domasna 1\\PipeAndFilter\\src\\main\\resources\\MarketiInitial.csv"));
        scanner.useDelimiter(",");
        File csvOutputFile = new File("C:\\Users\\monik\\Desktop\\Mapket\\Domasna 1\\Marketi.csv");
        try (PrintWriter pw = new PrintWriter(csvOutputFile)) {
            while(scanner.hasNextLine()) {
                String result = pipe.runFilter(scanner.nextLine());
                if(result.equals("")) {
                    continue;
                }
                pw.println(result);
            }
        }



    }
}
