public class TransformToCelsius {

    public static double[] ToCelsius(UnitTemp type, double[] input){

        double[] output = new double[input.length];

        for(int i = 0; i<input.length; i++){
            if (type == UnitTemp.FAHRENHEIT) {
                output[i] = (input[i] - 32)/1.8;
            } else if(type == UnitTemp.KELVIN){
                output[i] = input[i] - 273.15;
            } else {
                output[i] = input[i];
            }
        }

        return output;

    }
}
