public class ExhibitTemperature {
    public static void exhibit(double[] input, double[] output, UnitTemp typeInput, UnitTemp typeOutput){
        System.out.println("Conversões realizadas: ");
        for(int i = 0; i<input.length; i++){
            System.out.println(input[i] + " " + typeInput.toString() + " -> " + output[i] + " " + typeOutput.toString());
        }
    }
}
