package in.succinct.bpp.cabs.db.model.supply;

import com.venky.swf.db.annotations.column.IS_VIRTUAL;
import com.venky.swf.db.annotations.column.relationship.CONNECTED_VIA;
import com.venky.swf.db.annotations.column.ui.PROTECTION;
import com.venky.swf.db.annotations.column.ui.PROTECTION.Kind;
import in.succinct.bpp.cabs.db.model.demand.Trip;

import java.sql.Date;
import java.util.List;
import java.sql.Timestamp;

public interface User extends com.venky.swf.plugins.collab.db.model.user.User {
    @IS_VIRTUAL
    public boolean isAvailable();

    public Date getDateOfBirth();
    public void setDateOfBirth(Date dateOfBirth);


    @CONNECTED_VIA("PASSENGER_ID")
    List<Trip> getBookedTrips();


    @CONNECTED_VIA("CREATOR_ID")
    List<Vehicle> getOnboardedVehicles();


    List<AuthorizedDriver> getAuthorizedVehicles();

    @IS_VIRTUAL
    List<DriverLogin> getMaxDriverLogins(int max);

    @CONNECTED_VIA("DRIVER_ID")
    List<DriverDocument> getDriverDocuments();

    @IS_VIRTUAL
    public boolean isVerified();

    @IS_VIRTUAL
    public Timestamp isDateOfJoining();

}
