package service;

import entidade.Profile;

import java.util.ArrayList;
import java.util.List;

public class ProfileManagerService {
    private List<Profile> profiles;

    public ProfileManagerService() {
        profiles = new ArrayList<>();
    }

    public boolean addProfile(Profile profile) {
        for (Profile existingProfile : profiles) {
            if (existingProfile.getName().equals(profile.getName())) {
                return false;
            }
        }
        profiles.add(profile);
        return true;
    }

    public boolean removeProfile(Profile profile) {
        return profiles.remove(profile);
    }

    public Profile getProfileByName(String name) {
        for (Profile profile : profiles) {
            if (profile.getName().equals(name)) {
                return profile;
            }
        }
        return null;
    }

    public boolean updateProfileAge(String name, int newAge) {
        for (Profile profile : profiles) {
            if (profile.getName().equals(name)) {
                profile.setAge(newAge);
                return true;
            }
        }
        return false;
    }

}
