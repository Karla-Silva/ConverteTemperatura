public class CalculateAverage {
    public static void Average(double[] temp, UnitTemp unit, String string){
        double sum = 0;

        for(int i=0; i< temp.length; i++){
            sum = sum + temp[i];
        }

        double average = sum/temp.length;

        System.out.println("A média das temperaturas de "+string+" foi de "+average + " "+unit);

    }
}
