package Company.Anvato;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.logging.Level;
import java.util.logging.Logger;

/*
 * 
 This document contains private instructions intended only for Jiadong (wuplus1992@gmail.com). 
 If you are not Jiadong, please report this to jobs@anvato.com.


 Congratulations for finding the instructions!

 We hope you'll send us your resume to our secret email address hashed below:
 7a025a4b99c77d2398acd6bd15df0f39609220ef89f8b24aa4fac1cf4240fcf4f5c894f5d493d2fce1ed9a8e1028059a01f
 a11f871b9bdaa75a12f72a56ad30adce4c3726536e69faea75d894fde704e0a7b570f55423061ca077ca190e9c03c2ddb1c
 cfa0e8df688fa9a8d749f2ec69d32acb549bb3b6c5e71296e66042ec61e50872597cb98aefd20309a18fc5ce5fe63143493
 7437285ad3fe2650e8d87608c3418e273704a9e0ca8ee2da827fd9724292e8e6a9919d82ee8f395c375adf337930801a885
 be8cd797f1648510e34d0585cab93cdf10fd044ba76b1f25751ba1a4d42a63cc375098c7859b3bfc4889101eccc9999cb04
 e85a6e5c50beb6cf6a9667954edf058f272ce68ea246046598b031d52049cec98fdefdb767dbed56103d13302f88ec2b5a9
 c71032ec7439af6a7bbd75d4f0abb60ef33e704ec467cc6a5de495500fdeb245844f9030838ff414e98cb7739a4b26a85f4
 3bc67f75cbf7ace71622b771f4805082b77c61e6b6fe3ad7029e4e147bf1d18a8f1132fe29d4d1150c7c0b5c47aab36d1b6
 09e8f59dbc546e4b5fa7429d9bc22ab70cf65a1ea7abef28ed0f191544124791c700b974cdea5255915073e6b4835ad8341
 3bfa7

 First, we generated a series of string prefixes with lengths increasing by 2. For example, 
 if our secret email address was helloworld@anvato.com, we would generate:
 he
 hell
 hellow
 hellowor
 ...
 helloworld@anvato.com

 Then, for every prefix s, we computed the following hash J:
 md5(md5(e) + s + md5(s))		[where + is the string concatenation operator and e 
 is your email address].
 Finally, we concatenated all hash strings J to form the long hash above!

 For example, for helloworld@anvato.com,
 we would compute:
 md5(md5('wuplus1992@gmail.com') + 'he' + md5('he')) + 
 md5(md5('wuplus1992@gmail.com') + 'hell' + md5('hell')) + 
 md5(md5('wuplus1992@gmail.com') + 'hellow' + md5('hellow')) + 
 ...

 For the sake of simplicity, you can assume that our email address only contains alphanumeric 
 characters and these 4 characters: _.@+

 After solving the challenge, please email your resume and your solution to the secret email 
 address that you decoded.

 Good Luck!
 */
/**
 *
 * @author Wu
 */
public class Anvato {

    private final String SECRETSTRING = "7a025a4b99c77d2398acd6bd15df0f39609220ef89"
            + "f8b24aa4fac1cf4240fcf4f5c894f5d493d2fce1ed9a8e1028059a01fa"
            + "11f871b9bdaa75a12f72a56ad30adce4c3726536e69faea75d894fde704e0a"
            + "7b570f55423061ca077ca190e9c03c2ddb1ccfa0e8df688fa9a8d749f2ec6"
            + "9d32acb549bb3b6c5e71296e66042ec61e50872597cb98aefd20309a18fc5"
            + "ce5fe631434937437285ad3fe2650e8d87608c3418e273704a9e0ca8ee2da8"
            + "27fd9724292e8e6a9919d82ee8f395c375adf337930801a885be8cd797f16"
            + "48510e34d0585cab93cdf10fd044ba76b1f25751ba1a4d42a63cc375098c"
            + "7859b3bfc4889101eccc9999cb04e85a6e5c50beb6cf6a9667954edf058"
            + "f272ce68ea246046598b031d52049cec98fdefdb767dbed56103d13302f8"
            + "8ec2b5a9c71032ec7439af6a7bbd75d4f0abb60ef33e704ec467cc6a5de4"
            + "95500fdeb245844f9030838ff414e98cb7739a4b26a85f43bc67f75cbf7ac"
            + "e71622b771f4805082b77c61e6b6fe3ad7029e4e147bf1d18a8f1132fe29d"
            + "4d1150c7c0b5c47aab36d1b609e8f59dbc546e4b5fa7429d9bc22ab70cf65a"
            + "1ea7abef28ed0f191544124791c700b974cdea5255915073e6b4835ad83413bfa7";

    private final char[] ENUMS = {'a', 'b', 'c', 'd', 'e', 'f', 'g', 'h', 'i', 'j', 'k', 'l', 'm', 'n', 'o',
        'p', 'q', 'r', 's', 't', 'u', 'v', 'w', 'x', 'y', 'z', '_', '.', '@', '+',
        'A', 'B', 'C', 'D', 'E', 'F', 'G', 'H', 'I', 'J', 'K', 'L', 'M', 'N', 'O', 'P', 'Q', 'R', 'S', 'T', 'U',
        'V', 'W', 'X', 'Y', 'Z', '0', '1', '2', '3', '4', '5', '6', '7', '8', '9'};
    
    /**
     * Decrypt SECRETSTRING two by two
     * @return 
     */
    String decrypt() {
        StringBuilder result = new StringBuilder();
        String[] keys = enumKey();
        String emailMD5 = getMD5("wuplus1992@gmail.com");
        StringBuilder sb = new StringBuilder();
        int index = 0;
        while (index < SECRETSTRING.length()) {
            String secretSubString = SECRETSTRING.substring(index, index + 32);
            for (String key : keys) {
                sb.delete(0, sb.length());
                sb.append(emailMD5);
                String keyMD5 = getMD5(result + key);
                sb.append(result);
                sb.append(key);
                sb.append(keyMD5);
                String combinationMD5 = getMD5(sb.toString());
                if (secretSubString.equals(combinationMD5)) {
                    result.append(key);
                    index = index + 32;
                    break;
                }
            }
        }
        return result.toString();

    }

    /**
     * Get MD5 encryption Refer from
     * http://www.java2s.com/Code/Java/Security/UseMD5toencryptastring.htm
     *
     * @param input
     * @return
     */
    String getMD5(String input) {
        try {
            MessageDigest digester = MessageDigest.getInstance("MD5");
            digester.update(input.getBytes());
            byte[] hash = digester.digest();
            StringBuilder hexString = new StringBuilder();
            for (int i = 0; i < hash.length; i++) {
                if ((0xff & hash[i]) < 0x10) {
                    hexString.append("0");
                    hexString.append(Integer.toHexString((0xFF & hash[i])));
                } else {
                    hexString.append(Integer.toHexString(0xFF & hash[i]));
                }
            }
            return hexString.toString();
        } catch (NoSuchAlgorithmException ex) {
            Logger.getLogger(Anvato.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
    }

    /**
     * enumerate key with length 2
     *
     * @return
     */
    String[] enumKey() {
        int length = ENUMS.length;
        String[] keys = new String[length * length];
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < length; i++) {
            for (int j = 0; j < length; j++) {
                sb.append(ENUMS[i]);
                sb.append(ENUMS[j]);
                keys[i * length + j] = sb.toString();
                sb.delete(0, 2);
            }
        }
        return keys;
    }

    /**
     * Run
     *
     * @param args
     * @throws NoSuchAlgorithmException
     */
    public static void main(String[] args) throws NoSuchAlgorithmException {
        Anvato a = new Anvato();
        String result = a.decrypt();
        System.out.println(result);
    }
}
