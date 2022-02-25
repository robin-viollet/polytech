package animalmonitoring.procedural;

import animalmonitoring.procedural.Sighting;
import animalmonitoring.procedural.SightingReader;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

/**
 * Monitor counts of different types of animal.
 * Sightings are recorded by spotters.
 *
 * @author David J. Barnes and Michael Kölling
 * @author Peter Sander
 * @author Frédéric Rallo
 * @version 2021.10.01 (functional)
 */
class AnimalMonitor {
    // Records of all the sightings of animals.
    private final List<Sighting> sightings = new ArrayList<>();

    /**
     * Add the sightings recorded in the given filename to the current list.
     * @param filename A CSV file of Sighting records.
     */
    private void addSightings(String filename) {}

    /**
     * Gets the set of all animals spotted.
     * @return Animals spotted.
     */
    private Set<String> getAnimals() {}

    /**
     * Print details of all the sightings.
     */
    private void printList() {}

    /**
     * Print the details of all the sightings of the given animal.
     * @param animal The type of animal.
     */
    private void printSightingsOf(String animal) {}

    /**
     * Print all the sightings by the given spotter.
     * @param spotter The ID of the spotter.
     */
    private void printSightingsBy(int spotter) {}

    /**
     * Print a list of the types of animal considered to be endangered.
     * @param animals A list of animals names.
     * @param dangerThreshold Counts less-than or equal-to to this level
     *                        are considered to be endangered.
     */
    private void printEndangered(List<String> animals, int threshold) {}

    /**
     * Return a count of the number of sightings of the given animal.
     * @param animal The type of animal.
     * @return The count of sightings of the given animal.
     */
    private int getCount(String animal) {}

    /**
     * Remove from the sightings list all of those records with
     * a count of zero.
     */
    private void removeZeroCounts() {}

    /**
     * Return a list of all sightings of the given type of animal
     * in a particular area.
     * @param animal The type of animal.
     * @param area The ID of the area.
     * @return A list of sightings.
     */
    private List<Sighting> getSightingsInArea(String animal, int area) {}

    /**
     * Return a list of all the sightings of the given animal.
     * @param animal The type of animal.
     * @return A list of all sightings of the given animal.
     */
    private List<Sighting> getSightingsOf(String animal) {}
}
