package lib;

public class PasswordValidator {

    /**
     * @param รับ Password ที่เป็น String
     * @return ค่า PasswordStrength INVALID และอื่นๆ
     */
    // TODO: แก้ไข return type ของเมธอดนี้ให้ถูกต้อง
    public static PasswordStrength validate(String password) { // Function Type ให้เป็น PasswordStrength 
        
        if (password == null || password.length() < 8) {
            return PasswordStrength.INVALID;
        }
        boolean Lower = false;
        boolean Upper = false;
        boolean Digit = false;
        boolean Special = false;

        for(char c : password.toCharArray()){
            if (Character.isLowerCase(c)) {
                Lower = true;
            }else if (Character.isUpperCase(c)) {
                Upper = true;
            }else if (Character.isDigit(c)) {
                Digit = true;
            }else if (!Character.isLowerCase(c) && !Character.isUpperCase(c) && !Character.isDigit(c)) {
                Special = true;
            }
        }

        if (Lower && !Upper && !Digit && !Special) return PasswordStrength.WEAK;
        if (Lower && Upper && Digit && !Special) return PasswordStrength.MEDIUM;
        if (Lower && Upper && Digit && Special) return PasswordStrength.STRONG;
        
        return PasswordStrength.INVALID ; // TODO: การคืนค่านี้ถูกต้องหรือไม่?
    }
}