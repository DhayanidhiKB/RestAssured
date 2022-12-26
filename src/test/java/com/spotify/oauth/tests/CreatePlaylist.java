package com.spotify.oauth.tests;

import com.spotify.oauth2.pojo.Playlist;
import io.restassured.RestAssured;
import io.restassured.builder.RequestSpecBuilder;
import io.restassured.builder.ResponseSpecBuilder;
import io.restassured.filter.log.LogDetail;
import io.restassured.http.ContentType;
import io.restassured.specification.RequestSpecification;
import io.restassured.specification.ResponseSpecification;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import static com.spotify.api.spec.getRequestspec;
import static com.spotify.api.spec.getResponsespec;
import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.equalTo;
import static io.restassured.matcher.RestAssuredMatchers.*;
import static org.hamcrest.Matcher.*;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.*;


public class CreatePlaylist {


    @Test
    public void createPlaylist(){
        RestAssured.useRelaxedHTTPSValidation();

        Playlist requestplaylist=new Playlist()
                .setName("Pojo class playlist")
                .setDescription("Created through Rest API")
                .setPublic(false);


       Playlist responsePlaylist= given(getRequestspec()).body(requestplaylist)
                .when().post("/users/31qzwr2qzqqmkth7whaenytrbtki/playlists")
                .then().spec(getResponsespec()).assertThat().statusCode(201)
                .extract().response().as(Playlist.class);

        assertThat(responsePlaylist.getName(),equalTo(requestplaylist.getName()));
        assertThat(responsePlaylist.getDescription(),equalTo(responsePlaylist.getDescription()));
        assertThat(responsePlaylist.getPublic(),equalTo(responsePlaylist.getPublic()));



    }

  /*  @Test
    public void getPlaylist(){

        RestAssured.useRelaxedHTTPSValidation();

        Playlist requestPlaylist=new Playlist()
                .setName("Pojo class playlist")
                .setDescription("Created through Rest API")
                .setPublic(false);


       Playlist responsePlaylist= given(getRequestspec())
                .when().get("/playlists/4nTxxUo69RAf4b8ACOwUjl")
                .then().spec(getResponsespec()).assertThat().statusCode(200)
               .extract().response().as(Playlist.class);
        assertThat(responsePlaylist.getName(),equalTo(requestPlaylist.getName()));
        assertThat(responsePlaylist.getDescription(),equalTo(responsePlaylist.getDescription()));
        assertThat(responsePlaylist.getPublic(),equalTo(responsePlaylist.getPublic()));
          //31qzwr2qzqqmkth7whaenytrbtki 1UbtizubTujEfDEzN8rkWK

    }*/


   /* public void updatePlaylist()
    {
     RestAssured.useRelaxedHTTPSValidation();
     Playlist requestPlaylist=new Playlist()
             .setName("Pojo class playlist")
             .setDescription("Updated playlist1")
             .setPublic(false);



      given(getRequestspec()).body(requestPlaylist)
                .when().put("/playlists/0XnIToYW1txQqQ0IsDIK1O")
                .then().spec(getResponsespec()).assertThat().statusCode(200);



    }*/
}
