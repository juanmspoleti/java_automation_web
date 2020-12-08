package org.backbase.core;

import org.apache.commons.lang3.RandomStringUtils;
import org.apache.commons.lang3.StringUtils;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;

public class Utils {

    /**
     * Get date that are in a format to a custom format (I use Locale.US because this format was not allowed by default)
     * @param originalFormat
     * @param expectedFormat
     * @param date
     * @return
     */
    public static String getFormattedDate(String originalFormat, String expectedFormat, String date) {
        try {
            SimpleDateFormat dateFormatter = new SimpleDateFormat(originalFormat, Locale.US);
            Date dateObject = dateFormatter.parse(date);
            dateFormatter.applyPattern(expectedFormat);
            return dateFormatter.format(dateObject);
        } catch (ParseException e) {
            e.printStackTrace();
            throw new RuntimeException("Error when format was parsed.");
        }
    }

    /**
     * Regex for getting only numbers
     * @param string
     * @return
     */
    public static String getOnlyNumbers(String string){
        return string.replaceAll("\\D+", "");
    }

    /**
     * Fill with random chars i the string parameter has at least one wildcard
     * @param string
     * @return
     */
    public static String fillWithRandom(String string) {
        string = fillWithRandom(string, WildCardTypes.ALPHABETIC);
        string = fillWithRandom(string, WildCardTypes.NUMERIC);
        string = fillWithRandom(string, WildCardTypes.ALPHANUMERIC);
        return string;
    }

    /**
     * Basically for each wildcard type count the matches from that wildacard and replaces with a random char, depending on the wildcard
     * @param string
     * @param wildcard
     * @return
     */
    private static String fillWithRandom(String string, WildCardTypes wildcard) {
        String wildcardSymbol = wildcard.getSymbol();
        int count = StringUtils.countMatches(string, wildcard.getSymbol());
        for (int i = 0; i < count; i++) {
            string = string.replaceFirst(wildcardSymbol, wildcard.getRandom());
        }
        return string;
    }
}

/**
 * Availables Wildcard typesfor getting a random (is customizable)
 */
enum WildCardTypes {

    NUMERIC("#") {
        @Override
        public String getRandom() {
            return RandomStringUtils.randomNumeric(1);
        }
    },
    ALPHABETIC("&") {
        @Override
        public String getRandom() {
            return RandomStringUtils.randomAlphabetic(1);
        }
    },
    ALPHANUMERIC("~") {
        @Override
        public String getRandom() {
            return RandomStringUtils.randomAlphanumeric(1);
        }
    };

    private String symbol;

    WildCardTypes(String symbol) {
        this.symbol = symbol;
    }

    public String getSymbol() {
        return symbol;
    }

    public abstract String getRandom();
}
