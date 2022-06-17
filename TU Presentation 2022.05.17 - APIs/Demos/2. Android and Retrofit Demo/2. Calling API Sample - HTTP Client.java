public class UserModel {
    
    String userID;
    String firstName;
    String lastName;
    String imagePath;

    // getters and setters
}

public class UsersService {

    UserModel loadUser(String userID) {

        HttpClient httpClient = new DefaultHttpClient();

        String apiURL = "https://api.appserver.com"
        String requestPath = apiURL + "/user/" + userID;

        HttpResponse response = httpClient.execute(new HttpGet(requestPath));
        StatusLine statusLine = response.getStatusLine();

        //GET "https://api.appserver.com/user/bc98d297-73e9-4fcd-801d-f5f405d97b7d"

        if(statusLine.getStatusCode() != HttpStatus.SC_OK) {
            response.getEntity().getContent().close();
            throw new IOException(statusLine.getReasonPhrase());
        }

        ByteArrayOutputStream out = new ByteArrayOutputStream();
        response.getEntity().writeTo(out);
        String responseString = out.toString();
        out.close();

        // ...
        // ..more logic/magic ;) за превръщане на responseString в UserModel

        // ВАЖНО - допълнително трябва да extend-нем кода така, че заявката да се пуска в UI Thread-а на App-а - трябва да мине през AsyncTask
    }
}