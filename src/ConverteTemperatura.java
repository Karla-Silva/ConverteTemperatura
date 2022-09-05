import java.util.Arrays;
import java.util.Scanner;

public class ConverteTemperatura {

    public static void main(String[] args){
        while(true) {

            Scanner scanner = new Scanner(System.in);

            int amountOfTemperatures;
            UnitTemp inputTempType;
            UnitTemp outputTempType;

            Initialize initialize = new Initialize();
            initialize.Welcome();
            amountOfTemperatures = AmountOfTemperatures();
            System.out.println("____________________________________________________________________________");
            inputTempType = InputTemperatureType();
            System.out.println("____________________________________________________________________________");
            outputTempType = OutputTemperatureType();
            System.out.println("____________________________________________________________________________");

            double[] temperaturesInput = new double[amountOfTemperatures];
            double[] temperaturesOutput = new double[amountOfTemperatures];

            System.out.println("Informe as temperaturas em " + inputTempType.toString().toLowerCase()
                    + " que deseja transformar: ");

            for (int i = 0; i < amountOfTemperatures; i++) {
                while (true) {
                    try {
                        int t = i + 1;
                        System.out.print("Temperatura " + t + ":");
                        temperaturesInput[i] = scanner.nextDouble();
                        break;
                    } catch (Exception e) {
                        scanner.next();
                        System.out.println("Ocorreu um erro. Tente novamente.");
                    }
                }
            }
            System.out.println("____________________________________________________________________________");

            switch (outputTempType) {
                case CELSIUS:
                    temperaturesOutput = TransformToCelsius.ToCelsius(inputTempType, temperaturesInput);
                    break;
                case KELVIN:
                    temperaturesOutput = TransformToKelvin.ToKelvin(inputTempType, temperaturesInput);
                    break;
                case FAHRENHEIT:
                    temperaturesInput = TransformToFahrenheit.ToFahrenheit(inputTempType, temperaturesInput);
                default:
                    break;
            }

            ExhibitTemperature.exhibit(temperaturesInput, temperaturesOutput, inputTempType, outputTempType);
            System.out.println("____________________________________________________________________________");
            CalculateAverage.Average(temperaturesInput, inputTempType, "entrada");
            CalculateAverage.Average(temperaturesOutput, outputTempType, "saída");
            System.out.println("____________________________________________________________________________");

            System.out.println("Deseja encerrar o programa? Aperte S para Sim ou qualquer tecla para Não.");
            String SouN = scanner.next().toUpperCase();
            if(SouN.equals("S")){
                break;
            }
        }
    }

    public static int AmountOfTemperatures(){
        Scanner scanner = new Scanner(System.in);
        int amount;
        while(true){
            try{
                System.out.print("Informe quantas temperaturas você deseja converter: ");
                amount = scanner.nextInt();
                while (amount<=0){
                    System.out.println("Quantidade incorreta. Tente novamente.");
                    amount = scanner.nextInt();
                }
                break;
            } catch (Exception e){
                scanner.next();
                System.out.println("Quantidade incorreta. Tente novamente.");
            }
        }
        return amount;
    }

    public static UnitTemp InputTemperatureType(){
        Scanner scanner = new Scanner(System.in);
        String option;
        boolean repeat;
        do {
            System.out.println("\nInforme a unidade de medida inicial das temperaturas que deseja converter. " +
                    "\nOpcões: " +
                    "\nCELSIUS " +
                    "\nFAHRENHEIT " +
                    "\nKELVIN");
            option = scanner.nextLine().toUpperCase();
            if (!(option.equals("CELSIUS") || option.equals("FAHRENHEIT") || option.equals("KELVIN"))) {
                System.out.println("Opção incorreta. Tente novamente.");
                repeat = true;
            } else {
                repeat = false;
            }
        } while(repeat);

        return UnitTemp.valueOf(option);
    }

    public static UnitTemp OutputTemperatureType(){
        Scanner scanner = new Scanner(System.in);
        String option;
        boolean repeat;
        do {
            System.out.println("\nInforme a unidade de medida final das temperaturas que deseja converter. " +
                    "\nOpcões: " +
                    "\nCELSIUS " +
                    "\nFAHRENHEIT " +
                    "\nKELVIN");
            option = scanner.nextLine().toUpperCase();
            if (!(option.equals("CELSIUS") || option.equals("FAHRENHEIT") || option.equals("KELVIN"))) {
                System.out.println("Opção incorreta. Tente novamente.");
                repeat = true;
            } else {
                repeat = false;
            }
        } while(repeat);

        return UnitTemp.valueOf(option);
    }

}

