/**
 * @author zhanyuhao
 * @time 2021/3/20 9:43
 */
package search;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class wordPttern {

    public boolean wordPattern(String pattern, String s) {
        String[] strs = s.split(" ");
        if (strs.length != pattern.length())
            return false;
        Map<Character, String> map = new HashMap<>();
        Set<String> set = new HashSet<>();
        Character c;
        for (int i = 0; i < pattern.length(); i++) {
            c = pattern.charAt(i);
            if (!map.containsKey(c)) {
                if (set.contains(strs[i]))
                    return false;
                set.add(strs[i]);
                map.put(c, strs[i]);
            } else {
                if (!map.get(c).equals(strs[i]))
                    return false;
            }
        }
        return true;
    }
}
