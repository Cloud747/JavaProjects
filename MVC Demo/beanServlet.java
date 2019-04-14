package java112.project3;
/**

*  This is a JavaBean to demonstrate using beans with JSP.

*

*@author    eknapp

*/

public class BeanOne {    private String data;    private int holeOne;

   private int holeTwo;

   private int holeThree;

   private int holeFour;

   private int holeFive;

   private int holeSix;

   private int holeSeven;

   private int holeEight;

   private int holeNine;

   private int holeTen;

   private int holeEleven;

   private int holeTwelve;

   private int holeThirteen;

   private int holeFourteen;

   private int holeFiveteen;

   private int holeSixteen;

   private int holeSeventeen;

   private int holeEighteen;    /**

    *  Constructor for the BeanOne object

    */

   public BeanOne() {

       name = "default value";

   }    /**

    *  Gets the Data attribute of the BeanOne object

    *

    *@return    The Data value

    */

   public String getData() {

       return data;

   }    public int getTotal() {

       return this.holeOne + this.holeTwo + this.holeThree + this.holeFour

               + this.holeFive + this.holeSix + this.holeSeven + this.holeEight

               + this.holeNine + this.holeTen + this.holeEleven + this.holeTwelve

               + this.holeThirteen + this.holeFourteen + this.holeFiveteen

               + this.holeSixteen + this.holeSeventeen + this.holeEighteen;

   }    /**

    *  Sets the Data attribute of the BeanOne object

    *

    *@param  data  The new Data value

    */

   public void setData(String data) {

       this.data = data;

   }    public void setHoleOne(int holeOne) {

       this.holeOne = holeOne;

   }

}
