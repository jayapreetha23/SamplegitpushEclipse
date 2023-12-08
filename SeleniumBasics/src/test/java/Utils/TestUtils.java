package Utils;

import java.text.SimpleDateFormat;
import java.util.Date;

public class TestUtils {
	public String GetCurrentTime() {
		String cTime = new SimpleDateFormat("yyyyMMdd_HHmm").format(new Date());
		return cTime;
	}
}
