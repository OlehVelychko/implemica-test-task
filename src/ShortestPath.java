import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class ShortestPath {

    private static class Edge {
        int destination;
        int cost;

        public Edge(int destination, int cost) {
            this.destination = destination;
            this.cost = cost;
        }
    }

    // Dijkstra's algorithm for finding the shortest path
    private static int dijkstra(Map<Integer, List<Edge>> graph, int start, int end, int n) {
        int[] dist = new int[n + 1];
        Arrays.fill(dist, Integer.MAX_VALUE);
        dist[start] = 0;

        PriorityQueue<int[]> pq = new PriorityQueue<>(Comparator.comparingInt(a -> a[1]));
        pq.offer(new int[]{start, 0});

        while (!pq.isEmpty()) {
            int[] current = pq.poll();
            int node = current[0];
            int currentDist = current[1];

            if (currentDist > dist[node]) continue;

            for (Edge edge : graph.getOrDefault(node, Collections.emptyList())) {
                int newDist = currentDist + edge.cost;
                if (newDist < dist[edge.destination]) {
                    dist[edge.destination] = newDist;
                    pq.offer(new int[]{edge.destination, newDist});
                }
            }
        }

        return dist[end] == Integer.MAX_VALUE ? -1 : dist[end];
    }

    public static void main(String[] args) {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        try {
            int tests = Integer.parseInt(reader.readLine().trim());
            for (int t = 0; t < tests; t++) {
                // Skip empty lines between tests
                String line;
                while ((line = reader.readLine()) != null && line.trim().isEmpty()) {}

                // Read number of cities
                int citiesCount = 0;
                if (line != null) {
                    citiesCount = Integer.parseInt(line.trim());
                }
                Map<String, Integer> cityIndex = new HashMap<>();
                Map<Integer, List<Edge>> graph = new HashMap<>();

                for (int i = 1; i <= citiesCount; i++) {
                    String cityName = reader.readLine().trim();
                    cityIndex.put(cityName, i);

                    int neighbors = Integer.parseInt(reader.readLine().trim());
                    graph.put(i, new ArrayList<>());
                    for (int j = 0; j < neighbors; j++) {
                        String[] edgeData = reader.readLine().trim().split("\\s+");
                        int neighbor = Integer.parseInt(edgeData[0]);
                        int cost = Integer.parseInt(edgeData[1]);
                        graph.get(i).add(new Edge(neighbor, cost));
                    }
                }

                int paths = Integer.parseInt(reader.readLine().trim());
                StringBuilder output = new StringBuilder();

                for (int p = 0; p < paths; p++) {
                    String[] pathData = reader.readLine().trim().split("\\s+");
                    String startCity = pathData[0];
                    String endCity = pathData[1];

                    if (!cityIndex.containsKey(startCity) || !cityIndex.containsKey(endCity)) {
                        output.append("-1\n");
                        continue;
                    }

                    int start = cityIndex.get(startCity);
                    int end = cityIndex.get(endCity);

                    int cost = dijkstra(graph, start, end, citiesCount);
                    output.append(cost).append("\n");
                }

                // Print results for the current test
                System.out.print(output.toString().trim());

                // Add a blank line after each test except the last one
                if (t < tests - 1) {
                    System.out.println();
                }
            }
        } catch (IOException | NumberFormatException e) {
            System.out.println("An error occurred: " + e.getMessage());
        }
    }
}