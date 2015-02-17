/*
 * Compare two version numbers version1 and version2.
 * If version1 > version2 return 1, if version1 < version2 return -1, otherwise return 0.

 * You may assume that the version strings are non-empty and contain only digits and the . character.
 * The . character does not represent a decimal point and is used to separate number sequences.
 * For instance, 2.5 is not "two and a half" or "half way to version three", it is the fifth second-level revision of the second first-level revision.

 * Here is an example of version numbers ordering:
 * 0.1 < 1.1 < 1.2 < 13.37
 */
package Leetcode;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 *
 * @author Wu
 */
public class CompareVersion {

    public int compareVersion(String version1, String version2) {
        String[] split1 = version1.split("\\.");
        String[] split2 = version2.split("\\.");
        int length1 = split1.length;
        int length2 = split2.length;
        int min = Math.min(length1, length2);
        int index;
        for (index = 0; index < min; index++) {
            if (Integer.parseInt(split1[index]) > Integer.parseInt(split2[index])) {
                return 1;
            } else if (Integer.parseInt(split1[index]) < Integer.parseInt(split2[index])) {
                return -1;
            }
        }
        if (length1 == length2) {
            return 0;
        } else if (length1 > length2) {
            while (index < length1) {
                if (Integer.parseInt(split1[index]) > 0) {
                    return 1;
                }
                index++;
            }
            return 0;
        } else {
            while (index < length2) {
                if (Integer.parseInt(split2[index]) > 0) {
                    return -1;
                }
                index++;
            }
            return 0;
        }
    }
}
