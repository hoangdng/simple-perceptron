
public class Classifier
{
	public static void main(String[] args)
	{
		Perceptron pct = new Perceptron();
		double inputs[][] = { { 10, 1 }, { 5, 2 }, { 7, 1 }, { 4, 2.5 }, { 4, 1 }, { 5, 0.5 }, { 8, 0.5 }, { 8, 1 },
				{ 7, 0.3 }, { 6, 0.3 } };
		int outputs[] = { 1, 1, 1, 1, -1, -1, -1, 1, -1, -1 };
		pct.Train(inputs, outputs, 0.1);
		
		double input[] = { 4, 3 };
		System.out.println(pct.Output(input));
	}
}
