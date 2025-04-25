package UGT_Data;

/*
    This small class will hold the one time use code from the user and also
        the timestamp when the code was created
 */
public class ResetCode {
    static private int code = 0; // user's unique one time code
    static private long timestamps = 0; // will be in miliseconds

    // getting the inputs from UserService auth
    public ResetCode(int code){
        ResetCode.code = code;
        timestamps = System.currentTimeMillis();
    }

    // getters for both code and timestamps for use
    public static int getCode(){
        return code;
    }

    public long getTimestamps(){
        return timestamps;
    }
}
