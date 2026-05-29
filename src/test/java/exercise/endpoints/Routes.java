package exercise.endpoints;

public class Routes {
    public static final String BASEPATH="/api/v1";
    public static final String  LOGIN="/auth/login";
    public static final String REGISTER="/auth/register";
    public static final String FORGOT_PASSWORD ="/auth/forgot-password";
    public static final String PASSWODRESET="/auth/reset-password/{token}";
    public static final String ME="/auth/me";
    public static final String REFRESH_TOKEN="/auth/refresh";

}