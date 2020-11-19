public class Main {
    public static void main( String[] args ) {
        PopulationData populationData=null;
        try {
            populationData = new PopulationData(1000);
        System.out.println(populationData.citizens);
        }
        catch (NullPointerException e)
        {

        }
    }
}
