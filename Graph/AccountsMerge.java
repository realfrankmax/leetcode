package Graph;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Queue;
import java.util.Set;

/**
 * @leetcode: 721. Accounts Merge
 */
public class AccountsMerge {
    public static void main(String[] args) {}

    public List<List<String>> accountsMerge(List<List<String>> accounts) {
        // From email to base email
        // From base email to all emails
        Map<String, List<String>> graph = new HashMap<>();
        // Look up name by email
        Map<String, String> names = new HashMap<>();
        for (List<String> account : accounts) {
            String name = account.get(0);
            // Assume there is one email at least.
            String baseEmail = account.get(1);
            for (int i = 1; i < account.size(); i++) {
                String email = account.get(i);
                if (!graph.containsKey(email)) {
                    graph.put(email, new ArrayList<>());
                }
                graph.get(email).add(baseEmail);
                graph.get(baseEmail).add(email);
                names.put(email, name);
            }
        }
        Set<String> checked = new HashSet<>();
        List<List<String>> res = new ArrayList<>();
        for (String email : graph.keySet()) {
            if (!checked.contains(email)) {
                List<String> emails = new LinkedList<>();
                Queue<String> q = new LinkedList<>();
                q.add(email);
                checked.add(email);
                while (!q.isEmpty()) {
                    String curr = q.remove();
                    emails.add(curr);
                    for (String next : graph.get(curr)) {
                        if (!checked.contains(next)) {
                            q.add(next);
                            checked.add(next);
                        }
                    }
                }
                Collections.sort(emails);
                emails.add(0, names.get(email));
                res.add(emails);
            }
        }
        return res;
    }
}