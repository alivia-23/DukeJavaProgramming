/**
 * 1. Write the method named howMany that has two String parameters named stringa and stringb
 * 2. This method returns an integer indicating how many times stringa appears in stringb,
 *    where each occurrence of stringa must not overlap with another occurrence of it.
 * 3. For example, the call howMany(“GAA”, “ATGAACGAATTGAATC”) returns 3 as GAA occurs 3 times.
 *    The call howMany(“AA”, “ATAAAA”) returns 2. Note that the AA’s found cannot overlap.
 * 4. Write the void method testHowMany has no parameters. Add code in here to call howMany with several examples and print the results.
 *    Think carefully about what types of examples would be good to test to make sure your method works correctly.
 */
public class Part2 {
    public static int howMany(String stringa, String stringb){
        int count = 0;
        int firstOccur = stringb.indexOf(stringa);
        if (firstOccur > -1) {
            count = count + 1;
            while (stringb.indexOf(stringa, firstOccur) != -1 && firstOccur != -1) {
                count = count + 1;
                firstOccur = stringb.indexOf(stringa, firstOccur+stringa.length());
            }
            count = count - 1;
        }
        else {
            count = 0;
        }
        return count;
    }

    public static void main(String[] args) {
        String stringa = "GAA";
        String stringb = "ATGAACGAATTGAATC";
        howMany(stringa, stringb);
        if (howMany(stringa, stringb) == 0) {
            System.out.println("no occurrence found");
        } else {
            System.out.println("Last Count is: " + howMany(stringa, stringb));
        }
        stringa = "AA";
        stringb = "ATAAAA";
        howMany(stringa, stringb);
        if (howMany(stringa, stringb) == 0) {
            System.out.println("no occurrence found");
        } else {
            System.out.println("Last Count is: " + howMany(stringa, stringb));
        }
        stringa = "AA";
        stringb = "ATABABAB";
        howMany(stringa, stringb);
        if (howMany(stringa, stringb) == 0) {
            System.out.println("no occurrence found");
        } else {
            System.out.println("Last Count is: " + howMany(stringa, stringb));
        }
        stringa = "ACAB";
        stringb = "AAAAACABACABAAAACABACABAA";
        howMany(stringa, stringb);
        if (howMany(stringa, stringb) == 0) {
            System.out.println("no occurrence found");
        } else {
            System.out.println("Last Count is: " + howMany(stringa, stringb));
        }
    }
}
