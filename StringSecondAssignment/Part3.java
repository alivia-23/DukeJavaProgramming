/**
 * 1. Write the method named countGenes that has a String parameter named dna representing a string of DNA.
 *    This method returns the number of genes found in dna. For example the call countGenes(“ATGTAAGATGCCCTAGT”)
 *    returns 2, finding the gene ATGTAA first and then the gene ATGCCCTAG. Hint: This is very similar to finding
 *    all genes and printing them, except that instead of printing all the genes you will count them.
 *
 * 2. Write the void method named testCountGenes that has no parameters.  This method calls countGenes
 *   with many example strings and prints the result for each. You should create several examples with different numbers of genes to test your code.
 */
public class Part3 {
    public static int findStopCodon(String dnaStr, int startIndex, String stopCodon) {
        startIndex = dnaStr.indexOf("ATG");
        int currIndex = dnaStr.indexOf(stopCodon, startIndex + 3);
        while (currIndex != -1) {
            int diff = (currIndex - startIndex) % 3;
            if (diff == 0) {
                return currIndex;
            }
            else {
                currIndex = dnaStr.indexOf(stopCodon, currIndex +1);
            }
        }
        return dnaStr.length();
    }

    public static String findGene(String dna, int where){
        int atgCodon = dna.indexOf("ATG", where);

        if (atgCodon == -1) {
            return "NO ATG CODON FOUND";
        }
        int taaCodon = findStopCodon(dna, atgCodon, "TAA");
        int tagCodon = findStopCodon(dna, atgCodon, "TAG");
        int tgaCodon = findStopCodon(dna, atgCodon, "TGA");
        int minCodon = 0;
        if (taaCodon == -1 ||
                (tgaCodon != -1 && tgaCodon < taaCodon)) {
            minCodon = tgaCodon;
        }
        else {
            minCodon = taaCodon;
        }
        if (minCodon == -1 ||
                (tagCodon != -1 && tagCodon < minCodon)){
            minCodon = tagCodon;
        }
        if (minCodon == -1) {
            return "No ending codon found";
        }

        return dna.substring(atgCodon, minCodon+3);
    }

    public static void testFindGene(){
        String dna= "aaaaaATGaaaaaaaaaTAGaaaa";
        String gene = findGene(dna, 0);
        System.out.println("This is my gene: " + gene);
        if (!gene.equals("ATGCCCGGGAAATAA")){
            System.out.println("error");
        }
        /*System.out.println("tests finished");
        String dna= "AGDEGAASZZATAAAAA";
        System.out.println("The dna string is :" + dna);
        String gene = findGene(dna);
        System.out.println("Gene found is :" + gene);

        dna= "aaaaaaATGaaaaaaaaaTAGaaaa";
        System.out.println("The dna string is :" + dna);
        gene = findGene(dna);
        System.out.println("Gene found is :" + gene);

        dna= "aaaaaaATGaaaaaaaaaTAGTTATGAaaa";
        System.out.println("The dna string is :" + dna);
        gene = findGene(dna);
        System.out.println("Gene found is :" + gene);

        dna= "aaaaaaATGaaaaaaaaaAAAAaaa";
        System.out.println("The dna string is :" + dna);
        gene = findGene(dna);
        System.out.println("Gene found is :" + gene);*/

    }

    public static int countGenes(String dna){
        int count = 0;

        int firstOccur = dna.indexOf(findGene(dna, 0));
        String wholeGene = findGene(dna, 0);
        if (firstOccur > -1) {
            count = count + 1;
        System.out.println("count 1 =" + count + " firstOccur= " +firstOccur + " gene string is: " + wholeGene + " this is the lenght: " +wholeGene.length() );

        while (dna.indexOf(wholeGene, firstOccur) != -1 && firstOccur != -1) {
            count = count +1;
            firstOccur = dna.indexOf(wholeGene, firstOccur)+wholeGene.length();
            System.out.println(dna +"count 2 =" + count + " firstOccur= " +firstOccur + " this is the lenght: " +wholeGene.length() );
            System.out.println("gene: " +wholeGene);
        }
        count = count -1;
        }
        else {
            count=0;
        }
        return 0;
    }
    public static void countGenes2(String dna){
        int startIndex = 0;
        while (true){
            String wholeGene = findGene(dna, startIndex);
            if (wholeGene.isEmpty()){
                break;
            }
            System.out.println("Gene found: " + wholeGene);
            startIndex = dna.indexOf(wholeGene,startIndex)+wholeGene.length();
        }
    }

    public static void testLast(){
        String dna = "ATGATCTAATTTATGaaaaaaaaaTGAAGA";
        System.out.println("Testing printGenes here " + dna);
        countGenes2(dna);
    }


    public static void testCountGenes(){
        String dna= "aaaATGTAAGATGCCCTAGT";
        System.out.println("I should find 2 and found these amount of genes:" + countGenes(dna));

        dna= "ATGTAGATGTAAATGTAA";
        System.out.println("I should find 3 and found these amount of genes:" + countGenes(dna));
    }

    public static void main(String[] args) {
        testCountGenes();
        testLast();
        testFindGene();
    }
}
