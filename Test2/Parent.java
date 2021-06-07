package Test2;
public class Parent {

       private int dataValue1 ;

 

       public Parent( int d) 
       { dataValue1 = d;}

 

       public String toString(){ return "Parent: " + dataValue1 + "\n" ;}

      
}

 

 class Child1 extends Parent {

       private int dataValue2 ;

      

       public Child1( int d){

              super (4);

              dataValue2 = d;

       }

 

       public String toString(){ return super .toString() + "Child1: " + dataValue2 + "\n" ;}

}

 

class Child2 extends Parent {

       private double dataValue3 ;

      

       public Child2( double d){

              super (2);

              dataValue3 = d;

       }


       public String toString(){ return super .toString() + "Child2: " + dataValue3 + "\n" ;}

}

 

 