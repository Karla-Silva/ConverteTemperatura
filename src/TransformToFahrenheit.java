public class TransformToFahrenheit {
    public static double[] ToFahrenheit(UnitTemp type, double[] input){

        double[] output = new double[input.length];

        for(int i=0; i<input.length; i++){
            if (type == UnitTemp.CELSIUS) {
                output[i] = (input[i] * 1.8) + 32;
            } else if(type == UnitTemp.KELVIN){
                output[i] = ((input[i] - 273.15) * 1.8) + 32;
            } else {
                output[i] = input[i];
            }
        }

        return output;

    }
}
