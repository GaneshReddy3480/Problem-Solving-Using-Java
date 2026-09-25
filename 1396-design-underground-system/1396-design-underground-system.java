class UndergroundSystem {
    Map<Integer, Pair<String, Integer>> checkIn = new HashMap<>();
    Map<String, double[]> data = new HashMap<>();

    public UndergroundSystem() {
    }

    public void checkIn(int id, String stationName, int t) {
        checkIn.put(id, new Pair<>(stationName, t));
    }

    public void checkOut(int id, String stationName, int t) {
        Pair<String, Integer> p = checkIn.remove(id);
        String key = p.getKey() + "#" + stationName;
        double[] a = data.getOrDefault(key, new double[2]);
        a[0] += t - p.getValue();
        a[1]++;
        data.put(key, a);
    }

    public double getAverageTime(String startStation, String endStation) {
        double[] a = data.get(startStation + "#" + endStation);
        return a[0] / a[1];
    }
}