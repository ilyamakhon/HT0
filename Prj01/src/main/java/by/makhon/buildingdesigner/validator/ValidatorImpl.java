package by.makhon.buildingdesigner.validator;

import by.makhon.buildingdesigner.bean.Building;
import by.makhon.buildingdesigner.bean.Room;
import by.makhon.buildingdesigner.exception.*;

import java.util.List;

public class ValidatorImpl implements Validator {
    private static ValidatorImpl ourInstance = new ValidatorImpl();

    private ValidatorImpl() {
    }

    public static ValidatorImpl getInstance() {
        return ourInstance;
    }

    @Override
    public void validate(List<Building> buildings) {
        for (Building building : buildings) {
            for (Room room : building.getRooms()) {
                if (room.getRoomArea() < 1.0) {
                    throw new SpaceUsageToFewException("\nRoom: " + room.getRoomName() + " area = " + room.getRoomArea() +
                            " it should be greater than 1 m2");
                }
                if ( room.getSummaryItemArea() > (room.getRoomArea() * 0.7) ) {
                    throw new SpaceUsageToMuchException("\nRoom: " + room.getRoomName() + " items summary area is " + room.getSummaryItemArea() +
                            " or " + room.getPercentageOfUsingArea() + "%." + " It is greater than 70% of whole room area which is equal to " + room.getRoomArea());
                }
                if (room.getSummaryIlluminance() < 300) {
                    throw new IlluminanceTooFewException("\nRoom: " + room.getRoomName() + " summary illuminance is "
                            + room.getSummaryIlluminance() + " lux. It must be greater than 300 lux");
                }
                if (room.getSummaryIlluminance() > 4000) {
                    throw new IlluminanceTooMuchException("\nRoom: " + room.getRoomName() + " summary illuminance is "
                            + room.getSummaryIlluminance() + " lux. It must be less than 4000 lux");
                }
            }
        }
    }
}
