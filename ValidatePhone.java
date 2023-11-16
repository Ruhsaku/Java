public interface ValidatePhone {
    static boolean validatePhoneNumber(String phoneNumber) throws WrongPhoneNumberException {
        if (phoneNumber.matches("\\d{10}")) {
            return true;
        } else {
            throw new WrongPhoneNumberException();
        }
    }
}