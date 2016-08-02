package pl.droidsonroids.hodor.model;

@SuppressWarnings("FieldCanBeLocal")
public class FCMMessage {

    public static final String USERNAME = "username";

    private String to;
    private Data data;

    public FCMMessage(final String toDeviceToken, final String fromUsername) {
        this.to = toDeviceToken;
        this.data = new Data(fromUsername);
    }

    private class Data {

<<<<<<< HEAD
        private String username;

        public Data(final String username) {
            this.username = username;
        }
=======
        public Data(final String username) {
            this.username = username;
        }

        private String username;
>>>>>>> origin/master
    }
}
