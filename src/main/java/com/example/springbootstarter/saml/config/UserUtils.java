package com.example.springbootstarter.saml.config;

import org.springframework.security.core.Authentication;
import org.springframework.security.saml.saml2.attribute.Attribute;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

import static org.springframework.security.saml.saml2.attribute.AttributeNameFormat.BASIC;

public final class UserUtils {

    private UserUtils() {
    }

    public static List<IDPUserDetails> getAllUserLoginDetails() {
        /*
        HERE HERE: add any user with any attribute as you need in your
        Note: the userName (IDPUserDetails.userName) should be unique
         */
        return Arrays.asList(
                getSampleUser("admin@test.com", "ADMIN", "Keon", "Lee"),
                getSampleUser("user@test.com", "USER", "Keon", "Lee")
        );
    }

    private static IDPUserDetails getSampleUser(String principal, String roleAttr, String firstNameAttr, String lastNameAttr) {

        List<Attribute> attrs = new ArrayList<>();
        attrs.add(new Attribute().setName("firstName").setValues(Collections.singletonList(firstNameAttr)));
        attrs.add(new Attribute().setName("lastName").setValues(Collections.singletonList(lastNameAttr)));
        attrs.add(new Attribute().setName("role").setValues(Collections.singletonList(roleAttr)));
        attrs.add(new Attribute().setName("https://aws.amazon.com/SAML/Attributes/Role").setNameFormat(BASIC).setValues(Collections.singletonList("")));
        attrs.add(new Attribute().setName("https://aws.amazon.com/SAML/Attributes/RoleSessionName").setNameFormat(BASIC).setValues(Collections.singletonList(principal)));

        return new IDPUserDetails(principal, roleAttr, attrs);
    }


    public static IDPUserDetails getCurrentUserDetails(Authentication authentication) {
        IDPUserDetails userDetails = null;
        if (authentication != null && authentication.getPrincipal() instanceof IDPUserDetails) {
            userDetails = (IDPUserDetails) authentication.getPrincipal();
        }
        return userDetails;
    }

}
