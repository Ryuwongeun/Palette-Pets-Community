package com.palette.palettepetsback.member.dto;

import java.util.Map;

public class GoogleResponse implements OAuth2Response{

    private final Map<String, Object> attribute;

    public GoogleResponse(Map<String, Object> attribute) {

        this.attribute = attribute;
    }

    @Override
    public String getProvider() {

        return "google";
    }

    @Override
    public String getProviderId() {

        return attribute.get("sub").toString();
    }

    @Override
    public String getEmail() {

        return attribute.get("email").toString();
    }

    @Override
    public String getName() {

        return attribute.get("name").toString();
    }

    @Override
    public String getNickname() {
        return attribute.get("nickname").toString();
    }

    @Override
    public String getProfile_image() {
        return attribute.get("profile_image").toString();
    }

    @Override
    public String getGender() {
        return attribute.get("gender").toString();
    }

    @Override
    public String getBirthday() {
        return attribute.get("birthday").toString();
    }

    @Override
    public String getPhone_number() {
        return attribute.get("phone_number").toString();
    }
}
