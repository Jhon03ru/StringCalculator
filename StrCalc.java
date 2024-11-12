
import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class StrCalc {
    public static void main(String[] args) throws IOException {
        while (true) {



            Scanner key = new Scanner(System.in);
            String text = key.nextLine();
            String textTest = text.replaceAll("\"(.*?)\"", "");

            int c = textTest.length();

            char[] f = new char[c];
            for (int i = 0; i < f.length; i++) {


                f[i] = textTest.charAt(i);
            }

            for (char index : f) {


                if (index == '+' || index == '-') {


                    Calculation.summaAndDeduction(text, index);
                } else if (index == '*' || index == '/') {

                    Calculation.multiplicationAndDivision(text, index);

                }


            }
        }
    }

}
class Calculation {
    public static void summaAndDeduction ( String text, char i) throws IOException {
        Pattern pattern = Pattern.compile("\"(.*?)\"");
        Matcher matcher = pattern.matcher(text);
        ArrayList <String> words = new ArrayList<>();
        while (matcher.find()) {
            words.add(matcher.group(1));
        }
        String finishA = words.get(0);
        String finishB =words.get(1);
        int w = finishA.length();
        int z = finishB.length();
        if (w>10 || z>10) {
            throw new IOException();
        }
        if (i=='+') {
            String finishAB ="\""+finishA+finishB+"\"";
            System.out.println(finishAB);
        } else if (i=='-') {
            String finishAB =finishA.replaceAll(finishB,"");

            finishAB = "\""+finishAB+"\"";
            System.out.println(finishAB);

        }



    }
    public  static void multiplicationAndDivision ( String text , char l) throws IOException {

        Pattern pattern = Pattern.compile("\"(.*?)\"");
        Matcher matcher = pattern.matcher(text);
        ArrayList <String> words = new ArrayList<>();
        while (matcher.find()) {
            words.add(matcher.group(1));
        }
        String finishA =words.get(0);
        int k = finishA.length();
        if (k>10) {
            throw new IOException();
        }
        String multiplier = text.replaceAll("\"(.*?)\"","");
        if (l=='*') {
            String [] lot = multiplier.split("\\*");

            String strokaB = lot [1].trim();

            int b = Integer.parseInt(strokaB);
            if (b<1 || b>10) {
                throw new IOException();
            }

            String repeated = finishA.repeat(b);
            StringBuilder pop = new StringBuilder();
            for (int i =0; i<repeated.length(); i++) {
                if (i<40) {
                    pop.append(repeated.charAt(i));
                } else if (i==40){
                    pop.append("...");
                }





            } // цикл for

            repeated=pop.toString();

            String finishAB ="\""+repeated+"\"";
            System.out.println(finishAB);

        } else if (l=='/') {
            String [] lot = multiplier.split("/");

            String strokaB = lot [1].trim();
            int b = Integer.parseInt(strokaB);
            if (b<1 || b>10) {
                throw new IOException();
            }

            int t = finishA.length()/b;

            StringBuilder pop = new StringBuilder();
            for (int i =0; i<t; i++) {

                pop.append(finishA.charAt(i));
            }
            String finishAB = pop.toString();
            System.out.println("\""+finishAB+"\"");

        }





    }


} // класс







