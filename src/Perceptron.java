import java.util.Random;

public class Perceptron
{

	double[] weights;
	double[] bias;
	int threshold; //co dung bias nen de threshold = 0

	public void Train(double[][] inputs, int[] outputs, double learningRate)
	{
		int inputLength = inputs[0].length;
		int outputLength = outputs.length;
		int loop = 100;

		this.threshold = 0;
		this.weights = new double[inputLength];
		this.bias = new double[inputLength];

		Random r = new Random();

		// initialize random weights
		for (int i = 0; i < inputLength; i++)
		{
			weights[i] = r.nextDouble() - 0.5;
			bias[i] = r.nextDouble() - 0.5;
		}

		for (int i = 0; i < loop; i++)
		{
			int totalError = 0;
			for (int j = 0; j < outputLength; j++)
			{
				int localError = outputs[j] - Output(inputs[j]);

				totalError += localError * localError;

				for (int k = 0; k < inputLength; k++)
				{
					weights[k] += learningRate * inputs[j][k] * localError;
					bias[k] += learningRate * localError;
				}

			}
			if (totalError == 0)
				break;
		}

	}

	public int Output(double[] input)
	{
		double sum = 0.0;
		for (int i = 0; i < input.length; i++)
		{
			sum += weights[i] * input[i] + bias[i];
		}

		if (sum > threshold)
			return 1;
		else
			return -1;
	}

}