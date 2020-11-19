package geco;

public class PasswordGeneration {

    private static final int TAILLE_PASSWORD = 8;
    private static final String ALPHA_NUMERIC_STRING =
            "ABCDEFGHIJKLMNOPQRSTUVWXYZ"
            + "0123456789"
            + "abcdefghijklmnopqrstuvxyz";


    public String getRandomPassword(){

        StringBuilder sb = new StringBuilder(TAILLE_PASSWORD);
        for (int i = 0; i < TAILLE_PASSWORD; i++) {
            int index
                    = (int)(ALPHA_NUMERIC_STRING.length()
                    * Math.random());
            sb.append(ALPHA_NUMERIC_STRING
                    .charAt(index));
        }
        return sb.toString();
    }
}
