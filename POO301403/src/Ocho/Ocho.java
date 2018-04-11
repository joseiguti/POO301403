package Ocho;

// Fig. 13.1: DivideByZeroNoExceptionHandling.java
// An application that attempts to divide by zero.
import java.util.Scanner;

public class Ocho
{
     // demonstrates throwing an exception when a divide-by-zero occurs
     public static int quotient( int numerator, int denominator )
     {
        return numerator / denominator; // possible division by zero
     } // end method quotient
  
     public static void main( String args[] )
     {
        Scanner scanner = new Scanner( System.in ); // scanner for input
  
        System.out.print( "Ingrese numerador: " );
        
        int numerator = scanner.nextInt();
        
        System.out.print( "Ingrese denominador: " );
        
        int denominator = scanner.nextInt();
  
        if (denominator == 0) {
        	
            throw new IllegalArgumentException("El denominador no puede ser 0");
            
        }
        
        int result = quotient( numerator, denominator );
        
        System.out.printf( "\nResultado: %d / %d = %d\n", numerator, denominator, result );
        
     } // end main
  } // end class DivideByZeroNoExceptionHandling