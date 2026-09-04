class Solution {
    private boolean dfs(int node, List<List<Integer>> adj, int[] visited) {
        if (visited[node] == 1) {
            return true;
        }
        if (visited[node] == 2) {
            return false;
        }
        visited[node] = 1;
        for (int next : adj.get(node)) {
            if (dfs(next, adj, visited)) {
                return true;
            }
        }
        visited[node] = 2;
        return false;
    }

    public boolean canFinish(int numCourses, int[][] prerequisites) {
        List<List<Integer>> adj = new ArrayList<>();
        for (int i = 0; i < numCourses; i++) {
            adj.add(new ArrayList<>());
        }
        for (int[] prerequisite : prerequisites) {
            int course = prerequisite[0];
            int pre = prerequisite[1];

            adj.get(pre).add(course);
        }

        int[] visited = new int[numCourses];

        for (int i = 0; i < adj.size(); i++) {
            if (visited[i] == 0) {
                if (dfs(i, adj, visited)) {
                    return false;
                }
            }
        }

        return true;
    }
}
