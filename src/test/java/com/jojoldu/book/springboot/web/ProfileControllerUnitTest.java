package com.jojoldu.book.springboot.web;

import org.junit.jupiter.api.Test;
import org.springframework.mock.env.MockEnvironment;

import static org.assertj.core.api.Assertions.assertThat;

public class ProfileControllerUnitTest {

    @Test
    public void real_profile_lookup() {
        // given
        String expectedProfile = "real";
        MockEnvironment env = new MockEnvironment();
        env.addActiveProfile(expectedProfile);
        env.addActiveProfile("oauth");
        env.addActiveProfile("real-db");

        ProfileController controller = new ProfileController(env);

        // when
        String profile = String.valueOf(controller.profile());

        // then
        assertThat(profile).isEqualTo(expectedProfile);
    }

    @Test
    public void without_active_profile_lookup_default() {
        // given
        String expectedProfile = "default";
        MockEnvironment env = new MockEnvironment();
        ProfileController controller = new ProfileController(env);

        // when
        String profile = String.valueOf(controller.profile());

        // then
        assertThat(profile).isEqualTo(expectedProfile);
    }
}
