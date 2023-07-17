/**
 * 1. Create a new Java project named StringsFirstAssignments. You can put all the classes for this programming exercise in this project.
 *
 * 2.Create a new Java Class named Part1. The following methods go in this class.
 *
 * 3.Write the method findSimpleGene that has one String parameter dna, representing a string of DNA. This method does the following:
 *
 * Finds the index position of the start codon “ATG”. If there is no “ATG”, return the empty string.
 *
 * Finds the index position of the first stop codon “TAA” appearing after the “ATG” that was found. If there is no such “TAA”, return the empty string.
 *
 * If the length of the substring between the “ATG” and “TAA” is a multiple of 3, then return the substring that starts with that “ATG” and ends with that “TAA”.
 */
public class FindSimpleGene {

    public static String findSimpleGene(String dna) {
        int startIndex = dna.indexOf("ATG");
        System.out.println("Start Index is " + startIndex);
        if (startIndex == -1) {
            return "No start gene codon";
        }
        int stopIndex = dna.indexOf("TAA");
        System.out.println("Tail Index is " + stopIndex);
        if (stopIndex == -1) {
            return "No stop gene codon";
        }
        while (stopIndex != -1) {
            if ((stopIndex - startIndex) % 3 == 0) {
                return dna.substring(startIndex, stopIndex+3);
            } else {
                stopIndex = dna.indexOf("TAA", stopIndex + 1);
            }
        }
        return "null";
    }
//    public void testSimpleGene() {
//        //Test 1: DNA with no "ATG"
//
//        String dna = "ASTGSGTAATTAATCG";
//        System.out.println("DNA with no ATG " + dna);
//        String gene = findSimpleGene(dna);
//        System.out.println("Gene is " + gene);
//
//        //Test 2: DNA with no "TAA"
//        dna = "AATGSGTAGTTASTCG";
//        System.out.println("DNA with no TAA " + dna);
//        gene = findSimpleGene(dna);
//        System.out.println("Gene is " + gene);
//
//        //Test 3: DNA with no "ATG" or "TAA"
//        dna = "AATTSGTAGTTASTCG";
//        System.out.println("DNA with no ATG or TAA " + dna);
//        gene = findSimpleGene(dna);
//        System.out.println("Gene is " + gene);
//
//        //Test 4: DNA with ATG&TAA and the substring between them is a multiple of 3
//        dna = "AATGSGGTAATCGTTAATCG";
//        System.out.println("DNA with ATG and TAA correct mod3 " + dna);
//        gene = findSimpleGene(dna);
//        System.out.println("Gene is " + gene);
//
//        //Test 5" DNA with ATG&TAA and the substring between them is not a multiple of 3
//        dna = "AATGSGTAATCGTTAGTCG";
//        //dna = "AATGSGTAATCGTCTAATCG";
//        System.out.println("DNA with ATG and TAA incorrect mod3 " + dna);
//        gene = findSimpleGene(dna);
//        System.out.println("Gene is " + gene);
//
//    }

    public static void main(String[] args) {
        //Test 1: DNA with no "ATG"

        String dna = "ASTGSGTAATTAATCG";
        System.out.println("DNA with no ATG " + dna);
        String gene = findSimpleGene(dna);
        System.out.println("Gene is " + gene);

        //Test 2: DNA with no "TAA"
        dna = "AATGSGTAGTTASTCG";
        System.out.println("DNA with no TAA " + dna);
        gene = findSimpleGene(dna);
        System.out.println("Gene is " + gene);

        //Test 3: DNA with no "ATG" or "TAA"
        dna = "AATTSGTAGTTASTCG";
        System.out.println("DNA with no ATG or TAA " + dna);
        gene = findSimpleGene(dna);
        System.out.println("Gene is " + gene);

        //Test 4: DNA with ATG&TAA and the substring between them is a multiple of 3
        dna = "AATGSGGTAATCGTTAATCG";
        System.out.println("DNA with ATG and TAA correct mod3 " + dna);
        gene = findSimpleGene(dna);
        System.out.println("Gene is " + gene);

        //Test 5" DNA with ATG&TAA and the substring between them is not a multiple of 3
        dna = "AATGSGTAATCGTTAGTCG";
        //dna = "AATGSGTAATCGTCTAATCG";
        System.out.println("DNA with ATG and TAA incorrect mod3 " + dna);
        gene = findSimpleGene(dna);
        System.out.println("Gene is " + gene);
    }
}
