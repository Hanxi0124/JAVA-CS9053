package edu.nyu.cs9053.homework12;

import edu.nyu.cs9053.homework12.model.Region;
import edu.nyu.cs9053.homework12.model.VehicleMake;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.function.Function;
import java.util.stream.Collectors;

/**
 * User: blangel
 * Date: 12/7/16
 * Time: 8:55 AM
 */
public class VehicleMakeFilterer {

    public static List<VehicleMake> loadMatching(Region region, String nameStartsWith, VehicleLoader loader) {
        if ((nameStartsWith == null) || (region == null) || (loader == null)) {
            throw new IllegalArgumentException("Illegal Arguments");
        }
        List<VehicleMake> regionMakes = loader.getVehicleMakesByRegion(region.name());
        if (regionMakes == null) {
            return null;
        }
        List<VehicleMake> matches = new ArrayList<>(regionMakes.size());
        for (VehicleMake make : regionMakes) {
            if ((make.getName() == null) || !make.getName().startsWith(nameStartsWith)) {
                continue;
            }
            matches.add(make);
        }
        return matches;
    }

     public static Optional<List<VehicleMake>> loadMatchingJava8(Region region, String nameStartsWith, VehicleLoader loader) {
          Optional<VehicleLoader> vehicleLoaderOptional = Optional.ofNullable(loader);
         if ((nameStartsWith == null) || (region == null))
             throw new IllegalArgumentException("Illegal Arguments");
         Function<Optional<VehicleLoader>,Optional<List<VehicleMake>>> getOptionalVehicles = (t) -> t.flatMap((r) -> Optional.ofNullable(r.getVehicleMakesByRegion(region.name())));
         return getOptionalVehicles.apply(vehicleLoaderOptional)
                 .flatMap((t) -> Optional.ofNullable(t
                         .stream()
                         .filter(r -> r.getName() != null)
                         .filter(c -> c.getName().startsWith(nameStartsWith))
                         .collect(Collectors.toCollection(ArrayList::new))));
    }
}