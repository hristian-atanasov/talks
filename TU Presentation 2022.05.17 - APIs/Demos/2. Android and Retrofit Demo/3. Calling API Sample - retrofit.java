public class UserModel {
    
    String userID;
    String firstName;
    String lastName;
    String imagePath;

    // getters and setters
}

public interface UsersService {

    @GET("user/{userID}")
    Call<UserModel> loadUser(@Path("userID") String userID);
}

public void viewLoadData() {
    Retrofit retrofit = new Retrofit.Builder()
        .baseUrl("https://api.appserver.com/")
        .build();

    UsersService usersService = retrofit.create(UsersService.class);
    Call<UserModel> activeUser = usersService.loadUser("bc98d297-73e9-4fcd-801d-f5f405d97b7d");

    //GET "https://api.appserver.com/user/bc98d297-73e9-4fcd-801d-f5f405d97b7d"
    
    // ...
}



// call.enqueue(new Callback<UserModel>() {
//     @Override
//     public void onResponse(Response<UserModel> response) {
//         //
//     }

//     @Override
//     public void onFailure(Throwable t) {
//         //
//     }
// });