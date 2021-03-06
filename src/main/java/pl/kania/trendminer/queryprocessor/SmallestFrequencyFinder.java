package pl.kania.trendminer.queryprocessor;

import lombok.Data;
import pl.kania.trendminer.db.model.Cooccurrence;
import pl.kania.trendminer.db.model.TimeId;
import pl.kania.trendminer.queryprocessor.cluster.model.CooccurrenceAllPeriods;

import java.util.Map;
import java.util.Set;

public class SmallestFrequencyFinder {

    public long findInTimeId(Set<CooccurrenceAllPeriods> clusterCooccurrences, TimeId timeId, Map<Cooccurrence, Cooccurrence> cooccurrencesInTimeId) {
        final SmallestValue smallest = new SmallestValue();
        clusterCooccurrences.forEach(c -> {
            Cooccurrence cooccurrence = cooccurrencesInTimeId.get(new Cooccurrence(c.getWord1(), c.getWord2(), timeId));
            if (cooccurrence == null) {
                smallest.setValue(0);
            } else {
                long frequency = cooccurrence.getFrequency(timeId.getDocFreq());
                smallest.setValue(Math.min(smallest.value, frequency));
            }
        });

        return smallest.getValue();
    }

    @Data
    static class SmallestValue {
        private long value = Long.MAX_VALUE;
    }
}
