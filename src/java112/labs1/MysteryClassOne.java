package java112.labs1;

/**
* Myster class one provides pratice with TDD. The class will display a number
*
* @author jpabon
*/
public class MysteryClassOne {

    /**
    * Instantiate MysteryClassOne and output the result of the mysteryMethodOne
    * @param args command line arguments
    */
    public static void main(String[] args) {
        MysteryClassOne lab = new MysteryClassOne();
        System.out.println("The method returned: " + lab.mysteryMethodOne());

    }
    /**
    * return a number specified by the unit tests
    * @return a single digit value may be a mystery
    *
    */
    public int mysteryMethodOne() {
        return 1;
    }
}
