package com.spotify.api;

import io.restassured.builder.RequestSpecBuilder;
import io.restassured.builder.ResponseSpecBuilder;
import io.restassured.filter.log.LogDetail;
import io.restassured.http.ContentType;
import io.restassured.specification.RequestSpecification;
import io.restassured.specification.ResponseSpecification;

public class spec {

    static String accessToken="BQAMWjsrixec5DF8vaGepHun6kStLB_PAXMH41vkqjkDTRHNvPpaG8a2XmHTwKPrXi9TQMkYOz8FSpANHMhEoWh9tVVXPjeNTUgR75doL7htMY0BzJIb2FE8bs6VCInuzDwYFBiaNRTpGcN96HOVE-XEFCEHgZD2wnt96JYwvxqNxXBQTHjkmxJnNG_vk92qPfqgKzDK3hdZYgGztp68aZy0v5N5KAisE5OQydfDnJ30kgO4YZ8sUAV3BMHCn7KHlzG4Ooe425gl4X--";

    public static RequestSpecification getRequestspec()
    {
       return new RequestSpecBuilder()
                .setBaseUri("https://api.spotify.com")
                .setBasePath("/v1")
                .addHeader("Authorization","Bearer "+accessToken)
                .setContentType(ContentType.JSON)
                .log(LogDetail.ALL).build();
    }

    public static ResponseSpecification getResponsespec()
    {
        return new ResponseSpecBuilder()
                .log(LogDetail.ALL).build();
    }
}
