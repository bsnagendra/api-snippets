// Install the Java helper library from twilio.com/docs/java/install
import org.joda.time.DateTime;

import com.google.common.collect.Range;
import com.twilio.Twilio;
import com.twilio.base.ResourceSet;
import com.twilio.rest.api.v2010.account.Recording;

public class Example {
  // Get your Account SID and Auth Token from https://twilio.com/console
  // To set up environment variables, see http://twil.io/secure
  public static final String ACCOUNT_SID = System.getenv("TWILIO_ACCOUNT_SID");
  public static final String AUTH_TOKEN = System.getenv("TWILIO_AUTH_TOKEN");

  public static void main(String[] args) {
    Twilio.init(ACCOUNT_SID, AUTH_TOKEN);

    DateTime lower = DateTime.parse("2016-10-12");
    DateTime upper = DateTime.parse("2016-10-15");

    ResourceSet<Recording> recordings = Recording.reader()
        .setDateCreated(Range.closed(lower, upper))
        .read();

    // Loop over recordings and print out a property for each one.
    for (Recording recording : recordings) {
      System.out.println(recording.getDuration());
    }
  }
}
