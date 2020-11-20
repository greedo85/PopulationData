public class Main {
    public static void main( String[] args ) {
        PopulationData populationData = new PopulationData(10000);

        populationData.findKids();

        populationData.passedIn5Years();

        populationData.threeOldesSingles();
    }
}
