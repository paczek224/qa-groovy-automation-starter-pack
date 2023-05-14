package com.github.paczek9000.infrastructure.profileresolver;

import lombok.val;
import org.springframework.test.context.ActiveProfilesResolver;
import org.springframework.test.context.support.DefaultActiveProfilesResolver;

public class SystemActivePropertyProfileResolver implements ActiveProfilesResolver {

    DefaultActiveProfilesResolver defaultResolver = new DefaultActiveProfilesResolver();

    @Override
    public String[] resolve(Class<?> testClass) {
        val profileKey = "spring.profiles.active";

        return System.getProperties().containsKey(profileKey) ?
                System.getProperty(profileKey).split("\\s*, \\s*") :
                defaultResolver.resolve(testClass);
    }
}
