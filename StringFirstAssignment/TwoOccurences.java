public class TwoOccurences {
    public static boolean twoOccurences(String stringa, String stringb){
        System.out.println("Stringa is "+ stringa + "   Stringb is "+stringb);

        int found = stringb.indexOf(stringa);
        int count=0;

        while (found != -1) {
            count=count +1;
            System.out.println(stringb.substring(found, stringb.length()));
            found = stringb.indexOf(stringa, found+1);
        }
        System.out.println("Found this many   " + count);
        if (count >= 1)
            return true;
        else return false;

    }

    public static void main(String[] args) {
        //first test - valid input
        String a = "sea";
        String b = "sally sells seashells by the seashore";

        boolean answer = twoOccurences(a, b);

        System.out.println("The answer is " + answer);

    }
}

