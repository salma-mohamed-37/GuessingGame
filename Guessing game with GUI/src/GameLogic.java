import java.util.Random;

public class GameLogic
{
    int lower =1 ;
	int upper =100 ;
	int target ;
	String message;
	int numberOfGuesses =0;
	void begin()
	{
		Random rand = new Random();
		target = rand.nextInt(98)+ 1;
	}
	String checkInput(int input)
	{
		if(input == target)
		{
			message = "Your guess is right, you tried "+numberOfGuesses+" times";
		}
		else if(input<=1 || input >=100)
		{
			message = "Invalid input you have tp enter a number between 1 and 100";
		}
	    else if( input > target && input<upper)
	    {
	        upper=input;
	        message = "Enter another number";
	        numberOfGuesses++;
	    }
	    else if(input< target && input>lower)
	    {
	        lower=input;
	        message = "Enter another number";
	        numberOfGuesses++;
	    }
	    return message ;
	}
	
}
