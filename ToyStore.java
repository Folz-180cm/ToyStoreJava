public class ToyStore {
    private List<Toy> toys;
    private List<Toy> prizeToys;
    private Random random;

    public ToyStore() {
        toys = new ArrayList<>();
        prizeToys = new ArrayList<>();
        random = new Random();
    }

    public void addToy(Toy toy) {
        toys.add(toy);
    }

    public void setToyWeight(int toyId, int weight) {
        for (Toy toy : toys) {
            if (toy.getId() == toyId) {
                toy.setWeight(weight);
                return;
            }
        }
        System.out.println("Toy not found");
    }

    public void startRaffle(int numPrizes) {
        for (int i = 0; i < numPrizes; i++) {
            Toy prizeToy = selectPrizeToy();
            prizeToys.add(prizeToy);
            prizeToy.decreaseQuantity();
        }
    }

    public Toy getPrizeToy() {
        if (prizeToys.size() == 0) {
            System.out.println("No prize toys available");
            return null;
        }
        Toy prizeToy = prizeToys.remove(0);
        try {
            FileWriter writer = new FileWriter("prize_toys.txt", true);
            writer.write(prizeToy.getName() + "\n");
            writer.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return prizeToy;
    }

    private Toy selectPrizeToy() {
        int totalWeight = 0;
        for (Toy toy : toys) {
            totalWeight += toy.getWeight();
        }
        int rand = random.nextInt(totalWeight) + 1;
        for (Toy toy : toys) {
            rand -= toy.getWeight();
            if (rand <= 0) {
                return toy;
            }
        }
        return null;
    }
}