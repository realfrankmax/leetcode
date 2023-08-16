package String;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @leetcode: 811. Subdomain Visit Count
 */
public class SubdomainVisits {
    public static void main(String[] args) {}

    public List<String> subdomainVisits(String[] cpdomains) {
        Map<String, Integer> countMap = new HashMap<>();
        for (String cp : cpdomains) {
            String[] countWithDomain = cp.split(" ");
            int count = Integer.parseInt(countWithDomain[0]);
            String domains = countWithDomain[1];
            for (int i = domains.length()-1; i >= 0; i--) {
                if (domains.charAt(i) == '.' || i == 0) {
                    String subDomain = i == 0 ? domains.substring(0) : domains.substring(i+1);
                    countMap.put(subDomain, countMap.getOrDefault(subDomain, 0)+count);
                }
            }
        }
        List<String> res = new ArrayList<>();
        for (Map.Entry<String, Integer> entry : countMap.entrySet()) {
            res.add(entry.getValue() + " " + entry.getKey());
        }
        return res;
    }
}
