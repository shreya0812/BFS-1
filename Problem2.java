// Time Complexity : O(V + E), where V = number of courses (vertices), E = number of prerequisites (edges)
// Space Complexity : O(V + E), for the adjacency list and the in-degree array
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No

// Your code here along with comments explaining your approach:
// Topological Sort problem
// We use an `inDegree` array to track how many prerequisites each course has.
// We also build an adjacency list (`map`) to track which courses depend on a given course.
// We then add all courses with in-degree 0 to a queue, meaning they can be taken immediately.
// As we process these courses, we reduce the in-degree of their dependent courses.
// If a dependent course’s in-degree drops to 0, it’s added to the queue.
// We use a counter to track how many courses we've processed.
// If the count equals the number of courses, it means all courses can be completed without circular dependency.

class Solution {
    public boolean canFinish(int numCourses, int[][] prerequisites) {
        int[] inDegree = new int[numCourses];
        HashMap<Integer,List<Integer>> map = new HashMap<>();


        // Creates indegree array and the adjacency list
        for(int[] x: prerequisites){//O(E)
            inDegree[x[0]]++;
            map.putIfAbsent(x[1],new ArrayList<>());
            map.get(x[1]).add(x[0]);
        }

        int count = 0;
        Queue<Integer> q = new LinkedList<>();

        // Adds initial courses with indegree 0;
        for(int i = 0; i < inDegree.length; i++){//O(v)
            if(inDegree[i] == 0){
                q.add(i);
                count++;
            }
        }

        while(!q.isEmpty()){//0(V)
            // pop and get its dependencies
            int curr = q.poll();
            List<Integer> dependencies = map.get(curr);
            // decrease the indegree for the dependencies and check if their indegree becomes 0. If 0, add them to the queue and increase counter.
            if( dependencies != null) {
                for (int d : dependencies) {//
                    inDegree[d]--;
                    if(inDegree[d] == 0){
                        q.add(d);
                        count++;
                    }
                }
            }
        }
        // return true id all courses are completed
        if(count == numCourses) return true;
        return false;
    }
}