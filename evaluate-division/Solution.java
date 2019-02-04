import java.util.HashMap;
import java.util.Arrays;
import java.util.HashSet;
import java.util.LinkedList;
import javafx.util.Pair;

class Solution {
    
    public double dfs(HashMap<String, HashSet<String>> edges, HashMap<String, Double> weights, String[] query) {
        String source = query[0];
        String dest = query[1];
        if(!edges.containsKey(source) || !edges.containsKey(dest)) return -1.0;
        
        // DFS Code
        HashSet<String> visited = new HashSet<>();
        LinkedList<Pair<String, Double>> st = new LinkedList<>();
        st.addLast(new Pair<>(source, 1.0));
        
        while (!st.isEmpty()){
            // CurrNode
            Pair<String, Double> node = st.removeFirst();
            String currNode = node.getKey();
            double currWeight = node.getValue();
            visited.add(currNode);
            
            if (currNode.equals(dest)) {
                return currWeight;
            }
            
            // Neighbours
            HashSet<String> neighbours = edges.get(currNode);
            for(String s: neighbours) {
                double weightS = weights.getOrDefault(currNode + "|" + s, 1.0);
                if(!visited.contains(s)) {
                    st.addLast(new Pair<String, Double>(s, weightS * currWeight));
                }
            }
        }
        return -1.0;
    }
    
    public double[] calcEquation(String[][] equations, double[] values, String[][] queries) {
        HashMap<String, Double> weight = new HashMap<>();
        HashMap<String, HashSet<String>> edges = new HashMap<>();
        
        // Putting all weights to hash
        for(int i=0; i < equations.length; i++) {
            String source = equations[i][0];
            String dest = equations[i][1];
            weight.put(source + "|" + dest, values[i]);
            weight.put(dest + "|" + source, 1.0 / values[i]);
            
            // For Source
            HashSet<String> n1 = edges.getOrDefault(source, new HashSet<String>());
            n1.add(dest);
            edges.put(source, n1);
            
            // For Destination
            HashSet<String> n2 = edges.getOrDefault(dest, new HashSet<String>());
            n2.add(source);
            edges.put(dest, n2);
        }
        
        // DFS
        double[] result = new double[queries.length];
        for(int i=0; i<queries.length; i++){
            result[i] = dfs(edges, weight, queries[i]);
        }
        return result;
    }
}
