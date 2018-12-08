package com.example.vadim.test_task_inrating;

import com.example.vadim.test_task_inrating.AppItems.PostData;
import com.example.vadim.test_task_inrating.AppItems.PostUsers;
import com.example.vadim.test_task_inrating.AppItems.User;
import com.example.vadim.test_task_inrating.POJO.PostInfo;
import com.example.vadim.test_task_inrating.POJO.Users;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.http.Headers;
import retrofit2.http.POST;
import retrofit2.http.Query;

public interface AppInterface
{
    interface View                                       // интерфейс вывода данных
    {
        void showPostData(PostData postData);            // вывод данных поста

        void showPostUsersData(PostUsers postUsers);     // вывод изображений пользователей

        void showLoadingProgress(boolean show);          // индикатор загрузки поста

        void showUsersLoadingProgress(boolean show);      // индикатор загрузки изображений пользователей
    }

    interface Presenter                                                      // интерфейс представителя (класса-менеджера)
    {
        void initilizePostData();                                            // организация получения данных поста и вывода на экран

        void initilizePostUsers(final String filter, int postId, int delay); // орагизация получения изображений пользоваетелей и вывода их на экран

        void presentPostData();                                              // организация вывода данных поста

        void presentPostUsersData();                                         // организация вывода изображений пользователя

        void refreshAllPostData();                                           // организация обновления всех данных и вывода их на экран
    }

    interface Model                                                                                          // интерфейс бизнес - логики
    {
        void requestPostInfo(String slug, Callback<PostInfo> instruction);                                   // запрос данных поста из API

        void requestUsers(final String filter, final Callback<Users> instruction, Integer id, int delay);     // запрос данных пользователей из API

        boolean RequestPostInfoReady();                                                                      // готовность запроса данных поста

        boolean RequestPostUsersReady();                                                                     // готовность запроса данных пользовтелей

        PostData collectPostData();                                                                          // сбор резельтатов запроста данных поста

        PostUsers collectPostUsers();                                                                        // формирование необходимых данных пользователей для дальнейших операций

        User[] collectUsersFrom(Users source);                                                               // сбор результатов запроса данных пользователей
    }

    interface API                             // интерфейс для взаимодействия с API (согласно инструкций в задании)
    {
        String token =  BuildConfig.token;

        String getPostInfo = "v1/users/posts/get";

        String getUsersLiked = "/v1/users/posts/likers/all";

        String getUsersReposted = "/v1/users/posts/reposters/all";

        String getUsersCommented = "/v1/users/posts/commentators/all";

        String getUsersMentioned = "/v1/users/posts/mentions/all";

        @Headers({"Content-Type: application/json","Accept: application/json", "Authorization: "+token})
        @POST(getPostInfo)
        Call<PostInfo> getPostInfo(@Query("slug") String slug);

        @Headers({"Content-Type: application/json","Accept: application/json", "Authorization: "+token})
        @POST(getUsersLiked)
        Call<Users> getUsersLiked(@Query("id") Integer id);

        @Headers({"Content-Type: application/json","Accept: application/json", "Authorization: "+token})
        @POST(getUsersReposted)
        Call<Users> getUsersReposted(@Query("id") Integer id);

        @Headers({"Content-Type: application/json","Accept: application/json", "Authorization: "+token})
        @POST(getUsersCommented)
        Call<Users> getUsersCommented(@Query("id") Integer id);

        @Headers({"Content-Type: application/json","Accept: application/json", "Authorization: "+token})
        @POST(getUsersMentioned)
        Call<Users> getUsersMentioned(@Query("id") Integer id);
    }

    interface ResponcePOJO{} // маркер POJO класса
}
