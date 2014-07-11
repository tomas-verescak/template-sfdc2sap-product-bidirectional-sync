/**
 * Mule Anypoint Template
 * Copyright (c) MuleSoft, Inc.
 * All rights reserved.  http://www.mulesoft.com
 */

package org.mule.templates.util;

import org.apache.commons.lang.Validate;
import org.joda.time.DateTime;
import org.joda.time.format.DateTimeFormat;
import org.joda.time.format.DateTimeFormatter;
import org.joda.time.format.ISODateTimeFormat;

/**
 * The function of this class is provide date comparation an transformation
 * functionality.
 * 
 * @author damiansima, MartinZdila
 */
public class DateUtils {

	/**
	 * Validate which date is older.
	 * 
	 * @param dateA
	 *            a string representing a date
	 * @param dateB
	 *            a string representing a date
	 * @return true if the date A is after the date B
	 */
	public static boolean isAfter(String dateA, String dateB, long offsetBetweenAandB) {
		Validate.notEmpty(dateA, "The date A should not be null or empty");
		Validate.notEmpty(dateB, "The date B should not be null or empty");

		DateTimeFormatter formatter = ISODateTimeFormat.dateOptionalTimeParser();

		DateTime lastModifiedDateOfA = formatter.parseDateTime(dateA);
		
		DateTime lastModifiedDateOfB = formatter.parseDateTime(dateB);

		return lastModifiedDateOfA.isAfter(lastModifiedDateOfB.getMillis() + offsetBetweenAandB);
	}

}
