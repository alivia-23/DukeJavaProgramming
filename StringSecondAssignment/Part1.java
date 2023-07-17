/**
 *  1. Write the method findStopCodon that has three parameters, a String parameter named dna,
 *     an integer parameter named startIndex that represents where the first occurrence of ATG occurs in dna,
 *     and a String parameter named stopCodon.
 *  2. This method returns the index of the first occurrence of stopCodon that appears past startIndex
 *     and is a multiple of 3 away from startIndex
 *  3. If there is no such stopCodon, this method returns the length of the dna strand.
 *  4. Write the void method testFindStopCodon that calls the method findStopCodon with several examples
 *     and prints out the results to check if findStopCodon is working correctly.
 */
public class Part1 {
    public static int findStopCodon(String dna, int startIndex, String stopCodon) {
        startIndex = dna.indexOf("ATG");
        int currIndex = dna.indexOf(stopCodon, startIndex + 3);
        while (currIndex != -1) {
            int diff = (currIndex - startIndex) % 3;
            if (diff == 0) {
                return currIndex;
            }
            else {
                currIndex = dna.indexOf(stopCodon, currIndex +1);
            }
        }
        return dna.length();
    }

    public static String findGene(String dna){
        int atgCodon = dna.indexOf("ATG");

        if (atgCodon == -1) {
            return "NO ATG CODON FOUND";
        }
        int taaCodon = findStopCodon(dna, atgCodon, "TAA");
        int tagCodon = findStopCodon(dna, atgCodon, "TAG");
        int tgaCodon = findStopCodon(dna, atgCodon, "TGA");
        int tempCodon = Math.min(taaCodon, tagCodon);
        int dnaFin = Math.min(tempCodon, tgaCodon);
        if (dnaFin == dna.length()) {
            return "NO GENE FOUND";
        }
        return dna.substring(atgCodon, dnaFin+3);
    }


    public void printAllGenes(){
        String dna= "aaaaaaATGaaaaaaaaaTAGTTATGAaaa";
        dna= "aaaaaaATGaaaaaaaaaTAGaaaa";
        dna = "AGDEGAASZZATAAAAA";
        while (true) {
            System.out.println("printing genes" + findGene(dna));
            if (findGene(dna).length() == -1) {
                break;
            }

        }
    }

    public static void main(String[] args) {
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
        System.out.println("Gene found is :" + gene);

    }
}

