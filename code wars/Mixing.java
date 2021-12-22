import java.util.ArrayList;
import java.util.Collections;
import java.util.Map;
import java.util.HashMap;
import java.util.TreeMap;

public class Mixing {
    
    public static String mix(String s1, String s2) {
        HashMap<Character, Integer> hash1 = new HashMap<>();
        HashMap<Character, Integer> hash2 = new HashMap<>();
        TreeMap<Integer, ArrayList<String>> finalMap = new TreeMap<>();

        for (Character c : s1.toCharArray()) {
            if (c < 97 || c > 122) continue;

            if (hash1.containsKey(c))
                hash1.put(c, hash1.get(c) + 1);
            else
                hash1.put(c, 1);
        }
        for (Character c : s2.toCharArray()) {
            if (c < 97 || c > 122) continue;

            if (hash2.containsKey(c))
                hash2.put(c, hash2.get(c) + 1);
            else
                hash2.put(c, 1);
        }

        for (Character c : hash1.keySet()) {
            if (hash1.get(c) == 1) continue;

            if (hash2.containsKey(c)) {
                if (hash2.get(c) > hash1.get(c)) {
                    if (!finalMap.containsKey(hash2.get(c))) finalMap.put(hash2.get(c), new ArrayList<>());
                    finalMap.get(hash2.get(c)).add(String.format("2:%c", c));
                    hash2.put(c, 1);
                    continue;
                } else if (hash2.get(c) < hash1.get(c)) {
                    if (!finalMap.containsKey(hash1.get(c))) finalMap.put(hash1.get(c), new ArrayList<>());
                    finalMap.get(hash1.get(c)).add(String.format("1:%c", c));
                    hash2.put(c, 1);
                    continue;
                } else {
                    if (!finalMap.containsKey(hash1.get(c))) finalMap.put(hash1.get(c), new ArrayList<>());
                    finalMap.get(hash1.get(c)).add(String.format("=:%c", c));
                    hash2.put(c, 1);
                    continue;
                }
            } else {
                if (!finalMap.containsKey(hash1.get(c))) finalMap.put(hash1.get(c), new ArrayList<>());
                finalMap.get(hash1.get(c)).add(String.format("1:%c", c));
            }
        }
        for (Character c : hash2.keySet()) {
            if (hash2.get(c) == 1) continue;

            if (!finalMap.containsKey(hash2.get(c))) finalMap.put(hash2.get(c), new ArrayList<>());
            finalMap.get(hash2.get(c)).add(String.format("2:%c", c));
        }

        for (Map.Entry<Integer, ArrayList<String>> entry : finalMap.entrySet()) {
            for (int e = 0; e < entry.getValue().size(); e++) {
                String str = entry.getValue().get(e), tempStr = "";
                char c = str.charAt(2);
                for (int i = 0; i < entry.getKey() - 1; i++)
                    tempStr += c;
                str += tempStr;
                entry.getValue().set(e, str);
            }
        }

        ArrayList<ArrayList<String>> finalArray = new ArrayList<>();
        finalMap.descendingKeySet().forEach(c -> finalArray.add(finalMap.get(c)));

        ArrayList<String> stringArray = new ArrayList<>();
        for (ArrayList<String> array : finalArray) {
            Collections.sort(array);
            for (String str : array)
                stringArray.add(str);
        }

        return String.join("/", stringArray.toArray(String[]::new));
    }

    public static void main(String[] args) {
        System.out.println(mix(" In many languages", " there's a pair of functions"));
    }
}


// public static String mix(String s1, String s2) {
//     int[] aS1 = s1.chars().filter(c -> (c >= 97 && c <= 122)).sorted().toArray();
//     int[] aS2 = s2.chars().filter(c -> (c >= 97 && c <= 122)).sorted().toArray();
//     ArrayList<String> substrings = new ArrayList<>();
//     String substring;
//     int j = 0, b = 0;

//     for (int i = 0, a = 0; i < aS1.length;) {
//         if (aS2[j] > aS1[i]) {
//             while (i < aS1.length && aS2[j] > aS1[i]) {
//                 substring = "1:";
//                 while (i < aS1.length && aS1[a] == aS1[i])
//                     substring += (char) aS1[i++];
//                 substrings.add(substring);
//                 a = i;
//             }
//         } else if (j < aS2.length && (aS1[i] == aS2[j])) {
//             substring = "=:";
//             while ((i < aS1.length && aS1[a] == aS1[i]) || (j < aS2.length && aS2[b] == aS2[j])) {
//                 if (i < aS1.length && aS1[a] == aS1[i]) i++;
//                 if (j < aS2.length && aS2[b] == aS2[j]) j++;
//                 substring += (char) aS1[a];
//             }
//             substrings.add(substring);
//             a = i; b = j;
//         } else {
//             if (j == aS2.length) break;
//             while (j < aS2.length && aS2[j] < aS1[i]) {
//                 substring = "2:";
//                 while (j < aS2.length && aS2[b] == aS2[j])
//                     substring += (char) aS2[j++];
//                 substrings.add(substring);
//                 b = j;
//             }
//         }
//     }

//     while (j < aS2.length) {
//         substring = "2:";
//         while (j < aS2.length && aS2[b] == aS2[j])
//             substring += (char) aS2[j++];
//         substrings.add(substring);
//         b = j;
//     }

//     return String.join("/", substrings);
// }
