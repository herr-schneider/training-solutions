package collectionshashset;

import java.util.Collection;
import java.util.HashSet;
import java.util.Set;

public class StringsHandler {

    public Set<String> filterUniqueStrings(Collection<String> stringCollection) {
        Set<String> result = new HashSet<>();
        for (String str : stringCollection) {
            result.add(str);
        }
        return result;
    }

    public Set<String> selectIdenticalStrings(Set<String> setA, Set<String> setB) {
        Set<String> copyOfSetA = new HashSet<>(setA);
        Set<String> copyOFSetB = new HashSet<>(setB);
        copyOfSetA.retainAll(copyOFSetB);
        return copyOfSetA;
    }
}
