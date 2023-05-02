import static org.junit.jupiter.api.Assertions.*;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;
import org.junit.jupiter.api.Test;

class CalculatorTest {
  @Test
  public void testMyProgram() {
    File inputFile = new File("tests/input.txt");
    File outputFile = new File("tests/output.txt");

    Scanner inputScanner = null;
    Scanner outputScanner = null;

    try{
      inputScanner = new Scanner(inputFile);
    } catch (FileNotFoundException e){
      System.out.println("Could not open " + inputFile);
    }

    try{
      outputScanner = new Scanner(outputFile);
    } catch (FileNotFoundException e){
      System.out.println("Could not open " + outputFile);
    }

    Calculator calc = new Calculator();

    while ((inputScanner != null && inputScanner.hasNextLine()) && (outputScanner != null && outputScanner.hasNextLine())) {
      String[] input = inputScanner.nextLine().split(",");

      String expectedOutput = outputScanner.nextLine();

      assertEquals(Integer.parseInt(expectedOutput), calc.add(Integer.parseInt(input[0]),Integer.parseInt(input[1])));
    }
    inputScanner.close();
    outputScanner.close();
  }

}