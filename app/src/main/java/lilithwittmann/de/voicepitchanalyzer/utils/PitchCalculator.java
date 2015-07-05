package lilithwittmann.de.voicepitchanalyzer.utils;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * Created by Lilith on 04/07/15.
 */
public class PitchCalculator {
    private List<Double> pitches = new ArrayList<Double>();
    // Yes the range is very large - test it and maybe change to something like 85-255
    private Double minPitch = 77.0;
    private Double maxPitch = 480.0;

    public Boolean addPitch(Double pitch) {
        if (pitch > minPitch && pitch < maxPitch) {
            this.pitches.add(pitch);
            return Boolean.TRUE;
        }

        return Boolean.FALSE;
    }

    public List<Double> getPitches() {
        return this.pitches;
    }

    public Double calculatePitchAverage() {
        return this.calculateAverage(this.pitches);
    }

    public Double calculateMaxAverage() {
        List<Double> maxSorted = this.pitches;
        Collections.sort(maxSorted);
        Integer elements = maxSorted.size() / 3;
        return this.calculateAverage(maxSorted.subList(maxSorted.size() - elements, maxSorted.size()));
    }

    public Double calculateMinAverage() {
        List<Double> minSorted = this.pitches;
        Collections.reverse(minSorted);
        Integer elements = minSorted.size() / 3;
        return this.calculateAverage(minSorted.subList(minSorted.size() - elements, minSorted.size()));
    }

    private Double calculateAverage(List<Double> pitches) {
        Double sum = 0.0;
        if (!pitches.isEmpty()) {
            for (Double pitch : pitches) {
                sum += pitch;
            }
            return sum.doubleValue() / pitches.size();
        }
        return sum;
    }
}
