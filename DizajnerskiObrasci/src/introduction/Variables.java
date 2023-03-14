package introduction;

public class Variables {

	public static void main(String[] args) {
		
		double firstNumber; //deklaracija promenljive
		firstNumber = 1; //inicijalizacija promenljive
		double secondNumber = 5;
		
		double doubleResult = firstNumber / secondNumber;
		System.out.println(doubleResult);
		
		// da bi rezultat bio tipa int, moram izvrsiti EKSPLICITNU konverziju
		int result = (int) (firstNumber / secondNumber);
		System.out.println(result);
		
		//logički tip podataka
		boolean alwaysTrue = true;
		boolean secondBoolean = false;
		//logicki operatori
		System.out.println(alwaysTrue && secondBoolean);  // AND - konjunkcija
		System.out.println(alwaysTrue || secondBoolean);  // OR - disjunkcija
		// negacija
		System.out.println(!alwaysTrue); //false
		System.out.println(!secondBoolean);  //true
		
		//konkatanacija (spajanje) stringova
		String name = "Petar";
		String lastName = "Petrovic";
		System.out.println(name + " "+ lastName + " Njegoš");
		
		//IF ELSE blok
		if (firstNumber > 0)
			System.out.println("Number is positive.");
		else if (firstNumber < 0)
			System.out.println("Number is negative.");
		else 
			System.out.println("Number is equal to zero.");
		
		//WHILE 
		//Ispisati brojeve od 1 do 10
		int i = 1;
		while (i < 11) { //i<=10
			
			System.out.println(i);
			i++;
		}
		
		//1. zadatak 
		int numOne = 24;
		int numTwo = 12;
		char operation = '-';
		int res;
		
		if (operation == '-')
			res = numOne-numTwo;
		else if (operation == '+')
			res = numOne+numTwo;
		else if (operation == '*')
			res = numOne*numTwo;
		else 
			res = numOne/numTwo;
		System.out.println("Result of operation: " + operation + " is: " + res);
		
		//2. zadatak
		// Faktorijal broja 5! = 5*4*3*2*1
		i=5;
		int factorial = 1;
		while (i > 0) {
			//factorial *= i;
			factorial = factorial * i;
			i--;
		}
		System.out.println("(while) 5! = " + factorial);
		//2. zadatak - 2.nacin
		i=5;
		factorial = 1;
		do {
			factorial = factorial * i;
			i--;
		}while(i>0);
		System.out.println("(do while) 5! = " + factorial);
		
		//Uz pomoć FOR petlje ispisati neparne brojeve od 1 do 10
		for(i = 1; i<=10; i++) {
			if (i % 2 == 1) {
				System.out.println(i);
			}
		}
		for(i = 1; i<=10; i++) {
			if (i % 2 == 0) {
				continue; //nastavlja for petlju
				//break; //zavrsava for petlju
			}
			System.out.println(i);
		}
	}

}
